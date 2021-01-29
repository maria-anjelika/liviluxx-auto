package com.maria.service;

import com.maria.model.User;
import com.maria.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
	User save(UserRegistrationDto registrationDto);
}