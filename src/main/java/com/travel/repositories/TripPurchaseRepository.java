package com.travel.repositories;

import com.travel.entities.City;
import com.travel.entities.TripPurchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripPurchaseRepository extends JpaRepository <TripPurchase, Long> {

}
