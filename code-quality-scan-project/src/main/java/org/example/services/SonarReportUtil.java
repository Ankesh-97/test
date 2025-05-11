package org.example.services;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import org.example.enums.SonarBackendProjects;
import org.example.enums.SonarUIProjects;
import org.example.util.Utility;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.example.util.Config.*;

public class SonarReportUtil {

    private static final String SONAR_URL_TEMPLATE = "https://sonar.mtz360.com/api/bitegarden/report/pdf?resource=%s&branch=%s";

    private static final String SONAR_FOLDER_PATH = SONAR_OUTPUT_FOLDER + "/sonar_reports";
    private static final String SONAR_FAILED_FOLDER_PATH = SONAR_OUTPUT_FOLDER + "/Failed_sonar_reports";

    public void start() throws IOException {

        File file = new File(SONAR_FOLDER_PATH);
        file.mkdir();
        generateSonarReports();
        File failedReportFolder = new File(SONAR_FAILED_FOLDER_PATH);
        failedReportFolder.mkdir();

        int numberOfFailedReport = generateFailedSonarReport(SONAR_FAILED_FOLDER_PATH, SONAR_FOLDER_PATH);
        if (numberOfFailedReport > 0) {
            Utility.pdfMerger(SONAR_FAILED_FOLDER_PATH, SONAR_FAILED_OUTPUT_FILE);
            System.out.println("Sonar Failed report generated at -" + SONAR_FAILED_OUTPUT_FILE);
        }
        Utility.deleteFolder(new File(SONAR_FAILED_FOLDER_PATH));
        Utility.pdfMerger(SONAR_FOLDER_PATH, SONAR_OUTPUT_FILE);
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

    private void generateSonarReports() {
        List<String> listOfBackend = SonarBackendProjects.getBackendNames();
        List<String> listOfUI = SonarUIProjects.getUINames();
        listOfBackend.forEach(item -> {
            try {
                Utility.doHttpClientCall(getSonarBackendUrlTemplate(item, BRANCH), item.replace("-", "_"), SONAR_FOLDER_PATH, SONAR_COOKIE, "pdf");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        listOfUI.forEach(item -> {
            try {
                Utility.doHttpClientCall(getSonarUIUrlTemplate(item, BRANCH), item.replace("-", "_"), SONAR_FOLDER_PATH, SONAR_COOKIE, "pdf");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public String getSonarUIUrlTemplate(String project, String branch) {
        String component = "com.monetize360:" + project;
        return String.format(SONAR_URL_TEMPLATE, component, branch);
    }

    public String getSonarBackendUrlTemplate(String project, String branch) {
        String component = "io.monetize360:" + project;
        return String.format(SONAR_URL_TEMPLATE, component, branch);
    }

    public boolean pdfReader(String filePath) throws IOException {

        PdfReader reader = new PdfReader(filePath);
        int pages = reader.getNumberOfPages();
        StringBuilder text = new StringBuilder();
        for (int i = 1; i <= pages; i++) {
            text.append(PdfTextExtractor.getTextFromPage(reader, i));
        }
        reader.close();

        if (text.toString().contains("FAILED")) {
            return true;
        } else {
            return false;
        }
    }

}
