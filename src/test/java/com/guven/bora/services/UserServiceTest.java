package com.guven.bora.services;

import com.guven.bora.models.User;
import com.guven.bora.repositories.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Before
    public void setup(){
//        userRepositoryMock = mock(UserRepository.class);
        userService = new UserServiceImpl(userRepositoryMock);
    }

    @Mock
    UserRepository userRepositoryMock;

    UserService userService;

    @Test
    public void shouldReturnInstanceOfUserService(){
        assertNotNull(userService);
    }


    @Test
    public void shouldReturnListOfAllUsers(){
        List<User> users =
                Arrays.asList(
                new User("Bora", "Guven", 53),
                new User("Brittney", "Yuille", 43),
                new User("Leyla", "Guven", 9),
                new User("Dilara", "Guven", 6));

        doReturn(users).when(userRepositoryMock).getAllUsers();


        assertNotNull(userService.getAllUsers());

        assertEquals(4, userService.getAllUsers().size());
        verify(userRepositoryMock,atLeastOnce()).getAllUsers();

    }

    @After
    public void tearDown(){
        userRepositoryMock=null;
        userService = null;
    }
}
