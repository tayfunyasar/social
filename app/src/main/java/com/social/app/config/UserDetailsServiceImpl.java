package com.social.app.config;

import com.social.app.entity.User;
import com.social.app.repository.UserRepository;
import java.util.Collections;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User loadedUser = userRepository.findFirstByPhone(username).orElseThrow();

        return new org.springframework.security.core.userdetails.User(
            loadedUser.getUsername(),
            loadedUser.getPassword(),
            true,
            true,
            true,
            true,
            Collections.singleton(new SimpleGrantedAuthority(loadedUser.getRole().name()))
        );
    }
}
