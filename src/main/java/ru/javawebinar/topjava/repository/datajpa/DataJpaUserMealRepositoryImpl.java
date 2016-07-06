package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

/**
 * GKislin
 * 27.03.2015.
 */
@Repository
public class DataJpaUserMealRepositoryImpl implements UserMealRepository{

    private static final Sort SORT_DATE_DESC = new Sort(Sort.Direction.DESC, "date_time");

    @Autowired
    private ProxyUserMealRepository proxy;

    @Autowired
    private ProxyUserRepository uProxy;

    @PersistenceContext
    private EntityManager em;


    @Override
    public UserMeal save(UserMeal userMeal, int userId) {
        if (!userMeal.isNew() && get(userMeal.getId(), userId) == null) {
            return null;
        }
        //TODO check both options
        userMeal.setUser(uProxy.getOne(userId));
        //userMeal.setUser(em.getReference(User.class, userId));
        return proxy.save(userMeal);
    }

    @Override
    public boolean delete(int id, int userId) {

        return proxy.delete(id, userId) != 0;
    }

    @Override
    public UserMeal get(int id, int userId) {

        return proxy.getUserMeal(id, userId);
    }

    @Override
    public List<UserMeal> getAll(int userId) {
        return proxy.findAll(SORT_DATE_DESC);
    }

    @Override
    public List<UserMeal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        return proxy.getBetween(startDate, endDate, userId);
    }
}
