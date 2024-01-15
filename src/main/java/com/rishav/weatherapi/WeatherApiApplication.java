package com.rishav.weatherapi;

import com.rishav.weatherapi.security.AuthenticationService;
import com.rishav.weatherapi.security.ClientCredentialsGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class})
public class WeatherApiApplication {

	public static void main(String[] args) {
			SpringApplication.run(WeatherApiApplication.class, args);
		    AuthenticationService.credentials();
	}


}
