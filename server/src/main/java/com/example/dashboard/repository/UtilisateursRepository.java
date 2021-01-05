package com.example.dashboard.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.dashboard.model.Utilisateurs;

public interface UtilisateursRepository extends JpaRepository<Utilisateurs, Long> {
    List<Utilisateurs> findByUser(String User);

    List<Utilisateurs> findByPassword(String Password);
}