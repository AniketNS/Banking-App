package com.example.banking.controller;// com.example.banking.controller.LoginController

import com.example.banking.model.User;
import com.example.banking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class LoginController {

    private final UserRepository userRepository;

    @Autowired
    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String login(Model model) {
        // Add any additional attributes needed for the login page
        model.addAttribute("message", "Hello from Thymeleaf!");
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute("user") User user, Model model) {
        // Use the repository method to check if the user exists
        boolean userExists = userRepository.existsByUsernameAndPassword(user.getUsername(), user.getPassword());

        if (userExists) {
            // User exists, retrieve the user details
            Optional<User> optionalUser = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());

            if (optionalUser.isPresent()) {
                User loggedInUser = optionalUser.get();
                // Add the branch code to the model
                model.addAttribute("branchcode", loggedInUser.getBranchcode());
                model.addAttribute("username", loggedInUser.getUsername());
                return "redirect:/dashboard"; // Redirect to the dashboard page after successful login
            }
        }

        model.addAttribute("errorMessage", "Invalid username or password. Please try again.");
        return "login"; // Return to the login page with an error message
    }
}
