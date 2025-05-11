package org.monetize360.shop.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "ctp")
public class CommercetoolsProperties {
    private String projectKey;
    private String clientId;
    private String clientSecret;
    private String authUrl;
    private String apiUrl;
    private String scopes;
} 