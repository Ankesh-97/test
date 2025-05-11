package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {

    private static final String DEFAULT_CONFIG_PATH = "base-template.json";
    private static final Pattern TOKEN_PATTERN = Pattern.compile("\\{\\{([^\\}\\}]*)\\}\\}", Pattern.CASE_INSENSITIVE);
    private static final String emailTemplate = "You have been requested to approve an account setup in the {{company_name}} System. <br/><br/> Account Number : {{number}}<br/><br/> Account Name : {{name}}<br/><br/> Please login to <a><b><u>{{application_link}}</b></u></a> to view this request in the My approvals folder. <br/><br/> If you need additional information about this request, please contact the submitter. For technical assistance, please contact your systems administrator. <br/><br/> Thank you, <br/><br/> {{company_name}} System Approvals.";

    public static void main(String[] args) throws IOException {
//         String path = "m360-template-config.pages[0].frames[0].component.components[0].components[1].components[0].components[1].content";
//        String val = new String(Files.readAllBytes(Paths.get(Test1.class
//                .getClassLoader()
//                .getResource(DEFAULT_CONFIG_PATH)
//                .getPath())));

//        try (InputStream inputStream = Test1.class.getClassLoader().getResourceAsStream(DEFAULT_CONFIG_PATH)) {
//            if (inputStream == null) {
//                throw new IllegalArgumentException("File not found: " + DEFAULT_CONFIG_PATH);
//            }
//
//            // Convert JSON to Map
//            ObjectMapper mapper = new ObjectMapper();
//            Map<String,Object> map = mapper.readValue(inputStream, new TypeReference<>() {});
//
//
//                String config = mapper.writeValueAsString(map);
//                Pattern pattern = Pattern.compile("\\{\\{\\s*content_\\s*\\}\\}");
//                Matcher matcher = pattern.matcher(config);
//                if(matcher.find()){
//                    String replacedConfig = matcher.replaceAll("This String is replaced");
//                    Map<String, Object> replacedMap = mapper.readValue(replacedConfig, new TypeReference<>() {});
//                    System.out.println("Map: " + replacedMap);
//                }else{
//                    System.out.println("Error while replacing content in email template");
//                }
//        }

        //extractTokens(emailTemplate, "Approval Request for {{company_name}} Account Setup");
        Map<String, Integer> map = Map.of("1",1);
        List<String> list = List.of("2","3");
        System.out.println(list.stream().map(map::get).toList());
        //System.out.println(DataType.STRING);
    }

    public static Map<String, Object> extractTokens(String emailTemplate, String subject){
        Map<String,Object> tokens = new HashMap<>();
        Matcher subjectMatcher = TOKEN_PATTERN.matcher(subject);
        while(subjectMatcher.find()) {
            String content = subjectMatcher.group(1);
            tokens.put(content, getTokenMap(content));
        }
        Matcher templateMatcher = TOKEN_PATTERN.matcher(emailTemplate);
        while(templateMatcher.find()) {
            String content = templateMatcher.group(1);
            tokens.put(content, getTokenMap(content));
        }
        return tokens;
    }

    private static Map<String,Object> getTokenMap(String token){
        Map<String, Object> map = new HashMap<>();

        map.put("groupBy", false);
        map.put("dataType", "STRING");
        map.put("rowGroup", false);
        map.put("encrypted", false);
        map.put("fieldName", token);
        map.put("fieldType", "FIELD");
        map.put("fieldLabel", token);
        map.put("roundOffTo", 0);
        map.put("monthOffset", 0);
        map.put("decimalPlaces", 0);
        map.put("pivotSummarizeBy", List.of());

        return map;
    }

    public static Map<String,Object> getMetadataMap(Map<String,Object> jsonMap) {

        Map<String, Object> templateConfig = (Map<String, Object>) jsonMap.get("m360-template-config");
        List<Map<String, Object>> pages = (List<Map<String, Object>>) templateConfig.get("pages");
        Map<String, Object> page = pages.get(0);
        List<Map<String, Object>> frames = (List<Map<String, Object>>) page.get("frames");
        Map<String, Object> frame = frames.get(0);
        Map<String, Object> component = (Map<String, Object>) frame.get("component");
        List<Map<String, Object>> components = (List<Map<String, Object>>) component.get("components");
        Map<String, Object> firstComponent = components.get(0);
        List<Map<String, Object>> nestedComponents = (List<Map<String, Object>>) firstComponent.get("components");
        Map<String, Object> secondComponent = nestedComponents.get(1);
        List<Map<String, Object>> deeperComponents = (List<Map<String, Object>>) secondComponent.get("components");
        Map<String, Object> deeperFirstComponent = deeperComponents.get(0);
        List<Map<String, Object>> deepestComponents = (List<Map<String, Object>>) deeperFirstComponent.get("components");
        return deepestComponents.get(1);
    }
}

enum DataType {
    STRING,
    INTEGER,
    DOUBLE,
    DATE,
    BOOLEAN
}
