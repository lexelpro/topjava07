package ru.javawebinar.topjava.service.user;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.javawebinar.topjava.Profiles;
import ru.javawebinar.topjava.service.UserServiceTest;

/**
 * Created by Alex on 06.07.2016.
 */

@ActiveProfiles(profiles = {Profiles.ACTIVE_DB, Profiles.DATA_JPA})
public class UserServiceTestDataJpa extends UserServiceTest {
}
