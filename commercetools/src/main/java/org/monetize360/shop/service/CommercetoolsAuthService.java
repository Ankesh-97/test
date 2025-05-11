package org.monetize360.shop.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.monetize360.shop.config.CommercetoolsProperties;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommercetoolsAuthService {

    private final RestTemplate restTemplate;
    private final CommercetoolsProperties properties;

    public String getAccessToken() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setBasicAuth(properties.getClientId(), properties.getClientSecret());

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "client_credentials");
        body.add("scope", properties.getScopes());

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);

        try {
            ResponseEntity<TokenResponse> response = restTemplate.exchange(
                properties.getAuthUrl() + "/oauth/token",
                HttpMethod.POST,
                entity,
                TokenResponse.class
            );

            if (response.getBody() != null) {
                return response.getBody().getAccess_token();
            }
            throw new RuntimeException("Failed to get access token: Response body is null");
        } catch (Exception e) {
            log.error("Error getting access token", e);
            throw new RuntimeException("Failed to get access token", e);
        }
    }

    private static class TokenResponse {
        private String access_token;
        private String token_type;
        private Integer expires_in;
        private String scope;

        public String getAccess_token() {
            return access_token;
        }

        public void setAccess_token(String access_token) {
            this.access_token = access_token;
        }

        // other getters and setters
    }
} 