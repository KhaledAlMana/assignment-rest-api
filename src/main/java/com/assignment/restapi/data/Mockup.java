package com.assignment.restapi.data;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.assignment.restapi.controllers.dto.UserDTO;
import com.assignment.restapi.controllers.dto.UsersListDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mockup {
    Logger logger = LoggerFactory.getLogger(Mockup.class);

    public List<UserDTO> getAllUsers() {
        List<UserDTO> users =
        this.seedRequest("https://gorest.co.in/public/v2/users").getUsers();
        return List[UserDTO]()];
    }

    public String seedRequest(String url) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = null;
        try {
            response = restTemplate.getForEntity(url, String.class);
            if (response.getStatusCode() == HttpStatus.OK) {
                logger.info("Request Success", response.getBody());
                return response.getBody();
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            logger.error("Error while fetching data: {}", e.toString());
            return null;
        }
    }
}