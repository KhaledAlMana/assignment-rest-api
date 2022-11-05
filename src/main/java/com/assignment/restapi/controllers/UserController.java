package com.assignment.restapi.controllers;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.assignment.restapi.controllers.dto.UserInfoDTO;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @GetMapping("/")
    public String getAll() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return restTemplate.exchange(
                "https://gorest.co.in/public/v2/users/", HttpMethod.GET, entity, String.class).getBody();

    }

    @GetMapping("/{userId}/posts")
    public String getUserPosts(@PathVariable String userId) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return restTemplate.exchange(
                "https://gorest.co.in/public/v2/posts/?user_id=" + userId, HttpMethod.GET, entity, String.class)
                .getBody();

    }

    @GetMapping("/me")
    public UserInfoDTO getInfo(OAuth2AuthenticationToken authentication) {
        return new UserInfoDTO()
                .setApplication("GitHub")
                .setPrincipal(authentication.getPrincipal().getAttributes());
    }

}
