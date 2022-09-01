package com.travel.dto;
import java.util.Date;
import java.util.List;

public class TripPurchaseDto {
    private Long id;
    private Long tripId;
    private double amount;
    private String tripPurchaseDate;
    private List<TouristDto> touristDto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTripPurchaseDate() {
        return tripPurchaseDate;
    }

    public void setTripPurchaseDate(String tripPurchaseDate) {
        this.tripPurchaseDate = tripPurchaseDate;
    }

    public List<TouristDto> getTouristDto() {
        return touristDto;
    }

    public void setTouristDto(List<TouristDto> touristDto) {
        this.touristDto = touristDto;
    }
}
