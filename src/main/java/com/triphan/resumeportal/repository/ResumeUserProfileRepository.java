package com.triphan.resumeportal.repository;

import com.triphan.resumeportal.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResumeUserProfileRepository extends JpaRepository<UserProfile, Long> {
    Optional<UserProfile> findByUserName(String userName);
}
