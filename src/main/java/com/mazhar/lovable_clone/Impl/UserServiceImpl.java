package com.mazhar.lovable_clone.Impl;

import com.mazhar.lovable_clone.dto.auth.UserProfileResponse;
import com.mazhar.lovable_clone.dto.subscription.PlanLimitsResponse;
import com.mazhar.lovable_clone.dto.subscription.UsageTodayResponse;
import com.mazhar.lovable_clone.service.UsageService;
import com.mazhar.lovable_clone.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserProfileResponse getProfile() {
        return null;
    }
}
