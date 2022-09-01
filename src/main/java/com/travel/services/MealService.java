package com.travel.services;

import com.travel.entities.Meal;
import com.travel.entities.MealTypeName;
import com.travel.repositories.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MealService {

    @Autowired
    private MealRepository mealRepository;

    public Meal findByMealType (MealTypeName mealTypeName) {
        Meal meal = mealRepository.findByMealTypeName(mealTypeName);
            if(meal == null) {
                throw new RuntimeException("meal type doesn't exist");
        }
            return meal;
    }
}
