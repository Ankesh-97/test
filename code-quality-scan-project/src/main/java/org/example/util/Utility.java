package org.example.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.pdfbox.io.IOUtils;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Utility {

    public static void deleteFolder(File folder) {
        if (folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    deleteFolder(file);
                }
            }
        }
        if (!folder.delete()) {
            System.err.println("Failed to delete folder: " + folder.getAbsolutePath());
        } else {
            System.out.println("Folder deleted successfully: " + folder.getAbsolutePath());
        }
    }

    public static void pdfReader(String filePath) throws IOException {
        PDDocument document = new PDDocument();
        document.save(new File(filePath));
        PDFTextStripper stripper = new PDFTextStripper();
        String text = stripper.getText(document);
        document.close();
    }

    public static void pdfMerger(String folderPath, String outputFileName) throws IOException {
        PDFMergerUtility pdfMergerUtility = new PDFMergerUtility();
        File folder = new File(folderPath);
        File[] listFiles = folder.listFiles();
        List<File> listOfFiles = Arrays.asList(listFiles);

        AtomicInteger i = new AtomicInteger();
        AtomicInteger j = new AtomicInteger(listOfFiles.size());
        listOfFiles.stream().forEach(f -> {
            try {
                System.out.println(String.format("%s of %s", i.getAndIncrement(), j.get()));
                if(f.getName().contains(outputFileName))
                    f.delete();

                else if(f.getName().contains(".pdf")){
                    pdfMergerUtility.addSource(f);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        pdfMergerUtility.setDestinationFileName(outputFileName);
        pdfMergerUtility.mergeDocuments(IOUtils.createTempFileOnlyStreamCache());

    }

    public static void writeToFile(InputStream inputStream, String filePath) throws IOException {
        File file = new File(filePath);
        if(!file.exists()){
            if(!file.createNewFile()){
                throw new RuntimeException();
            }
        }
        try (OutputStream outputStream = new FileOutputStream(filePath)) {

            inputStream.transferTo(outputStream);
            inputStream.close();
        }
        catch (Exception e) {
            throw  new RuntimeException();
        }
    }

    public static void doHttpClientCall(String url, String serviceName,String folderPath,String cookie,String fileType) throws IOException {
        int connectionTimeout = 50000;
        int socketTimeout = 50000;
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(connectionTimeout)
                .setSocketTimeout(socketTimeout)
                .build();
        CloseableHttpClient client = HttpClients.custom()
                .setDefaultRequestConfig(requestConfig)
                .build();
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("Cookie", cookie);
        httpGet.addHeader("Connection", "keep-alive");
        HttpResponse response = client.execute(httpGet);
        InputStream inputStream = response.getEntity().getContent();
        String file = String.format("%s\\%s.%s", String.format(folderPath), serviceName,fileType);
        System.out.println("Processing File " + file);
        writeToFile(inputStream, file);
    }
}
