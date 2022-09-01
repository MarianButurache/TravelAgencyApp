package com.travel.services;

import com.travel.entities.Trip;
import com.travel.exceptions.ResourceNotFoundException;
import com.travel.repositories.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

// save, update,delete

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    public Trip save(Trip trip) {
        LocalDate departureDate = trip.getDepartureDate();
        LocalDate arrivalDate = trip.getArrivalDate();
        long totalNumberOfDays = ChronoUnit.DAYS.between(arrivalDate, departureDate);
        trip.setDays((int) totalNumberOfDays);
        return tripRepository.save(trip);
    }

    public List<Trip> findAll() {
        List<Trip> tripListList = tripRepository.findAll();
        return tripListList;
    }

    public void delete(Long id) {
        tripRepository.deleteById(id);
    }

    public Trip update(Long id, Trip trip) {
        Optional<Trip> optionalDbTrip = tripRepository.findById(id);
        // daca obiectul exista in db
        if (optionalDbTrip.isPresent()) {
            // il laum din Optional
            Trip dbTrip = optionalDbTrip.get();
            // setam noile valori

            dbTrip.setDeparture(trip.getDeparture());
            dbTrip.setDepartureDate(trip.getDepartureDate());
            dbTrip.setArrival(trip.getArrival());
            dbTrip.setArrivalDate(trip.getArrivalDate());
            dbTrip.setDays(trip.getDays());
            return tripRepository.save(dbTrip);
        }
        // d -> digit
        // formateaza string-ul in asa fel incat sa faca replace la %d cu variabila id
        throw new ResourceNotFoundException(String.format("Resource with id %d does not exist", id));
    }

    public Trip findById(Long id) {
        Optional<Trip> tripById = tripRepository.findById(id);
        if (tripById.isPresent()) {
            return tripById.get();
        }
        throw new ResourceNotFoundException(String.format("Resource with id %d does not exist", id));
    }

   // public List<Trip> findByArrival (Trip trip) {
   //     return tripRepository.findAllByArrivalLike(trip);
   // }
    public List<Trip> findAllByArrivalId (Long id) {
        return  tripRepository.findAllByArrivalId(id);
    }


    public List<Trip> findByArrival(String arrivalLocation) {
        return tripRepository.findAllByArrivalLike(arrivalLocation);
    }
}
