package com.travel.repositories;

import com.travel.entities.Continent;
import com.travel.entities.ContinentName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContinentRepository extends JpaRepository<Continent, Long> {
    Continent findByContinentName(ContinentName continentName);
}
