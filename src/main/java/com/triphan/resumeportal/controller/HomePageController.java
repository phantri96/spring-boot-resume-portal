package com.triphan.resumeportal.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class HomePageController {

    @GetMapping("/")
    @ResponseBody
    public String homepage(Principal principal) {
        return "hello";
    }

    @GetMapping("/edit")
    public String edit() {
        return "welcome to edit page";
    }

}
