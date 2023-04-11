package com.tweteroo.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.UserDTO;
import com.tweteroo.api.services.UserService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/sign-up")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public String create(@RequestBody @Valid UserDTO req) {
        service.create(req);
        return "OK";
    }
}
