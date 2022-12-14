package com.assignment.restapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
