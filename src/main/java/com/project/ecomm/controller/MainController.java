package com.project.ecomm.controller;


import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/api")
public class MainController {

    @GetMapping
    public String greet(){
        return "Hello World!";
    }

}
