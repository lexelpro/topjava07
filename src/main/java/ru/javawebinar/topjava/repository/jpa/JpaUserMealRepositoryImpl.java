package ru.javawebinar.topjava.repository.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.AuthorizedUser;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;

/**
 * User: gkisline
 * Date: 26.08.2014
 */

@Repository
public class JpaUserMealRepositoryImpl implements UserMealRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public UserMeal save(UserMeal userMeal, int userId) {
        if (AuthorizedUser.id() == userId) {
            if (userMeal.isNew()) {
                em.persist(userMeal);
                return userMeal;
            } else {
                return em.merge(userMeal);
            }
        } else {
            //TODO check what should be here
            return null;
        }
    }

    @Override
    @Transactional
    public boolean delete(int id, int userId) {

   /*     TypedQuery<UserMeal> query = em.createQuery("DELETE FROM UserMeal um WHERE um.id=:id AND um.user.id=:userId", UserMeal.class);
        return query.setParameter("id", id).executeUpdate() != 0;*/

       return em.createNamedQuery(UserMeal.DELETE)
               .setParameter("id", id)
               .setParameter("userId", userId)
               .executeUpdate() != 0;
    }

    @Override
    public UserMeal get(int id, int userId) {
        if (AuthorizedUser.id() == userId) {
            return em.find(UserMeal.class, id);
        } else {
            return null;
        }
    }

    @Override
    public List<UserMeal> getAll(int userId) {
        return em.createNamedQuery(UserMeal.ALL_SORTED, UserMeal.class).getResultList();
    }

    @Override
    public List<UserMeal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {

        return em.createNamedQuery(UserMeal.BETWEEN, UserMeal.class)
                .setParameter(1, startDate)
                .setParameter(2, endDate)
                .setParameter(3, userId)
                .getResultList();
    }
}