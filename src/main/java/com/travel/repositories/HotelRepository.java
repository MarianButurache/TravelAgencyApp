package com.travel.repositories;

import com.travel.entities.Hotel;
import com.travel.entities.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository <Hotel, Long>{

  // Hotel findById(Long id);
    //de discutat cu Rares
    List<Hotel> findAll();

    Hotel findHotelById(Long id);

}
