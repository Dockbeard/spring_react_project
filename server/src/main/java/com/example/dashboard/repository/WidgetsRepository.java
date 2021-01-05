package com.example.dashboard.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import com.example.dashboard.model.Widgets;

public interface WidgetsRepository extends CrudRepository<Widgets, Integer> {
    Widgets findByName(String name);

    Widgets findById(int id);

    List<Widgets> findByService(int service);
}