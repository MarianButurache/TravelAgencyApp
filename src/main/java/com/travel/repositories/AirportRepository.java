package com.travel.repositories;

import com.travel.entities.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
    Airport findByName(String airport);
   // Airport findById(Long id);
    // de ce nu trebuie totusi sa definesc?
}
