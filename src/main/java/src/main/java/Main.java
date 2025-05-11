package src.main.java;
 
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.ClientProtocolException;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONTokener;
import org.json.JSONException;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class Main {
 
    static final String USERNAME     = "supriya.kumari@dev-monetize360.io";
    static final String PASSWORD     = "Monetize36052AR01ldsYXzxIHz7qWhQWq1j";
    static final String LOGINURL     = "https://login.salesforce.com";
    static final String GRANTSERVICE = "/services/oauth2/token?grant_type=password";
    static final String CLIENTID     = "3MVG95nWQGdmAiEqUBG5oFEztt.aGeAsH6ZQ_0HIdrcNGOumCekf3WBlNUIt5D71QLtz_OsjkGPtsFHNG2U8n";
    static final String CLIENTSECRET = "8A552BE18B96F5FAAD2144F293B29C46588F37ACED50DC72F0F1984302C3B6D8";
    private static String REST_ENDPOINT = "/services/data";
    private static String API_VERSION = "/v58.0";
    private static Header prettyPrintHeader = new BasicHeader("X-PrettyPrint", "1");
    private static String leadId ;
    private static String auth = "00DHr00000126va!AQQAQD.gJAcaPQ_CkYA4vsvsJuBXCYXU0I3NmuVpzkq4BVBvwTf8mW1lB8S8NCpxgae4O7.tKdoi7_9JI8r80Jei.EKUZLww";
 
    public static void main(String[] args) throws Exception {

        //queryLeads();
//        createLeads();
//        updateLeads();
//        deleteLeads();
        //bulkApiQuery("select IsDeleted,MasterRecordId,Name,Type,ParentId,BillingStreet,BillingCity,BillingState,BillingPostalCode,BillingCountry,BillingLatitude,BillingLongitude,BillingGeocodeAccuracy,BillingAddress,ShippingStreet,ShippingCity,ShippingState,ShippingPostalCode,ShippingCountry,ShippingLatitude,ShippingLongitude,ShippingGeocodeAccuracy,ShippingAddress,Phone,Fax,AccountNumber,Website,PhotoUrl,Sic,Industry,AnnualRevenue,NumberOfEmployees,Ownership,TickerSymbol,Description,Rating,Site,OwnerId,CreatedDate,CreatedById,LastModifiedDate,LastModifiedById,SystemModstamp,LastActivityDate,LastViewedDate,LastReferencedDate,Jigsaw,JigsawCompanyId,CleanStatus,AccountSource,DunsNumber,Tradestyle,NaicsCode,NaicsDesc,YearStarted,SicDesc,DandbCompanyId,OperatingHoursId,CustomerPriority__c,SLA__c,Active__c,NumberofLocations__c,UpsellOpportunity__c,SLASerialNumber__c,SLAExpirationDate__c"
               // + "from Account");
        bulkApiQuery("select id, Account.Name from Contact");
    }

    public static void bulkApiQuery(String query) throws Exception {
        System.out.println("\n_______________ Bulk Api query _______________");
        Map<String, String> bodyMap = new HashMap();
        bodyMap.put("operation","query");
        bodyMap.put("query",query);
        JSONObject json = null;
        String queryEndpoint = "/services/data/v58.0/jobs/query";
        var result = getResultUsingWebClientOfBody(queryEndpoint,bodyMap);
        json = new JSONObject(result.getBody());
        if(json.has("id")){
            getQueryResult(json.getString("id"));
        }else{
            throw new RuntimeException();
        }
    }

    private static void getQueryResult(String jobId) throws Exception {
        checkJobStatus(jobId);
        String queryEndpoint = "/services/data/v58.0/jobs/query/"+jobId+"/results";
        executeHttp(queryEndpoint);
    }

    private static void checkJobStatus(String jobId) throws InterruptedException {
        String queryEndpoint = "/services/data/v58.0/jobs/query/"+jobId;
        var json = new JSONObject(getResultUsingWebClient(queryEndpoint).getBody());
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        while(json.has("state") && !json.getString("state").equalsIgnoreCase("JobComplete") && stopWatch.getTotalTimeMillis()<=200000){
            Thread.sleep(10000);
            json = new JSONObject(getResultUsingWebClient(queryEndpoint).getBody());
        }
        stopWatch.stop();
        if(!(json.has("state") && json.getString("state").equalsIgnoreCase("JobComplete"))){
            throw new RuntimeException();
        }
    }

    public static void executeHttp(String queryEndpoint) throws Exception {

        String endPoint = "https://monetize3605-dev-ed.develop.my.salesforce.com" +  queryEndpoint;

        Header oauthHeader = new BasicHeader("Authorization", "OAuth " + auth);

        HttpClient apiClient = HttpClientBuilder.create().build();
        HttpGet httpPost = new HttpGet(endPoint);
        httpPost.setHeaders(new Header[]{oauthHeader});

        HttpResponse response = apiClient.execute(httpPost);

        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            HttpEntity entity = response.getEntity();
            var inputStream = entity.getContent();
            String tempDir = System.getProperty("java.io.tmpdir");
            //TODO: File name to be decided
            String fileName = tempDir+ "\\file4.csv";
            try(OutputStream outputStream = new FileOutputStream(fileName);){
                int byteRead;
                while ((byteRead = inputStream.read()) != -1) {
                    outputStream.write(byteRead);
                }
                inputStream.close();
                try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                    List<Map<String, Object>> listOfMap = new ArrayList<>();
                    CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader());
                    List<String> headers = csvParser.getHeaderNames();
                    List<CSVRecord> records = csvParser.getRecords();
                    for (CSVRecord csvRecord : records) {
                        Map<String, Object> map = new HashMap<>();
                        for (int i = 0; i < csvRecord.size(); i++) {
                            map.put(headers.get(i), csvRecord.get(i));
                        }
                        listOfMap.add(map);
                    }
                   System.out.println(listOfMap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }catch (Exception e){
                throw new RuntimeException();
            }


        } else {
            System.out.println("Request was unsuccessful. Status code: " + statusCode);
        }
    }

    public static void queryLeads() throws JsonProcessingException {
        System.out.println("\n_______________ Lead QUERY _______________");

        JSONArray resultantJsonArray = new JSONArray();
        JSONArray jsonArray = null;
        JSONObject json = null;
        String queryEndpoint = "";
        queryEndpoint ="/services/data/v58.0/query/?q=SELECT+name+from+Account";
        var result = getResultUsingWebClient(queryEndpoint);
        json = new JSONObject(result.getBody());
        jsonArray = json.getJSONArray("records");
        resultantJsonArray.putAll(jsonArray);
        while(json.has("nextRecordsUrl")){
            queryEndpoint = json.getString("nextRecordsUrl");
            System.out.println(resultantJsonArray.length());
            var nextResult = getResultUsingWebClient(queryEndpoint);
            json = new JSONObject(nextResult.getBody());
            jsonArray = json.getJSONArray("records");
            resultantJsonArray.putAll(jsonArray);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        var list =objectMapper.readValue(jsonArray.toString(),List.class);
        System.out.println(list);
    }

    public static ResponseEntity<String> getResultUsingWebClient(String endpoint){
        return webClient().get().uri("https://monetize3605-dev-ed.develop.my.salesforce.com" + endpoint).
                header("Authorization", "OAuth " + auth).
                header("X-PrettyPrint", "1").retrieve().toEntity(String.class).block();
    }

    public static ResponseEntity<String> getResultUsingWebClientOfBody(String endpoint,Map<String,String> bodyMap){
        return webClient().post().uri("https://monetize3605-dev-ed.develop.my.salesforce.com"+endpoint).header("Authorization", "OAuth " + auth).
                header("X-PrettyPrint", "1").body(BodyInserters.fromValue(bodyMap)).retrieve().toEntity(String.class).block();
    }

    public static WebClient webClient() {
        final int size = 16 * 1024 * 1024;
        final ExchangeStrategies strategies = ExchangeStrategies.builder()
                .codecs(codecs -> codecs.defaultCodecs().maxInMemorySize(size))
                .build();
        return WebClient.builder()
                .exchangeStrategies(strategies)
                .build();
    }

    // Create Leads using REST HttpPost
//    public static void createLeads() {
//        System.out.println("\n_______________ Lead INSERT _______________");
//
//        String uri = baseUri + "/sobjects/Lead/";
//        try {
//
//            //create the JSON object containing the new lead details.
//            JSONObject lead = new JSONObject();
//            lead.put("FirstName", "REST API");
//            lead.put("LastName", "Lead");
//            lead.put("Company", "asagarwal.com");
//
//            System.out.println("JSON for lead record to be inserted:\n" + lead.toString(1));
//
//            //Construct the objects needed for the request
//            HttpClient httpClient = HttpClientBuilder.create().build();
//
//            HttpPost httpPost = new HttpPost(uri);
//            httpPost.addHeader(oauthHeader);
//            httpPost.addHeader(prettyPrintHeader);
//            // The message we are going to post
//            StringEntity body = new StringEntity(lead.toString(1));
//            body.setContentType("application/json");
//            httpPost.setEntity(body);
//
//            //Make the request
//            HttpResponse response = httpClient.execute(httpPost);
//
//            //Process the results
//            int statusCode = response.getStatusLine().getStatusCode();
//            if (statusCode == 201) {
//                String response_string = EntityUtils.toString(response.getEntity());
//                JSONObject json = new JSONObject(response_string);
//                // Store the retrieved lead id to use when we update the lead.
//                leadId = json.getString("id");
//                System.out.println("New Lead id from response: " + leadId);
//            } else {
//                System.out.println("Insertion unsuccessful. Status code returned is " + statusCode);
//            }
//        } catch (JSONException e) {
//            System.out.println("Issue creating JSON or processing results");
//            e.printStackTrace();
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        } catch (NullPointerException npe) {
//            npe.printStackTrace();
//        }
//    }
//
//    // Update Leads using REST HttpPatch. We have to create the HTTPPatch, as it does not exist in the standard library
//    // Since the PATCH method was only recently standardized and is not yet implemented in Apache HttpClient
//    public static void updateLeads() {
//        System.out.println("\n_______________ Lead UPDATE _______________");
//
//        //Notice, the id for the record to update is part of the URI, not part of the JSON
//        String uri = baseUri + "/sobjects/Lead/" + leadId;
//        try {
//            //Create the JSON object containing the updated lead last name
//            //and the id of the lead we are updating.
//            JSONObject lead = new JSONObject();
//            lead.put("LastName", "Lead --UPDATED");
//            System.out.println("JSON for update of lead record:\n" + lead.toString(1));
//
//            //Set up the objects necessary to make the request.
//            //DefaultHttpClient httpClient = new DefaultHttpClient();
//            HttpClient httpClient = HttpClientBuilder.create().build();
//
//            HttpPatch httpPatch = new HttpPatch(uri);
//            httpPatch.addHeader(oauthHeader);
//            httpPatch.addHeader(prettyPrintHeader);
//            StringEntity body = new StringEntity(lead.toString(1));
//            body.setContentType("application/json");
//            httpPatch.setEntity(body);
//
//            //Make the request
//            HttpResponse response = httpClient.execute(httpPatch);
//
//            //Process the response
//            int statusCode = response.getStatusLine().getStatusCode();
//            if (statusCode == 204) {
//                System.out.println("Updated the lead successfully.");
//            } else {
//                System.out.println("Lead update NOT successfully. Status code is " + statusCode);
//            }
//        } catch (JSONException e) {
//            System.out.println("Issue creating JSON or processing results");
//            e.printStackTrace();
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        } catch (NullPointerException npe) {
//            npe.printStackTrace();
//        }
//    }
//
//    // Extend the Apache HttpPost method to implement an HttpPatch
//    private static class HttpPatch extends HttpPost {
//        public HttpPatch(String uri) {
//            super(uri);
//        }
//
//        public String getMethod() {
//            return "PATCH";
//        }
//    }
//
//    // Update Leads using REST HttpDelete (We have to create the HTTPDelete, as it does not exist in the standard library.)
//    public static void deleteLeads() {
//        System.out.println("\n_______________ Lead DELETE _______________");
//
//        //Notice, the id for the record to update is part of the URI, not part of the JSON
//        String uri = baseUri + "/sobjects/Lead/" + leadId;
//        try {
//            //Set up the objects necessary to make the request.
//            HttpClient httpClient = HttpClientBuilder.create().build();
//
//            HttpDelete httpDelete = new HttpDelete(uri);
//            httpDelete.addHeader(oauthHeader);
//            httpDelete.addHeader(prettyPrintHeader);
//
//            //Make the request
//            HttpResponse response = httpClient.execute(httpDelete);
//
//            //Process the response
//            int statusCode = response.getStatusLine().getStatusCode();
//            if (statusCode == 204) {
//                System.out.println("Deleted the lead successfully.");
//            } else {
//                System.out.println("Lead delete NOT successful. Status code is " + statusCode);
//            }
//        } catch (JSONException e) {
//            System.out.println("Issue creating JSON or processing results");
//            e.printStackTrace();
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        } catch (NullPointerException npe) {
//            npe.printStackTrace();
//        }
//    }
//
//    private static String getBody(InputStream inputStream) {
//        String result = "";
//        try {
//            BufferedReader in = new BufferedReader(
//                    new InputStreamReader(inputStream)
//            );
//            String inputLine;
//            while ( (inputLine = in.readLine() ) != null ) {
//                result += inputLine;
//                result += "\n";
//            }
//            in.close();
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
//        }
//        return result;
//    }
}
