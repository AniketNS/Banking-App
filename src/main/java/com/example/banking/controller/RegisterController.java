// com.example.banking.controller.RegisterController

package com.example.banking.controller;

import com.example.banking.model.User;
import com.example.banking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    private final UserRepository userRepository;

    @Autowired
    public RegisterController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        try {
            // Validate user data if needed
            userRepository.save(user);
            // Redirect to login page after successful registration
            return "redirect:/login";
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace(); // You can replace this with a logger
            // Add an error message to the model if needed
            model.addAttribute("errorMessage", "An error occurred during registration.");
            // Return to the registration page if an error occurs
            return "register";
        }
    }
}
