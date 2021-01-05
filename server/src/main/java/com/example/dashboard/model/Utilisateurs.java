package com.example.dashboard.model;

import javax.persistence.*;

@Entity
@Table(name = "utilisateurs")
public class Utilisateurs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "user")
    private String user;

    @Column(name = "password")
    private String password;

    public Utilisateurs() {
    }

    public Utilisateurs(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Utilisateurs [id=" + id + ", title=" + user + ", desc=" + password + "]";
    }
}