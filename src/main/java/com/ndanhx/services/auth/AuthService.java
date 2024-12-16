package com.ndanhx.services.auth;

import com.ndanhx.dto.SignupRequestDtoDto;
import com.ndanhx.dto.UserDto;

public interface AuthService {

    public UserDto createUser(SignupRequestDtoDto signupRequest);

    public boolean hasUserWithEmail(String email);
}
