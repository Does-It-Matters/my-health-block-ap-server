package com.example.myhealthblock.jwt;

import com.example.myhealthblock.user.adapter.out.UserEntity;
import com.example.myhealthblock.user.adapter.out.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUserId(userId);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with userId: " + userId);
        }

        String password = user.getPw();
        if (password == null) {
            throw new UsernameNotFoundException("Password not set for user: " + userId);
        }

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUserId())
                .password(password)
                .roles(user.getRole())
                .build();
    }
}