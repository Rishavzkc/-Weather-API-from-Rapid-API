package com.rishav.weatherapi.security;

import java.util.UUID;

//utility class to generate random client ID and client secret.

public class ClientCredentialsGenerator {
    public static String generateClientId() {
        return UUID.randomUUID().toString();
    }

    public static String generateClientSecret() {
        return UUID.randomUUID().toString();
    }
}
