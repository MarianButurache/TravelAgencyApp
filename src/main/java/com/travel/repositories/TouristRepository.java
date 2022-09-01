package com.travel.repositories;

import com.travel.entities.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TouristRepository extends JpaRepository <Tourist, Long> {
}
