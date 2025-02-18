package com.example.springportal.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
public class LogoutController {

    // Create a logger instance
    private static final Logger logger = LoggerFactory.getLogger(LogoutController.class);

    // Custom logout handler (Optional if you want extra logic)
    @GetMapping
    public String handleLogout() {
        // Log the logout event instead of printing to the console
        logger.info("Logging out user...");

        // After logout, you can redirect the user to a different page, for example, the login page
        return "redirect:/login?logout";  // Redirects to the login page with a 'logout' message
    }
}
