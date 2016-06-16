package ru.javawebinar.topjava.repository.mock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;
import ru.javawebinar.topjava.util.UserMealsUtil;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * GKislin
 * 15.09.2015.
 */
public class InMemoryUserMealRepositoryImpl implements UserMealRepository {
    private static final Logger LOG = LoggerFactory.getLogger(InMemoryUserMealRepositoryImpl.class);


    private Map<Integer, UserMeal> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    {
        UserMealsUtil.MEAL_LIST.forEach(this::save);
    }

    @Override
    public UserMeal save(UserMeal userMeal) {
        LOG.info("Save " + userMeal );

        if (userMeal.isNew()) {
            userMeal.setId(counter.incrementAndGet());
        }
        repository.put(userMeal.getId(), userMeal);
        return userMeal;
    }

    @Override
    public void delete(int id) {
        LOG.info("delete " + id);
        repository.remove(id);
    }

    @Override
    public UserMeal get(int id) {
        LOG.info("get " + id);
        if (repository.size() == 0)
            return null;
        return repository.get(id);
    }

    @Override
    public Collection<UserMeal> getAll() {
        LOG.info("getAll");
        if (repository.size() == 0)
            return null;
        return repository.entrySet().stream().
                sorted(Map.Entry.comparingByValue((um1, um2) -> um1.getDateTime().compareTo(um2.getDateTime()))).
                map( Map.Entry :: getValue).
                collect(Collectors.toList());
    }
}

