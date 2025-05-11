package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SalesforceOAuthExample {

    // Salesforce credentials and endpoints
    private static final String TOKEN_URL = "https://login.salesforce.com/services/oauth2/token";
    private static final String CLIENT_ID = "3MVG9Rr0EZ2YOVMYLEA59hmLS772xtRTsik4Sui47jXNvGf5mv047qwmkA8JJsQLRLHqG_RD6HS9ADWFmXP5D";
    private static final String CLIENT_SECRET = "983282DDAF0DE7FE704970E693E6F1115A1FB508BC60EBF71AA6A74DE9DE45F2";
    private static final String GRANT_TYPE = "client_credentials";

    public static void main(String[] args) {
        try {
            String accessToken = getAccessToken();
            if (accessToken != null) {
                // Use the access token to make an API call to Salesforce
                makeApiCall(accessToken);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to get an access token from Salesforce
    private static final String USERNAME = "Naresh@h360.sandbox";
    private static final String PASSWORD = "Monetize@360"; // Add security token if needed

    private static String getAccessToken() throws Exception {
        URL url = new URL(TOKEN_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setDoOutput(true);

        // Using password grant type instead of client_credentials
        String parameters = "grant_type=password" +
                "&client_id=" + URLEncoder.encode(CLIENT_ID, "UTF-8") +
                "&client_secret=" + URLEncoder.encode(CLIENT_SECRET, "UTF-8") +
                "&username=" + URLEncoder.encode(USERNAME, "UTF-8") +
                "&password=" + URLEncoder.encode(PASSWORD, "UTF-8");

        try (OutputStream os = connection.getOutputStream()) {
            os.write(parameters.getBytes());
            os.flush();
        }

        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            ObjectMapper mapper = new ObjectMapper();
            JsonNode response = mapper.readTree(in);
            String accessToken = response.get("access_token").asText();
            in.close();
            System.out.println("Access Token: " + accessToken);
            return accessToken;
        } else {
            BufferedReader errorStream = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            String errorLine;
            StringBuilder errorResponse = new StringBuilder();
            while ((errorLine = errorStream.readLine()) != null) {
                errorResponse.append(errorLine);
            }
            errorStream.close();
            System.out.println("Error Response: " + errorResponse.toString());
            throw new RuntimeException("Failed to obtain access token: " + connection.getResponseMessage());
        }
    }



    // Method to make an API call to Salesforce using the access token
    private static void makeApiCall(String accessToken) throws Exception {
        String apiUrl = "https://hilyar-dev-ed.develop.lightning.force.com/services/data/v61.0/sobjects/Account";

        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", "Bearer " + accessToken);

        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println("API Response: " + response.toString());
        } else {
            System.out.println("Failed to make API call: " + connection.getResponseMessage());
        }
    }
}
