package com.chae.security_study.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private EncryptionAlgorithm algorithm;

    @OneToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private List<Authority> authorities;

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public EncryptionAlgorithm getAlgorithm() {
        return algorithm;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAlgorithm(EncryptionAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }
}
