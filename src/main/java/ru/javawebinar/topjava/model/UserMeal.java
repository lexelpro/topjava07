package ru.javawebinar.topjava.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * GKislin
 * 11.01.2015.
 */
@NamedQueries({
        @NamedQuery(name = UserMeal.UPDATE, query = "UPDATE UserMeal um SET um.description=:description, um.calories=:calories, um.dateTime=:date_time " +
                                                    " WHERE um.id=:id AND um.user.id=:user_id"),
        @NamedQuery(name = UserMeal.DELETE, query = "DELETE FROM UserMeal um WHERE um.id=:id AND um.user.id=:userId"),
        @NamedQuery(name = UserMeal.ALL_SORTED, query = "SELECT um FROM UserMeal um WHERE um.user.id=:userId ORDER BY um.dateTime DESC"),
        @NamedQuery(name = UserMeal.BETWEEN, query = "SELECT um FROM UserMeal um WHERE um.user.id=:userId AND um.dateTime BETWEEN ?1 AND ?2 ORDER BY um.dateTime DESC")
})
@Entity
@Table(name = "meals", uniqueConstraints = {@UniqueConstraint(columnNames = "user_id", name = "MEALS_UNIQUE_USER_DATETIME_IDX"),
        @UniqueConstraint(columnNames = "date_time", name = "MEALS_UNIQUE_USER_DATETIME_IDX")})
public class UserMeal extends BaseEntity {

    public static final String UPDATE = "UserMeal.update";
    public static final String DELETE = "UserMeal.delete";
    public static final String ALL_SORTED = "UserMeal.getAllSorted";
    public static final String BETWEEN = "UserMeal.getBetween";


    @Column(name = "date_time", columnDefinition = "timestamp default now()", nullable = false)
    @NotNull
    private LocalDateTime dateTime;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "calories", nullable = false)
    protected int calories;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public UserMeal() {
    }

    public UserMeal(LocalDateTime dateTime, String description, int calories) {
        this(null, dateTime, description, calories);
    }

    public UserMeal(Integer id, LocalDateTime dateTime, String description, int calories) {
        super(id);
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserMeal{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                '}';
    }
}
