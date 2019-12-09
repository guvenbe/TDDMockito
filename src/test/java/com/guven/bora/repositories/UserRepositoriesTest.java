package com.guven.bora.repositories;

import com.guven.bora.BaseTest;
import com.guven.bora.models.User;
import org.junit.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;


public class UserRepositoriesTest extends BaseTest {

    private static Connection connection;
    private UserRepository userRepository;

    @BeforeClass
    public static void setupClass() throws SQLException {
        connection = getH2Connection();
        addTable(connection);
        insertData(connection);
    }

    @Before
    public void setup(){
        userRepository = new UserRepositoryImpl(connection);
    }




    //Spy mocks behaviour on actual object
    @Test(expected = RuntimeException.class)
    public void shouldTestSpy() throws SQLException {
        connection.createStatement();
        Connection spy = spy(connection);
        when(spy).thenThrow(new RuntimeException("Error calling method"));
        spy.createStatement();
    }

    //Chain beahviour
    //passes first when spy.createStatement() is called
    //Failes second time with runTimeException
    @Test(expected = RuntimeException.class)
    public void shouldTestSpysecondCall() throws SQLException {
        Connection spy = spy(connection);
        when(spy.createStatement()).thenReturn(connection.createStatement()).thenThrow(new RuntimeException());
        spy.createStatement();
        spy.createStatement();

    }

    @Test
    public void shouldReturnUserRepoImpl() {
        assertNotNull(userRepository);

    }

    @Test(expected = RuntimeException.class)
    public void shouldReturnAllUserThenThrowSQLException() throws SQLException {
        final Connection spy = spy(connection);
        when(spy.createStatement()).thenReturn(connection.createStatement()).thenThrow(SQLException.class);
        final UserRepositoryImpl spyRepository = new UserRepositoryImpl(spy);
        final List <User> users = spyRepository.getAllUsers();

        //verify autocommit is never called
        verify(spy,never()).getAutoCommit();

        assertNotNull(users);
        Assert.assertEquals(13,users.size());
        spyRepository.getAllUsers();
    }

    @Test
    public void shouldReturnAllUser() {
        final List <User> users = userRepository.getAllUsers();
        assertNotNull(users);
        Assert.assertEquals(13,users.size());
    }


    @AfterClass
    public static void tearDownClass() throws SQLException {
        connection.createStatement().executeUpdate("DROP TABLE USERS");
        connection.close();
        connection = null;

    }
}
