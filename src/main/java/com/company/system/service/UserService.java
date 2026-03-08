package com.company.system.service;

import com.company.system.model.User;
import com.company.system.repository.UserRepository;
import com.company.system.util.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Optional<List<User>> getAll() {
        return Optional.of(userRepository.findAll());
    }
    public Optional<User> getById(Long _id) {
        return userRepository.findById(_id);
    }

    public User save(User _user) {
        return userRepository.save(_user);
    }

    public void deleteById(Long _id) {
        userRepository.deleteById(_id);
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }

    public User updateUser(Long _id, User _newUser) {
        User user = userRepository.findById(_id).orElseThrow(() -> new RuntimeException("User not found in our system."));
        user.setName(_newUser.getName());
        user.setLogin(_newUser.getLogin());
        user.setEmail(_newUser.getEmail());
        user.setPassword(_newUser.getPassword());
        return userRepository.save(user);
    }

    public User updatePartialUser(Long _id, User _newUser) {
        User user = userRepository.findById(_id).orElseThrow(() -> new RuntimeException("User not found in our system."));
        if (_newUser.getName() != null) {
            user.setName(_newUser.getName());
        }
        if (_newUser.getLogin() != null) {
            user.setLogin(_newUser.getLogin());
        }
        if (_newUser.getEmail() != null) {
            user.setEmail(_newUser.getEmail());
        }
        if (_newUser.getPassword() != null) {
            user.setPassword(_newUser.getPassword());
        }
        return userRepository.save(user);
    }
}
