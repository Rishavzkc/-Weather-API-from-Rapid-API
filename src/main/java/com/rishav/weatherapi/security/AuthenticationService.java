package com.rishav.weatherapi.security;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;

@Slf4j
public class AuthenticationService {

    // Generate random client id and secret for each request
    public static String clientId = ClientCredentialsGenerator.generateClientId();
    public static String clientSecret = ClientCredentialsGenerator.generateClientSecret();

    // Constant client id and secret for each request for debugging
//    private static final clientId = "X-API-KEY";
//    private static final String clientSecret = "Rishav";


    //This method will help to see generated client Id and client secret on console
    public static void credentials(){
        System.out.println("Generated Client ID: " + AuthenticationService.clientId);
        System.out.println("Generated Client Secret: " + AuthenticationService.clientSecret);
    }

    public static Authentication getAuthentication(HttpServletRequest request) {
        String apiKey = request.getHeader(clientId);
        if (apiKey == null || !apiKey.equals(clientSecret)) {
            throw new BadCredentialsException("Invalid API Key");
        }
        return new ApiKeyAuthentication(apiKey, AuthorityUtils.NO_AUTHORITIES);
    }


}
