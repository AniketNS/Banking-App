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
        // Set branch code based on some logic or use a default value
        user.setBranchcode("0002");

        // Verify if the user is registered with the given username and password
        if (userService.isUserRegistered(user.getUsername(), user.getPassword()) && "0002".equals(user.getBranchcode())) {
            // Perform login logic, e.g., check password, set session attributes, etc.
            return "redirect:/dashboard"; // Redirect to the dashboard page after successful login
        } else {
            model.addAttribute("errorMessage", "Invalid username, password, or branch code. Please try again.");
            return "login"; // Return to the login page with an error message
        }
    }

}
