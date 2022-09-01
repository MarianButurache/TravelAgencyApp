package com.travel.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated
    private MealTypeName mealTypeName;

    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "hotel_id")
    private Hotel hotel; //...................!!!!!!!!!!!!Atentie aici am o eroare
    //Am scos si functioneaza: private List<Hotel> hotels;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MealTypeName getMealTypeName() {
        return mealTypeName;
    }

    public void setMealTypeName(MealTypeName mealTypeName) {
        this.mealTypeName = mealTypeName;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Meal() {
    }

    public Meal(MealTypeName mealTypeName, Hotel hotel) {
        this.mealTypeName = mealTypeName;
        this.hotel = hotel;
    }
}
