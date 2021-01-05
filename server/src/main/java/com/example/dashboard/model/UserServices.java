package com.example.dashboard.model;

import javax.persistence.*;

@Entity
@Table(name = "userservices")
public class UserServices {

    @Id
    @Column(name = "iduserservice")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user")
    private int user;

    @Column(name = "service")
    private int service;

    @Column(name = "order")
    private int order;

    public UserServices() {
    }

    public UserServices(int user, int order, int service) {
        this.user = user;
        this.order = order;
        this.service = service;
    }

    public int getId() {
        return id;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getService() {
        return service;
    }

    public void setService(int service) {
        this.service = service;
    }
}