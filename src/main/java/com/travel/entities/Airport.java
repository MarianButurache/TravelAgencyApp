package com.travel.entities;

import javax.persistence.*;

@Entity
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn (name = "city_id")
    private City city;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public City getCity() {
        return city;
    }

    public Airport() {
    }

    public Airport(City city, String name) {
        this.city = city;
        this.name = name;
    }
}
