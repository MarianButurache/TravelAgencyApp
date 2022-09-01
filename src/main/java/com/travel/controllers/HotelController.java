package com.travel.controllers;

import com.travel.dto.HotelDto;
import com.travel.entities.Hotel;
import com.travel.entities.Meal;
import com.travel.entities.MealTypeName;
import com.travel.repositories.HotelRepository;
import com.travel.services.CityService;
import com.travel.services.HotelService;
import com.travel.services.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * hotel endpoints (crud)
 * trip endpoints (crud)
 * trip purchase endpoints (create, read, update)
 *
 */

/**
 * POST - CREATE
 * GET - READ
 * PUT - UPDATE
 * DELETE - DELETE
 {
 "name" : "Majestic",
 "starNumber" : "5",
 "meal" : "BB",
 "description": "cel mai frumos hotel",
 "city":"Madrid"
 }
 * http://localhost:8080/hotels
 */

@RestController
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @Autowired
    private CityService cityService;

    @Autowired
    private MealService mealService;

    //adaugat 15.08.2022
    @Autowired
    private HotelRepository hotelRepository;

    @PostMapping(value = "/hotels")
    // @RequestBody - annotare care transforma JSON-ul trimis de utilizator
    // intr-un obiect java : proces de deserializare (mesaj -> obiect java);
    public HotelDto save(@RequestBody HotelDto hotelDto) {
       Hotel entity = mapDtoTOHotel(hotelDto);
       Hotel savedEntity =  hotelService.save(entity);
       return mapEntityHotelToDto(savedEntity);
    }

    @GetMapping(value = "/hotels", produces = "application/json")
    public List<Hotel> findAll() {
        return hotelService.findAll();
    }

   /* @GetMapping(value = "/hotels/{id}")
        public Hotel findById(@PathVariable Long id) {
        return hotelService.findById(id);
    }*/ //comentat 15.08.2022

//    @GetMapping(value = "/hotels")
//    public List<Hotel> getAllHotels () {
//        return hotelService.getAllHotels();
//    }

//    @GetMapping (value = "/hotels", produces = "application/json")
//    public ResponseEntity <List<Hotel>> getAllHotels() {
//        List<Hotel> hotels = hotelService.findAll();
//        return ResponseEntity.ok(hotels);
//    }

    @GetMapping(value = "/hotels/{id}")
    public Hotel getHotelById(@PathVariable Long id) {
        return hotelService.getHotelById(id);
    }

    @DeleteMapping(value = "/hotels/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        hotelService.delete(id);
        ResponseEntity response = new ResponseEntity(HttpStatus.NO_CONTENT);
        return response;
    }
    @PutMapping(value = "/hotels/{id}")
    public Hotel update(@PathVariable Long id, @RequestBody Hotel hotel) {
        return hotelService.update(id, hotel);
    }

    public Hotel mapDtoTOHotel(HotelDto hotelDto) {
        Hotel hotel = new Hotel();
        hotel.setName(hotelDto.getName());
        hotel.setDescription(hotelDto.getDescription());
        hotel.setStarNumber(hotelDto.getStarNumber());
        hotel.setCity(cityService.findByName(hotelDto.getCity()));
        Meal meal = new Meal();
        meal.setMealTypeName(MealTypeName.valueOf(hotelDto.getMeal()));
        hotel.setMeal(meal);
        return hotel;

    }

    public HotelDto mapEntityHotelToDto (Hotel hotel) {
        HotelDto hotelDto = new HotelDto();
        hotelDto.setId(hotel.getId());
        hotelDto.setName(hotel.getName());
        hotelDto.setDescription(hotel.getDescription());
        hotelDto.setStarNumber(hotel.getStarNumber());
        hotelDto.setCity(hotel.getCity().getName());
        hotelDto.setMeal(hotel.getMeal().getMealTypeName().name());
        return hotelDto;
    }


}
