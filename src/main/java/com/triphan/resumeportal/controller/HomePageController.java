package com.triphan.resumeportal.controller;


import com.triphan.resumeportal.model.UserProfile;
import com.triphan.resumeportal.service.ResumeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomePageController {

    @Autowired
    private ResumeUserService resumeUserService;

    @GetMapping("/")
    public String homepage() {
        return "hello";
    }

    @GetMapping("/edit")
    public String edit() {
        return "welcome to edit page";
    }


    @GetMapping("/view/{userName}")
    public String getUserView(@PathVariable("userName") String userName, Model model) {
        UserProfile userProfile = resumeUserService.getUserProfileByUserName(userName);
        model.addAttribute("userProfile", userProfile);
        return "profile-template/" + userProfile.getTheme() + "/index";

    }
}
