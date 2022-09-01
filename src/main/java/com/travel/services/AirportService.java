package com.travel.services;

import com.travel.entities.Airport;
import com.travel.entities.Hotel;
import com.travel.exceptions.ResourceNotFoundException;
import com.travel.repositories.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirportService {

    @Autowired
    private AirportRepository airportRepository;

    public Airport findByName(String name) {
        Airport airport = airportRepository.findByName(name);
        if (airport == null) {
            throw new RuntimeException("Aeroportul nu exista");
        }
        return airport;
    }



    public Airport findById(Long id) {
        Optional<Airport> airportById = airportRepository.findById(id);
        if (airportById.isPresent()) {
            return airportById.get();
        }
        throw new ResourceNotFoundException(String.format("Resource with id %d does not exist", id));
    }
}
