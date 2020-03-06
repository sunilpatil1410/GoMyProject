package com.globeop.riskfeed.security.user.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.globeop.riskfeed.security.user.dto.UserRegistrationDto;
import com.globeop.riskfeed.security.user.entity.User;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}
