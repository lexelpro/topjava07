package ru.javawebinar.topjava.service.user;

import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.Profiles;
import ru.javawebinar.topjava.service.UserServiceTest;

/**
 * Created by Alex on 07.07.2016.
 */
@ActiveProfiles(profiles = {Profiles.ACTIVE_DB, Profiles.JDBC})
public class UserServiceTestJdbc extends UserServiceTest {
}
