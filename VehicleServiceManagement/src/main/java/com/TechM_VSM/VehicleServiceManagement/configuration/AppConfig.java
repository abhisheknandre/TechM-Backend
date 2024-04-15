//package com.TechM_VSM.VehicleServiceManagement.configuration;
//
//import com.TechM_VSM.VehicleServiceManagement.model.Role;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//@Configuration
//public class AppConfig {
//
//    @Bean
//    public UserDetailsService userDetailsService()
//    {
//
//        UserDetails user = User.builder().username("Nikhil").password(passwordEncoder().encode("abc")).roles("ADMIN").build();
//        return new InMemoryUserDetailsManager(user);
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//}
