package org.example.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.data.mongodb")
@Getter
@Setter
@NoArgsConstructor
public class MongoConfigProperties {
    private String uri;
    private String database;
}
