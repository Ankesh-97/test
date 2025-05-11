package org.example.springdataJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomDatabaseConfig {

    @Autowired
    private AppConfig appConfig;

    
}
