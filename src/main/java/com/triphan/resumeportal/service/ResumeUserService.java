package com.triphan.resumeportal.service;


import com.triphan.resumeportal.model.UserProfile;
import com.triphan.resumeportal.repository.ResumeUserProfileRepository;
import com.triphan.resumeportal.utils.ResumePortalUtil;
import org.springframework.beans.BeanUtils;
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

    public void updateUserProfile(UserProfile userProfileInput) {
        UserProfile userProfile = getUserProfileByUserName(userProfileInput.getUserName());
        BeanUtils.copyProperties(userProfileInput, userProfile, ResumePortalUtil.getNullPropertyNames(userProfileInput, "id"));
        resumeUserProfileRepository.saveAndFlush(userProfile);
    }

}
