// com.example.banking.controller.LoginController

package com.example.banking.controller;

import com.example.banking.model.User;
import com.example.banking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(Model model) {
        // Add any additional attributes needed for the login page
        model.addAttribute("message", "Hello from Thymeleaf!");
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute("user") User user, Model model) {
        // Verify if the user is registered
        if (userService.isUserRegistered(user.getUsername())) {
            // Perform login logic, e.g., check password, set session attributes, etc.
            return "redirect:/hello"; // Redirect to the dashboard page after successful login
        } else {
            model.addAttribute("errorMessage", "User not registered. Please register first.");
            return "login"; // Return to the login page with an error message
        }
    }
}
