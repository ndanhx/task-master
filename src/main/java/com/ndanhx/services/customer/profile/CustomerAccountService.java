package com.ndanhx.services.customer.profile;

import com.ndanhx.dto.UserDto;

import java.io.IOException;

public interface CustomerAccountService {

    UserDto getAccountByUserId(Long userId);

    UserDto updateAccountByUserId(Long userId, UserDto userDto) throws IOException;


}
