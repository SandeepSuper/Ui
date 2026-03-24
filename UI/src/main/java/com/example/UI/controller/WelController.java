package com.example.UI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelController {
    @GetMapping("/welcome")
    public String showWelcomePage(Model model) {
        // Adding data to the "Model" makes it available in the HTML
        model.addAttribute("message", "Hello from Spring Boot!");

        // Returns the view: src/main/resources/templates/welcome.html
        return "welcome";
    }
}
