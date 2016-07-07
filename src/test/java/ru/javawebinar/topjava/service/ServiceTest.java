package ru.javawebinar.topjava.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.javawebinar.topjava.Profiles;

/**
 * Created by Alex on 06.07.2016.
 */

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
@ActiveProfiles(Profiles.ACTIVE_DB)
public abstract class ServiceTest {

    @Test
    public abstract void testSave() throws Exception;

    @Test
    public abstract void testDelete() throws Exception;

    @Test
    public abstract void testGet() throws Exception;

    @Test
    public abstract void testGetNotFound() throws Exception;

    @Test
    public abstract void testUpdate() throws Exception;

    @Test
    public abstract void testGetAll() throws Exception;

}
