package com.travel.services;

import com.travel.dto.TouristDto;
import com.travel.entities.Hotel;
import com.travel.entities.Tourist;
import com.travel.entities.Trip;
import com.travel.entities.TripPurchase;
import com.travel.repositories.TripPurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripPurchaseService {

    @Autowired
    private TripPurchaseRepository tripPurchaseRepository;

    public TripPurchase save(TripPurchase tripPurchase) {

        calculateAmount(tripPurchase);
        return tripPurchaseRepository.save(tripPurchase);
    }
    public double calculateAmount (TripPurchase tripPurchase) {
        int sum = 0;
        for (Tourist t : tripPurchase.getTouristList()) {
            if (t.getAge() > 18) {
                sum = sum + 30;
            }
            if (t.getAge() > 40) {
                sum = sum + 40;
            }
        }
        Hotel hotel = tripPurchase.getTrip().getHotel();;
        if (hotel.getStarNumber() == 5) {
//            sum = sum + 10%
        }
        return sum;
    }
}

