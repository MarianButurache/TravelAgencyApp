package com.travel.controllers;

import com.travel.dto.TripDto;
import com.travel.dto.TripResponseDto;
import com.travel.entities.Trip;
import com.travel.services.AirportService;
import com.travel.services.HotelService;
import com.travel.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * POST - CREATE
 * GET - READ
 * PUT - UPDATE
 * DELETE - DELETE
 * <p>
 * <p>
 * <p>
 * {
 * "airportDepartureId" : 19,
 * "airportArrivalId" : 20,
 * "hotelId": 22,
 * "departureDate" : "2022-09-11",
 * "arrivalDate" : "2022-09-18"
 * }
 * <p>
 * <p>
 * http://localhost:8080/trip
 *
 * searchuri:
 http://localhost:8080/search-by-arrivalid?arrivalid=20
 http://localhost:8080/display-all-trips
 http://localhost:8080/search-by-arrival-location?arrivalLocation=MAD



 *
 */

@RestController
public class TripController {

    @Autowired
    private TripService tripService;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private AirportService airportService;

    @PostMapping(value = "/trip")
    public TripResponseDto save(@RequestBody TripDto tripDto) {
        Trip trip = convertTripDtoToTrip(tripDto);
        trip = tripService.save(trip);
        return convertToResponseTrip(trip);
    }

    public TripResponseDto convertToResponseTrip(Trip trip) {
        TripResponseDto dto = new TripResponseDto();
        dto.setContinent(trip.getHotel().getCity().getCountry().getContinent().getContinentName().name());
        dto.setCountry(trip.getHotel().getCity().getCountry().getName());
        dto.setCity(trip.getHotel().getCity().getName());
        //use remaining setters
        dto.setHotelName(trip.getHotel().getName());
        dto.setDepartureAirportName(trip.getDeparture().getName());
        dto.setArrivalAirportName(trip.getArrival().getName());
        dto.setStars(trip.getHotel().getStarNumber());
        return dto;
    }

    public Trip convertTripDtoToTrip(TripDto tripDto) {
        Trip trip = new Trip();
        trip.setArrival(airportService.findById(tripDto.getAirportArrivalId()));
        trip.setDeparture(airportService.findById(tripDto.getAirportDepartureId()));
        trip.setHotel(hotelService.findById(tripDto.getHotelId()));
        trip.setDepartureDate(tripDto.getDepartureDate());
        trip.setArrivalDate(tripDto.getArrivalDate());
        return trip;
    }

//    @GetMapping (value="/search-by-arrival")
//    public List<Trip> findByArrival (@RequestParam (required = true) Trip trip) {
//        return tripService.findByArrival(trip);
//    }

    @GetMapping(value = "/search-by-arrival-location")
    public List<Trip> findByArrival(
            @RequestParam(required = true) String arrivalLocation) {
        return tripService.findByArrival(arrivalLocation);
    }

    @GetMapping(value = "/search-by-arrivalid")
    public List<Trip> findAllByArrivalId(@RequestParam(required = true) Long id) {
        return tripService.findAllByArrivalId(id);
    }

    @GetMapping(value = "/display-all-trips")
    public List<Trip> findAll() {
        return tripService.findAll();
    }




}
