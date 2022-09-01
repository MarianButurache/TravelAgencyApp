package com.travel.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn (name = "country_id")
    private Country country;

    private String name;

    @OneToMany(mappedBy = "city")
    private List<Hotel> hotels;

    public Long getId() {
        return id;
    }

    public Country getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public City() {
    }

    public City(Country country, String name) {
        this.country = country;
        this.name = name;
    }
}
