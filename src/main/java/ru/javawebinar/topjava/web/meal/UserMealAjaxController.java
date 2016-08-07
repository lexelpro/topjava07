package ru.javawebinar.topjava.web.meal;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.to.UserMealWithExceed;

import java.util.List;

/**
 * Created by Alex on 07.08.2016.
 */
@RestController
@RequestMapping("/ajax/admin/users/meals")
public class UserMealAjaxController extends AbstractUserMealController {

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserMealWithExceed> getAll() {
        return super.getAll();
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(int id) {
        //TODO implement method delete
    }

    public UserMeal createOrUpdate (UserMeal meal) {
        //TODO implement method createOrUpdate
    }
}
