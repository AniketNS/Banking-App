package com.example.banking.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        // Provide a custom error page or redirect to a specific page
        return "error";
    }

    public String getErrorPath() {
        return "/error";
    }
}
