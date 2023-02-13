package com.peaksoft.controller;

import com.peaksoft.entity.User;
import com.peaksoft.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
@RequiredArgsConstructor//users/login
public class UserController {
    private final UserService userService;

    @GetMapping
    public String hello() {
        return "hello";
    }

    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", userService.getAll());
        return "users";
    }

    @GetMapping("/saveUser")
    public String save(Model model) {
        model.addAttribute("user", new User());
        return "saveUser";
    }

    @PostMapping("/save")
    public String add(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/profile")
    public String profile(HttpServletRequest request, Model model) {
        Principal principal = request.getUserPrincipal();
        model.addAttribute("user", userService.getUserByUsername(principal.getName()));
        return "profile";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
