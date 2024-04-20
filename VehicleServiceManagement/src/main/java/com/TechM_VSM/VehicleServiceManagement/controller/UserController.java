package com.TechM_VSM.VehicleServiceManagement.controller;

import com.TechM_VSM.VehicleServiceManagement.dto.*;
import com.TechM_VSM.VehicleServiceManagement.model.Role;
import com.TechM_VSM.VehicleServiceManagement.model.User;
import com.TechM_VSM.VehicleServiceManagement.repository.UserRepository;
import com.TechM_VSM.VehicleServiceManagement.security.JWTHelper;
import com.TechM_VSM.VehicleServiceManagement.service.UserService;
import com.TechM_VSM.VehicleServiceManagement.service.jwt.AuthService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@CrossOrigin
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class UserController {

    @Autowired
    private UserService userService;
    private final AuthService authService;

    private final JWTHelper jwtUtil;
    private final UserRepository userRepository;

    public UserController(AuthService authService, UserService userService, UserRepository userRepository, JWTHelper jwtUtil, AuthenticationManager authenticationManager) {
        this.authService = authService;
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
    }



    @GetMapping("/getAllAdvisorEmails")
    public ResponseEntity<List<UserDto>> getAllAdvisorEmails() {
        List<String> emails = userService.getAdvisorEmails();
        List<UserDto> userDtos = emails.stream()
                .map(email -> {
                    UserDto userDto = new UserDto();
                    userDto.setEmail(email);
                    return userDto;
                })
                .collect(Collectors.toList());
        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }


    @PostMapping("/signup")
    public ResponseEntity<?> add(@RequestBody SignupRequest signupRequest) {
        if (userService.hasUserwithEmail(signupRequest.getEmail())) {
            return new ResponseEntity<>("Customer already exists with this email!", HttpStatus.CONFLICT);
        }

        UserDto createdUserDto = userService.saveUser(signupRequest);
        if (createdUserDto == null) {
            return new ResponseEntity<>("Customer not created", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }

    @GetMapping("/test")
    public String getUser()
    {
        System.out.println("Getting user");
        return "Welcome";
    }


    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) {
        String email = authenticationRequest.getEmail();
        String password = authenticationRequest.getPassword();


        Optional<User> optionalUser = userRepository.findFirstByEmail(email);
        System.out.println(optionalUser.get().getPassword());

        if (optionalUser.isPresent() && passwordMatches(optionalUser.get().getPassword(), password)) {
            final UserDetails userDetails = authService.userDetailsService().loadUserByUsername(authenticationRequest.getEmail());
            String jwt = jwtUtil.generateToken(userDetails);

            AuthenticationResponse authenticationResponse = new AuthenticationResponse(
                    jwt,
                    optionalUser.get().getUId(),
                    optionalUser.get().getRole(),
                    optionalUser.get().getName(),
                    optionalUser.get().getEmail()
            );

            return ResponseEntity.ok(authenticationResponse);

        } else {
            System.out.println("Invalid username or password !");
            return new ResponseEntity("Invalid username or password !",HttpStatus.BAD_REQUEST);
        }
    }

    private boolean passwordMatches(String string, String password) {
        // Implement your logic to check if the provided password matches the stored password
        // You might use a password encoder or other mechanism depending on your setup.
        // For example, you can use Spring Security's PasswordEncoder.matches method.

        // Assuming you have a password encoder bean in your configuration:
        // return passwordEncoder.matches(password, user.getPassword());

        // For demonstration purposes, a simple equality check is used:
        boolean flag=false;
        if(string.equals(password)) {
            flag=true;
            System.out.println("login success !");
        };

        return flag;
    }
}
