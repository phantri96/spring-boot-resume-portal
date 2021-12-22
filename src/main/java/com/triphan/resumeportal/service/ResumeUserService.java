package com.triphan.resumeportal.service;


import com.triphan.resumeportal.model.UserProfile;
import com.triphan.resumeportal.repository.ResumeUserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResumeUserService {

    @Autowired
    private ResumeUserProfileRepository resumeUserProfileRepository;

    public UserProfile getUserProfileByUserName(String userName) {
        Optional<UserProfile> optionalUserProfile = resumeUserProfileRepository.findByUserName(userName);
        optionalUserProfile.orElseThrow(() -> new RuntimeException("User not found: " + userName));
        return optionalUserProfile.get();
    }

}
