package com.example.springportal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // This method handles the "/home" URL
    @GetMapping("/home")
    public String homePage() {
        return "home";  // This should match "home.html" in /templates/
    }
}
