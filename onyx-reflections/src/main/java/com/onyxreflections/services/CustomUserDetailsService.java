package com.onyxreflections.services;

import com.onyxreflections.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Customization allows us to use an email for login instead of the default username

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        com.onyxreflections.model.User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Profile not found for the email " + email));
        return new User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }
}
