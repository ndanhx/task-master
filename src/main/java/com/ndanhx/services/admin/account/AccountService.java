package com.ndanhx.services.admin.account;

import com.ndanhx.dto.UserDto;

import java.util.List;

public interface AccountService {

    List<UserDto> getAllAccounts();

    UserDto getUserById(Long userId);

}
