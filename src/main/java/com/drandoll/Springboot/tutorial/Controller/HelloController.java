package com.drandoll.Springboot.tutorial.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${welcome.message}")
    private String _welcomeMessage;

    @GetMapping("/")
    public String helloWorld(){
        return _welcomeMessage;
    }
}
