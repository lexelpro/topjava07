package ru.javawebinar.topjava.repository.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.AuthorizedUser;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

/**
 * User: gkisline
 * Date: 26.08.2014
 */

@Repository
@Transactional(readOnly = true)
public class JpaUserMealRepositoryImpl implements UserMealRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public UserMeal save(UserMeal userMeal, int userId) {
             if (userMeal.isNew()) {
            em.persist(userMeal);
            return userMeal;
        } else {
            if (em.createNamedQuery(UserMeal.UPDATE)
                    .setParameter("id", userMeal.getId())
                    .setParameter("description", userMeal.getDescription())
                    .setParameter("calories", userMeal.getCalories())
                    .setParameter("date_time", userMeal.getDateTime())
                    .setParameter("user_id", userId)
                    .executeUpdate() == 0)
                return null;
        }
        return userMeal;
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
        return em.createNamedQuery(UserMeal.ALL_SORTED, UserMeal.class).setParameter("userId", userId).getResultList();
    }

    @Override
    public List<UserMeal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {

      /*  return null;*/
       return em.createNamedQuery(UserMeal.BETWEEN, UserMeal.class)
                .setParameter(1, startDate)
                .setParameter(2, endDate)
                .setParameter("userId", userId)
                .getResultList();
    }
}