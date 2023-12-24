package com.example.banking.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        // Add any additional attributes needed for the dashboard page
        model.addAttribute("message", "Hello from Thymeleaf!");
        return "dashboard";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        // Invalidate the session (clear all session attributes)
        HttpSession session = request.getSession(false); // false means do not create a new session if one does not exist
        if (session != null) {
            session.invalidate();
        }

        // Redirect to the login page after logout
        return "redirect:/login";
    }

}
