package com.travel.entities;

/*Cele 7 continente ale Pământului sunt:

        Africa
        America de Nord
        America de Sud
        Antarctida (a nu se confunda cu Antarctica, marea zonă sudică a Pământului)
        Asia
        Australia
        Europa*/

import javax.persistence.*;
import java.util.List;

@Entity
public class Continent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated (value=EnumType.STRING)
    private ContinentName continentName;

    @OneToMany(mappedBy = "continent")
    private List<Country> countries;

    public Long getId() {
        return id;
    }

    public ContinentName getContinentName() {
        return continentName;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setContinentName(ContinentName continentName) {
        this.continentName = continentName;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }
}
