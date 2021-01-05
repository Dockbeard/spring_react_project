package com.example.dashboard.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

import com.example.dashboard.model.Users;

public interface UtilisateursRepository extends CrudRepository<Users, Integer> {
    Users findByMail(String mail);

    Users findById(int id);

    Optional<Users> findOById(int id);

    void deleteById(int id);

    void deleteByMail(String mail);
}