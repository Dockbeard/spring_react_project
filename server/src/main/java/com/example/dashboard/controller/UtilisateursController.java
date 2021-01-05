package com.example.dashboard.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dashboard.model.Utilisateurs;
import com.example.dashboard.repository.UtilisateursRepository;

@RestController
@RequestMapping("/api")
public class UtilisateursController {

    @Autowired
    UtilisateursRepository utilisateursRepository;

    @GetMapping("/utilisateurs")
    public ResponseEntity<List<Utilisateurs>> getAllUtilisateurs(@RequestParam(required = false) String User) {
        try {
            List<Utilisateurs> utilisateurs = new ArrayList<Utilisateurs>();

            if (User == null)
                utilisateursRepository.findAll().forEach(utilisateurs::add);
            else
                utilisateursRepository.findByUser(User).forEach(utilisateurs::add);

            if (utilisateurs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(utilisateurs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping("/welcome")
    public String welcomepage() {
        return "Welcome to Dashboard";
    }

}