package com.example.dashboard.model;

import javax.persistence.*;

@Entity
@Table(name = "widgets")
public class Widgets {

    @Id
    @Column(name = "idwidget")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "size")
    private String size;

    @Column(name = "service")
    private int service;

    @Column(name = "needauth")
    private int needauth;

    public Widgets() {
    }

    public Widgets(String name, String size, int service, int needauth) {
        this.name = name;
        this.size = size;
        this.service = service;
        this.needauth = needauth;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getService() {
        return service;
    }

    public void setService(int service) {
        this.service = service;
    }

    public int getNeedauth() {
        return needauth;
    }

    public void setNeedauth(int needauth) {
        this.needauth = needauth;
    }
}