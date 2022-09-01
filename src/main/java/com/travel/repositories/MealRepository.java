package com.travel.repositories;

import com.travel.entities.Meal;
import com.travel.entities.MealTypeName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {
    Meal findByMealTypeName (MealTypeName meal);
}
