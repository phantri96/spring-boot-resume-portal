package com.triphan.resumeportal.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomePageController {

    @GetMapping("/")
    public String homepage() {
        return "hello";
    }

    @GetMapping("/edit")
    public String edit() {
        return "welcome to edit page";
    }


    @GetMapping("/view/{userId}")
    public String getUserView(@PathVariable("userId") String userId, Model model) {
        model.addAttribute("userId", userId);
        return "profile-template/3/index";
    }
}
