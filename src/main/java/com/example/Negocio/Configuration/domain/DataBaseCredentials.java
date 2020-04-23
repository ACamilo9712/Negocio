package com.example.Negocio.Configuration.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "database")
@RequiredArgsConstructor
@Data
public class DataBaseCredentials {
    private String host;
    private String port;
    private String username;
    private String password;
    private String database;
}
