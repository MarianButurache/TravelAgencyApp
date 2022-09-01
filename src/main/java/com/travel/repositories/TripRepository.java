package com.travel.repositories;

import com.travel.entities.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    List<Trip> findAllByArrivalLike(String arrival);
    List<Trip> findAllByArrivalId (Long id);
   List<Trip> findAll ();
}
