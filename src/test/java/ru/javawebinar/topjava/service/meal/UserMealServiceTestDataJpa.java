package ru.javawebinar.topjava.service.meal;

import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.Profiles;
import ru.javawebinar.topjava.service.UserMealServiceTest;

/**
 * Created by Alex on 07.07.2016.
 */
@ActiveProfiles(profiles = {Profiles.ACTIVE_DB, Profiles.DATA_JPA})
public class UserMealServiceTestDataJpa extends UserMealServiceTest {
}
