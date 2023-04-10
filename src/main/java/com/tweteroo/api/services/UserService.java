package com.tweteroo.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.UserDTO;
import com.tweteroo.api.models.User;
import com.tweteroo.api.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User create(UserDTO dto) {
        return repository.save(new User(dto));
    }
}
