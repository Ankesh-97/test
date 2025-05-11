package org.monetize360.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class ExternalApiService {

    private final RestTemplate restTemplate;

    public <T> ResponseEntity<T> get(String url, Class<T> responseType) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        
        HttpEntity<?> entity = new HttpEntity<>(headers);
        
        return restTemplate.exchange(
            url,
            HttpMethod.GET,
            entity,
            responseType
        );
    }

    public <T> ResponseEntity<T> post(String url, Object request, Class<T> responseType) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        HttpEntity<?> entity = new HttpEntity<>(request, headers);
        
        return restTemplate.exchange(
            url,
            HttpMethod.POST,
            entity,
            responseType
        );
    }
} 