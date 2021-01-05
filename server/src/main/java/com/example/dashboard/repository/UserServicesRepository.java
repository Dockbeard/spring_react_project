package com.example.dashboard.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

import com.example.dashboard.model.UserServices;

public interface UserServicesRepository extends CrudRepository<UserServices, Integer> {
    UserServices findById(int id);

    List<UserServices> findByUser(int user);

    @Query("select u from UserServices u where u.user=(:user) and u.service=(:service)")
    Optional<UserServices> findOByIdAndUser(@Param("user") int user, @Param("service") int service);

    @Query("delete from UserServices u where u.user=(:user) and u.service=(:service)")
    void deleteByUserAndService(@Param("user") int user, @Param("service") int service);
}