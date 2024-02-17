package org.utexas.enm.user.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.utexas.enm.user.restapi.model.User;
import org.utexas.enm.user.restapi.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> findByUsername(String userName){
        return userRepository.findUserByUsername(userName);
    }

    public User createUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User updateUser(Long id, User updatedUser){
        if(userRepository.existsById(id)) {
            updatedUser.setId(id);
            updatedUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
            userRepository.save(updatedUser);
        }
        return null; // User not found
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
