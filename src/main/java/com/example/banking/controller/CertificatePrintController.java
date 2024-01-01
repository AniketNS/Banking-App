package com.example.banking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CertificatePrintController {
    @GetMapping("/certprint")
    public String showCertPage(Model model) {
        // Add any additional attributes needed for the dashboard page
        model.addAttribute("message", "Hello from Thymeleaf!");
        return "printcert"; // Assuming "dashboard" is the name of your Thymeleaf template
    }
}