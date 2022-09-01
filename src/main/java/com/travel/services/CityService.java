package com.travel.services;

import com.travel.entities.City;
import com.travel.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public City findByName(String name) {
        City city = cityRepository.findByName(name);
        if (city == null) {
            throw new RuntimeException("orasul nu exista");
        }
        return city;
    }

}
