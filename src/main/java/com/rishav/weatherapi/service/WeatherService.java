package com.rishav.weatherapi.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.*;

@Service
@Slf4j
public class WeatherService {
@Value("${forecastHourly.url}")
private String forecastHourly;

@Value("${forecastSummary.url}")
private String forecastSummary;

@Value("${forecastSummary.key}")
private String key;
@Value("${forecastSummary.host}")
private String host;

@Autowired
private RestTemplate restTemplate;

public Object getForeCastHourlyByLocation(){
 try {
     //headers object is created to set the required headers, including "X-RapidAPI-Key" and "X-RapidAPI-Host."
     HttpHeaders headers = new HttpHeaders();
     headers.set("X-RapidAPI-Key", key);
     headers.set("X-RapidAPI-Host", host);

     //exchange method of RestTemplate is used to send the GET request to the forecastHourly URL with the specified headers and returns a ResponseEntity<String>
     ResponseEntity<String> response = restTemplate.exchange(forecastHourly, HttpMethod.GET, new HttpEntity<>(headers), String.class);
     //method returns the response body as an Object.
     log.info("Response from rapid api {} : ", response.getBody());
     return response.getBody();

 }catch(Exception e){
         log.error("Something went wrong", e);
         throw new ResponseStatusException(
         HttpStatus.INTERNAL_SERVER_ERROR,
        "Exception while calling endpoint",e);
     }
}
public Object getForeCastSummaryByLocation() {
try{
    HttpHeaders headers = new HttpHeaders();
    headers.set("X-RapidAPI-Key", key);
    headers.set("X-RapidAPI-Host", host);

    ResponseEntity<String> response = restTemplate.exchange(forecastSummary, HttpMethod.GET, new HttpEntity<>(headers), String.class);
    log.info("Response from rapid api {} : ", response.getBody());
    return response.getBody();

}catch(Exception e){
       log.error("Something went wrong", e);
       throw new ResponseStatusException(
        HttpStatus.INTERNAL_SERVER_ERROR,
        "Exception while calling endpoint",e);
}
    }


}
