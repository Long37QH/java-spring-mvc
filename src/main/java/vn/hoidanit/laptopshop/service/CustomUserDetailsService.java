package vn.hoidanit.laptopshop.service;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        vn.hoidanit.laptopshop.domain.User userlogin = this.userService.getUserByEmail(username);
        if (userlogin == null) {
            throw new UsernameNotFoundException("user not found");
        }
        
        return new User(
            userlogin.getEmail(),
            userlogin.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + userlogin.getRole().getName())));

    }

} 
