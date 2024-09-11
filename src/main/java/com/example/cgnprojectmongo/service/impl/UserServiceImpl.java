package com.example.cgnprojectmongo.service.impl;

import com.example.cgnprojectmongo.domain.User;
import com.example.cgnprojectmongo.repository.UserRepository;
import com.example.cgnprojectmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }
}
