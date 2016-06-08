package ru.javawebinar.topjava.dao.impl;

import ru.javawebinar.topjava.dao.MealsDAO;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.util.UserMealsUtil;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Alex on 08.06.2016.
 */
public class MealsDAOImpl implements MealsDAO{

    private static List<UserMeal> mealList = UserMealsUtil.getMealList();

    @Override
    public long createMeal(UserMeal meal) {
        return 0;
    }

    @Override
    public UserMeal updateMeal(UserMeal meal) {
        return null;
    }

    @Override
    public void deleteMeal(long id) {
        Iterator<UserMeal> iterator = mealList.iterator();
        while (iterator.hasNext()){
            if (iterator.next().getId() == id)
                iterator.remove();

        }
    }

    @Override
    public List<UserMeal> getAllMeals() {
        return null;
    }
}
