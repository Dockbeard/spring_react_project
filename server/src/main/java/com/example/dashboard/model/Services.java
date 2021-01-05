package com.example.dashboard.model;

import javax.persistence.*;

@Entity
@Table(name = "services")
public class Services {

    @Id
    @Column(name = "idservice")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    public Services() {
    }

    public Services(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}