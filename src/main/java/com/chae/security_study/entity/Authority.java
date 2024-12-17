package com.chae.security_study.entity;

import jakarta.persistence.*;

@Entity
public class Authority{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private Users users;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Users getUser() {
        return users;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUser(Users users) {
        this.users = users;
    }
}
