package com.rishav.weatherapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//This class is for testing purpose
@RestController
@RequestMapping("/api")
public class HomeController {

    @GetMapping(path = "/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping(path = "/test")
    public String Testing(){
        return "test";
    }
}
