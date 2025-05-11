package org.example.services;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import org.example.enums.JfrogProjects;
import org.example.util.Utility;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.example.util.Config.*;

public class JfrogUtil {

    private static final String JFROG_URL_TEMPLATE = "https://monetize360.jfrog.io/ui/api/v1/xray/ui/component/exportComponentDetails";
    private static final String JFROG_ZIPPED_FOLDER_PATH = JFROG_OUTPUT_FOLDER+"/zipped";
    private static final String JFROG_UNZIPPED_FOLDER_PATH = JFROG_OUTPUT_FOLDER+"/unzipped";
    private static final String JFROG_HIGH_SEVERITY_FOLDER_PATH = JFROG_OUTPUT_FOLDER+"/severity_high";

    public void start() throws IOException {
        File zippedFile = new File(JFROG_ZIPPED_FOLDER_PATH);
        zippedFile.mkdir();
        File unzippedFile = new File(JFROG_UNZIPPED_FOLDER_PATH);
        unzippedFile.mkdir();
        File failedReportFolder = new File(JFROG_HIGH_SEVERITY_FOLDER_PATH);
        failedReportFolder.mkdir();
        generateJFrogReports(zippedFile.getPath());
        unzipFile(zippedFile.getPath(),unzippedFile.getPath());
        int numberOfFailedReport = generateFailedSonarReport(JFROG_HIGH_SEVERITY_FOLDER_PATH,JFROG_UNZIPPED_FOLDER_PATH);
        if (numberOfFailedReport > 0) {
            Utility.pdfMerger(JFROG_HIGH_SEVERITY_FOLDER_PATH, JFROG_HIGH_SEVERITY_OUTPUT_FILE);
            System.out.println("Sonar Failed report generated at -" + JFROG_HIGH_SEVERITY_OUTPUT_FILE);
        }
        Utility.deleteFolder(new File(JFROG_HIGH_SEVERITY_FOLDER_PATH));
        Utility.pdfMerger(JFROG_UNZIPPED_FOLDER_PATH, JFROG_OUTPUT_FILE);


    }

    private void generateJFrogReports(String zippedFolderPath) {

        List<String> listOfJfrog = JfrogProjects.getJfrogNames();
        listOfJfrog.forEach(item-> {
            try {
                Utility.doHttpClientCall(getJfrogUrlTemplate(item,JFROG_TAG),item.replace("-","_"),zippedFolderPath,JFROG_COOKIE,"zip");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    public String getJfrogUrlTemplate(String project, String tag) {
        String url = JFROG_URL_TEMPLATE + getParams(project, tag);
        return url;
    }

    private String getParams(String project, String tag){
        Map<String,String> map = new HashMap<>();
        map.put("comp_name",project+"%3A"+tag);
        map.put("prefix","docker");
        map.put("format","pdf");
        map.put("path","new-base-image%2F"+project+"%2F"+tag+"%2Fmanifest.json");
        map.put("vulnerabilities","true");
        map.put("exclude_unknown","false");
        map.put("include_ignored_violations","false");

        StringBuilder queryString = new StringBuilder("?");

        map.entrySet().stream().forEach(entry->{
            if (queryString.length() > 1) {
                queryString.append("&");
            }
            queryString.append(entry.getKey()).append("=").append(entry.getValue());
        });
        return queryString.toString();
    }

    private void unzipFile(String zipFilePath, String destDirectory) throws IOException {
        File destDir = new File(destDirectory);
        if (!destDir.exists() && (!destDir.mkdir())){
                throw new RuntimeException();
        }
        File folder = new File(zipFilePath);
        File[] listFiles = folder.listFiles();
        List<File> fileList = Arrays.asList(listFiles);
        fileList.stream().filter(file->file.getName().contains(".zip")).forEach(file->{
            ZipEntry entry = null;
            try(ZipInputStream zipIn = new ZipInputStream(new FileInputStream(file))) {
                entry = zipIn.getNextEntry();
                readZipFile(entry,destDirectory,zipIn);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void readZipFile( ZipEntry entry,String destDirectory,ZipInputStream zipIn) throws IOException {
        while (entry != null) {
            String filePath = destDirectory + File.separator + entry.getName();
            if (!entry.isDirectory()) {
                extractFile(zipIn, filePath);
            } else {
                File dir = new File(filePath);
                if(!dir.mkdir()){
                    throw new IOException();
                }
            }
            zipIn.closeEntry();
            entry = zipIn.getNextEntry();
        }
    }

    private void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        byte[] buffer = new byte[1024];
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            int len;
            while ((len = zipIn.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }
        } catch (Exception e) {
            throw new IOException();
        }
    }

    private Integer generateFailedSonarReport(String failedReportPath, String allReportPath) {
        File folder = new File(allReportPath);
        File[] listFiles = folder.listFiles();
        List<File> listOfFiles = Arrays.asList(listFiles);
        AtomicInteger countFailedReport = new AtomicInteger();
        listOfFiles.stream().filter(file -> {
            try {
                return pdfReader(file.getPath());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).forEach(file -> {
            countFailedReport.getAndIncrement();
            String filename = file.getName();
            try (OutputStream outputStream = new FileOutputStream(failedReportPath + "\\" + filename); InputStream inputStream = new FileInputStream(file)) {
                inputStream.transferTo(outputStream);
            } catch (Exception e) {
                System.out.println(e);
            }
        });
        return countFailedReport.get();
    }

    public boolean pdfReader(String filePath) throws IOException {

        PdfReader reader = new PdfReader(filePath);
        int pages = reader.getNumberOfPages();
        StringBuilder text = new StringBuilder();
        for (int i = 1; i <= pages; i++) {
            text.append(PdfTextExtractor.getTextFromPage(reader, i));
        }
        reader.close();
        if (text.toString().contains("High")) {
            return true;
        } else {
            return false;
        }
    }
}
