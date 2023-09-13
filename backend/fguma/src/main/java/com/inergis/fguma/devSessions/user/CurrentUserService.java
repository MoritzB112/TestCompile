package com.inergis.fguma.devSessions.user;

import com.inergis.fguma.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.inergis.fguma.repositories.user.UserRepository;

@Service
public class CurrentUserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public CurrentUser loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CurrentUser(user);
    }
}
