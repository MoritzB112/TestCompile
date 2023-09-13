package com.inergis.fguma.services;

import com.inergis.fguma.devSessions.session.InMemorySessionRegistry;
import com.inergis.fguma.entities.User;
import com.inergis.fguma.repositories.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private InMemorySessionRegistry sessionRegistry;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public User getByUsername(String username) {
        if (username == null) {
            return null;
        }
        return userRepository.findByUsername(username);
    }

    public User getByToken(String token) {
        return getByUsername(sessionRegistry.getSession(token));
    }

}