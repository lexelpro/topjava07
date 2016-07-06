package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.UserMeal;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Alex on 04.07.2016.
 */
public interface ProxyUserMealRepository extends JpaRepository<UserMeal, Integer> {
    @Override
    List<UserMeal> findAll(Sort sort);

    @Override
    @Transactional
    UserMeal save(UserMeal entity);

    @Override
    UserMeal findOne(Integer id);

    @Transactional
    @Modifying
//    @Query(name = User.DELETE)
    @Query("DELETE FROM UserMeal um WHERE um.id=:id AND um.user.id=:userId")
    int delete(@Param("id") int id,@Param("userId") int userId);

    @Query(name = UserMeal.GET_BETWEEN)
    //@Query("SELECT m FROM UserMeal m "+
    //        "WHERE m.user.id=:userId AND m.dateTime BETWEEN :startDate AND :endDate ORDER BY m.dateTime DESC" )
    List<UserMeal> getBetween(@Param("startDate") LocalDateTime startDate, @Param("endDate")LocalDateTime endDate, @Param("userId") int userId);

    @Query("SELECT um from UserMeal um where um.id=?1 and um.user.id=?2")
    UserMeal getUserMeal(@Param("id") int id,@Param("userId") int userId);

    @Query(name = UserMeal.ALL_SORTED)
    //@Query("SELECT m FROM UserMeal m WHERE m.user.id=:userId ORDER BY m.dateTime DESC")
    List<UserMeal> getUserMealAll(@Param("userId") int userId);
}
