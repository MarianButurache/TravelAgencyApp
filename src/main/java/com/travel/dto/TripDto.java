package com.travel.dto;

import java.time.LocalDate;

public class TripDto {

    private Long id;
    private Long airportDepartureId;
    private Long airportArrivalId;
    private Long hotelId;
    private LocalDate departureDate;
    private LocalDate arrivalDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAirportDepartureId() {
        return airportDepartureId;
    }

    public void setAirportDepartureId(Long airportDepartureId) {
        this.airportDepartureId = airportDepartureId;
    }

    public Long getAirportArrivalId() {
        return airportArrivalId;
    }

    public void setAirportArrivalId(Long airportArrivalId) {
        this.airportArrivalId = airportArrivalId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
}
