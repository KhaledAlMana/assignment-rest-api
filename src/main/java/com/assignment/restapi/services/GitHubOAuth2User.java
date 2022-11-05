package com.assignment.restapi.services;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

public interface GitHubOAuth2User extends OAuth2User {
    @Override
    public Map<String, Object> getAttributes();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities();

    @Override
    public String getName();

}
