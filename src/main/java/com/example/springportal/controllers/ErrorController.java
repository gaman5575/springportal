package com.example.springportal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    @GetMapping("/error")
    public String handleError() {
        // Return a custom error page
        return "error";  // You can create an error.html template in your resources/templates folder
    }
}
