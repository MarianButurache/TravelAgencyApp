package com.travel.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
// adauga un unique constraint pe baza de date - valoarea din "username"
// trebuie sa fie unica.
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class User {

    // marcheaza field-ul ca primary key
    @Id
    // seteaza modul de incrementare a primary key-ului.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // verifica daca campul este null sau nu
    @Column(unique = true)
    private String username;

    private String password;

    @OneToOne
    private Role role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

