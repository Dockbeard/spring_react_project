package com.example.dashboard.controller;

import com.example.dashboard.model.Users;
import com.example.dashboard.repository.UtilisateursRepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {
    private UtilisateursRepository utilisateursRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UtilisateursRepository utilisateursRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.utilisateursRepository = utilisateursRepository;
    }

    @PostMapping("/register")
    public void signUp(@RequestBody Users user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        utilisateursRepository.save(user);
    }
}
