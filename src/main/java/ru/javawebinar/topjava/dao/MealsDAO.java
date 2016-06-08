package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.UserMeal;

import java.util.List;

/**
 * Created by Alex on 08.06.2016.
 */
public interface MealsDAO {
    long createMeal(UserMeal meal);
    UserMeal updateMeal(UserMeal meal);
    void deleteMeal(long id);
    List<UserMeal> getAllMeals();
}
