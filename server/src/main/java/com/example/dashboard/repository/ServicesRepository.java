package com.example.dashboard.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.dashboard.model.Services;

public interface ServicesRepository extends CrudRepository<Services, Integer> {
    Services findByName(String name);

    Services findById(int id);
}