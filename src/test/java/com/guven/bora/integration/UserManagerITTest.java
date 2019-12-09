package com.guven.bora.integration;

import com.guven.bora.BaseTest;
import com.guven.bora.managers.UserManager;
import com.guven.bora.models.User;
import com.guven.bora.repositories.UserRepositoryImpl;
import com.guven.bora.services.UserServiceImpl;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

public class UserManagerITTest extends BaseTest {
    private static Connection connection;

    @BeforeClass
    public static void setupClass() throws SQLException {
//        connection = getH2Connection();
        connection = getMYSQLConnection();
        addTable(connection);
        insertData(connection);
    }

    @Test
    public void shouldReturnTrue(){
        assertTrue(true);
    }
    @Test
    public void shouldReturnAnUnstanceOfUserManager(){
        UserManager userManager=new UserManager(null);
        assertNotNull(userManager);
    }

    @Test
    public void shouldReturnListOfAllUsersWhenGetAllUsersCalled(){
        final UserManager userManager = new UserManager(
                new UserServiceImpl(
                        new UserRepositoryImpl(connection)));
        List <User> results = userManager.getAllUsers();
        assertFalse(results.isEmpty());
        assertEquals(13,results.size());

    }

    @AfterClass
    public static void terdownClass() throws SQLException {
        dropTable(connection);
    }

}
