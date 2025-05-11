package org.monetize360.shop.service;

import lombok.RequiredArgsConstructor;
import org.monetize360.shop.config.CommercetoolsProperties;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CommercetoolsApiService {

    private final RestTemplate restTemplate;
    private final CommercetoolsAuthService authService;
    private final CommercetoolsProperties properties;

    public ResponseEntity<String> getProjectInfo() {
        HttpHeaders headers = createAuthenticatedHeaders();
        HttpEntity<?> entity = new HttpEntity<>(headers);
        
        String url = properties.getApiUrl() + "/" + properties.getProjectKey();
        return restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    }

    public <T> ResponseEntity<T> get(String endpoint, Class<T> responseType) {
        HttpHeaders headers = createAuthenticatedHeaders();
        HttpEntity<?> entity = new HttpEntity<>(headers);
        
        String url = properties.getApiUrl() + "/" + properties.getProjectKey() + endpoint;
        return restTemplate.exchange(url, HttpMethod.GET, entity, responseType);
    }

    public <T> ResponseEntity<T> post(String endpoint, Object request, Class<T> responseType) {
        HttpHeaders headers = createAuthenticatedHeaders();
        HttpEntity<?> entity = new HttpEntity<>(request, headers);
        
        String url = properties.getApiUrl() + "/" + properties.getProjectKey() + endpoint;
        return restTemplate.exchange(url, HttpMethod.POST, entity, responseType);
    }

    private HttpHeaders createAuthenticatedHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(authService.getAccessToken());
        return headers;
    }
} 