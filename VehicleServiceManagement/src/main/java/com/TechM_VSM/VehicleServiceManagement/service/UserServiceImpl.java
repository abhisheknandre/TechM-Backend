package com.TechM_VSM.VehicleServiceManagement.service;

import com.TechM_VSM.VehicleServiceManagement.dto.SignupRequest;
import com.TechM_VSM.VehicleServiceManagement.dto.UserDto;
import com.TechM_VSM.VehicleServiceManagement.model.User;
import com.TechM_VSM.VehicleServiceManagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDto saveUser(SignupRequest signupRequest) {
        User newuser = new User();
        newuser.setName(signupRequest.getName());
        newuser.setEmail(signupRequest.getEmail());
        newuser.setPassword(signupRequest.getPassword());
        newuser.setRole(signupRequest.getRole());
        User createdUser = userRepository.save(newuser);
        UserDto userDto = new UserDto();
        userDto.setUId(createdUser.getUId());
        return userDto;
    }

    @Override
    public boolean hasUserwithEmail(String email) {
        return userRepository.findFirstByEmail(email).isPresent();
    }
}
