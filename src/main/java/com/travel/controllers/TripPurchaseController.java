package com.travel.controllers;

import com.travel.dto.TripPurchaseDto;
import com.travel.entities.TripPurchase;
import com.travel.services.TripPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * POST - CREATE
 * GET - READ
 * PUT - UPDATE
 * DELETE - DELETE


 {
 "tripId": 24,
 "touristDto" : [ {
 "name" : "test1",
 "gender" : "F",
 "age" : 25
 },
 {
 "name" : "test2",
 "gender" : "M",
 "age" : 15
 }
 ]
 }


 * http://localhost:8080/tripPurchase
 */


@RestController
public class TripPurchaseController {
    @Autowired
    TripPurchaseService tripPurchaseService;

    @PostMapping (value = "/tripPurchase")
    public TripPurchaseDto save (@RequestBody TripPurchaseDto tripPurchaseDto) {
     TripPurchase entity = mapTripPurchaseDtoTOTripPurchase(tripPurchaseDto);
     TripPurchase savedEntity = tripPurchaseService.save(entity);
     return mapTripPurchaseToTripPurchaseDto(savedEntity);
    }

    public TripPurchase mapTripPurchaseDtoTOTripPurchase (TripPurchaseDto tripPurchaseDto) {
        TripPurchase tripPurchase = new TripPurchase();
        tripPurchase.setId(tripPurchaseDto.getId());
        tripPurchase.setAmount(tripPurchaseDto.getAmount());
   // tripPurchase.setPurchaseDate(tripPurchaseDto.getTripPurchaseDate()); atentie aici trebuie continuat
      //  tripPurchase.setTouristList(tripPurchaseDto.getTouristDto()); atentie aici trebuie continuat
        return tripPurchase;
    }

    public TripPurchaseDto mapTripPurchaseToTripPurchaseDto (TripPurchase tripPurchase) {
        TripPurchaseDto tripPurchaseDto= new TripPurchaseDto ();
        tripPurchaseDto.setTripId(tripPurchase.getId());
    // tripPurchaseDto.setTripPurchaseDate(tripPurchase.getPurchaseDate()); atentie aici trebuie continuat
        tripPurchaseDto.setAmount(tripPurchase.getAmount());
     //  tripPurchaseDto.setTouristDto(tripPurchase.getTouristList()); atentie aici trebuie continuat
        tripPurchaseDto.setId(tripPurchase.getId());
        return tripPurchaseDto;

    }

}
