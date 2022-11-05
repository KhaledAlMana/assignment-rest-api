package com.assignment.restapi.services.Impl;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.assignment.restapi.services.GitHubOAuth2UserService;

@Service
public class GitHubOAuth2UserServiceImpl extends DefaultOAuth2UserService implements GitHubOAuth2UserService {

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User user = super.loadUser(userRequest);
        return new GitHubOAuth2UserImpl(user);
    }

}
