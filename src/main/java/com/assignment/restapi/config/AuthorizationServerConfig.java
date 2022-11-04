package com.assignment.restapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.authserver.AuthorizationServerTokenServicesConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@SuppressWarnings("deprecation")
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Value("${AUTH_USER:user}")
    private String AUTH_USER;

    @Value("${AUTH_PASS:pass}")
    private String AUTH_PASS;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("oauthclient1")
                .secret("oauthsecret1").scopes("read")
                .authorizedGrantTypes("password").and()
                .withClient("oauthclient2")
                .secret("oauthsecret2")
                .authorizedGrantTypes("authorization_code")
                .scopes("read")
                // .scopes("read:user", "read:posts", "read:comments")
                .redirectUris("https://oauth.pstmn.io/v1/callback");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints)
            throws Exception {
        endpoints.authenticationManager(authenticationManager);
    }

    // @Bean
    // public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    // String securedApi = "/api";
    // return http
    // .httpBasic(AbstractHttpConfigurer::disable)
    // .csrf(AbstractHttpConfigurer::disable)
    // .sessionManagement(c ->
    // c.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
    // .authorizeRequests(c -> c
    // .antMatchers("/", "/info").permitAll()
    // .antMatchers(HttpMethod.GET, securedApi + "/**").permitAll()//
    // .hasAuthority("SCOPE_read:posts")

    // .anyRequest().authenticated())
    // .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
    // .build();
    // }

}
