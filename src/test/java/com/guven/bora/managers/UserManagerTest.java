package com.guven.bora.managers;

import com.guven.bora.models.User;
import com.guven.bora.services.UserService;
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
public class UserManagerTest {

    @Mock
    UserService userServiveMock;

    @Test
    public void shouldReturnInstanceOfUserManager(){
        final UserManager userManager = new UserManager(userServiveMock);
        assertNotNull(userManager);

    }

    @Test
    public void shouldReturnListOfusers(){
        when(userServiveMock.getAllUsers()).thenReturn(Arrays.asList(
                new User("Bora", "Guven", 53),
                new User("Brittney", "Yuille", 43),
                new User("Leyla", "Guven", 9),
                new User("Dilara", "Guven", 6)));
        final UserManager userManager = new UserManager(userServiveMock);
        List<User> result= userManager.getAllUsers();
        assertNotNull(result);
        assertEquals(4,result.size());
        verify(userServiveMock, times(1)).getAllUsers();

    }

}
