package com.triphan.resumeportal.controller;

import com.triphan.resumeportal.model.Education;
import com.triphan.resumeportal.model.JobHistory;
import com.triphan.resumeportal.model.UserProfile;
import com.triphan.resumeportal.service.ResumeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
public class UserPageController {

    @Autowired
    private ResumeUserService resumeUserService;


    @GetMapping("/view/{userName}")
    public String getUserView(@PathVariable("userName") String userName, Model model) {
        UserProfile userProfile = resumeUserService.getUserProfileByUserName(userName);
        model.addAttribute("userProfile", userProfile);
        return "profile-template/" + userProfile.getTheme() + "/index";
    }

    @GetMapping("/profile/edit")
    public String editProfile(Model model, Principal principal, @RequestParam(value = "action", required = false) String action,
                              @RequestParam(value = "type", required = false) String type,
                              @RequestParam(value = "index", required = false) Integer index) {
        String userName = principal.getName();
        UserProfile userProfile = resumeUserService.getUserProfileByUserName(userName);
        model.addAttribute("userProfile", userProfile);
        return "profile-edit";
    }

    @PostMapping(value = "/profile/edit", consumes = "application/x-www-form-urlencoded")
    public String addSkill(Model model, Principal principal, @RequestParam Map<String, String> params) {
        String type = params.get("type");
        String userName = principal.getName();
        UserProfile userProfile = resumeUserService.getUserProfileByUserName(userName);
        if("skill".equalsIgnoreCase(type)) {
            userProfile.getSkills().add("");
        }
        if("education".equalsIgnoreCase(type)) {
            userProfile.getEducations().add(new Education());
        }
        if("experience".equalsIgnoreCase(type)) {
            userProfile.getJobHistories().add(new JobHistory());
        }
        resumeUserService.updateUserProfile(userProfile);
        return "redirect:/profile/edit";
    }

    @DeleteMapping("/profile/edit/{type}/{index}")
    @ResponseBody
    public void deleteSkill(Model model, @PathVariable(value = "type") String type,
                              @PathVariable(value = "index") Integer index, Principal principal) {
        String userName = principal.getName();
        UserProfile userProfile = resumeUserService.getUserProfileByUserName(userName);
        if("skill".equalsIgnoreCase(type)) {
            userProfile.getSkills().remove(index.intValue());
        }
        if("education".equalsIgnoreCase(type)) {
            userProfile.getEducations().remove(index.intValue());
        }
        if("experience".equalsIgnoreCase(type)) {
            userProfile.getJobHistories().remove(index.intValue());
        }
        resumeUserService.updateUserProfile(userProfile);
    }

    @PostMapping("profile/edit/{userName}")
    public String updateProfile(@PathVariable("userName") String userName, @ModelAttribute("userProfile") UserProfile userProfile, Principal principal) {
        String loginUserName = principal.getName();
        if (!loginUserName.equalsIgnoreCase(userName)) {
            throw new RuntimeException("not have permission");
        }
        resumeUserService.updateUserProfile(userProfile);
        return "redirect:/view/" + userName;
    }

}
