package com.travel.services;

import com.travel.entities.Hotel;
import com.travel.exceptions.ResourceNotFoundException;
import com.travel.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public Hotel save (Hotel hotel) {
       return hotelRepository.save(hotel);
    }

    public void delete(Long id) {
        hotelRepository.deleteById(id);
    }

    public Hotel update(Long id, Hotel hotel) {
        Optional<Hotel> optionalDbHotel = hotelRepository.findById(id);
        // daca obiectul exista in db
        if (optionalDbHotel.isPresent()) {
            // il laum din Optional
            Hotel dbHotel = optionalDbHotel.get();
            // setam noile valori

            dbHotel.setCity(hotel.getCity());
            dbHotel.setDescription(hotel.getDescription());
            dbHotel.setId(hotel.getId());
            dbHotel.setMeal(hotel.getMeal());
            dbHotel.setStarNumber(hotel.getStarNumber());
            dbHotel.setName(hotel.getName());
            dbHotel.setArrivalDate(hotel.getArrivalDate());
            dbHotel.setDepartureDate(hotel.getDepartureDate());
            return hotelRepository.save(dbHotel);
        }
        // d -> digit
        // formateaza string-ul in asa fel incat sa faca replace la %d cu variabila id
        throw new ResourceNotFoundException(String.format("Resource with id %d does not exist", id));
    }

    public List<Hotel> findAll() {
 /*       List<Hotel> hotelList = hotelRepository.findAll();
        hotelList.forEach(el ->
                el.setName(el.getName().toUpperCase(Locale.ROOT)));
        return hotelList;*/ // 14.08.2022 - aici functiona....
        return  hotelRepository.findAll();
    }

    public Hotel findById(Long id) {
        Optional<Hotel> hotelById = hotelRepository.findById(id);
        if (hotelById.isPresent()) {
            return hotelById.get(); // 15.08.2022 adaugat
        }
        throw new ResourceNotFoundException(String.format("Resource with id %d does not exist", id));
    }
    public Hotel getHotelById(Long id) {
            return hotelRepository.findHotelById(id);
        }

        public List <Hotel> getAllHotels () {
        return hotelRepository.findAll();
        }
}
