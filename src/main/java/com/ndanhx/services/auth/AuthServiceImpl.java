package com.ndanhx.services.auth;

import com.ndanhx.dto.SignupRequestDtoDto;
import com.ndanhx.dto.UserDto;
import com.ndanhx.emuns.UserRole;
import com.ndanhx.entity.User;
import com.ndanhx.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    private UserRepository userRepository;




    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDto createUser(SignupRequestDtoDto signupRequest){
        User user = new User();
        user.setEmail(signupRequest.getEmail());
        user.setName(signupRequest.getName());
        user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
        user.setRole(UserRole.CUSTOMER);

        User createUser = userRepository.save(user);


        UserDto userDto = new UserDto();
        userDto.setId(createUser.getId());
        return userDto;

    }


    public boolean hasUserWithEmail(String email) {
        return userRepository.findFirstByEmail(email).isPresent();
    }

    @PostConstruct
    public void CreateAdminAccount(){
        User adminAccount = userRepository.findByRole(UserRole.ADMIN);
        if (null == adminAccount){
            User user = new User();
            user.setEmail("admin@gmail.com");
            user.setName("Admin");
            user.setRole(UserRole.ADMIN);
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            userRepository.save(user);
        }
    }

}
