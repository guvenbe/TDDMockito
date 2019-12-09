package com.guven.bora;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FirstTest {

    @Mock
    List<String> myList;

    @Test
    public void shouldRunFirstTest() {
        List<String> mock = mock(List.class);
        mock.add("one");
        verify(mock).add(anyString());

        myList.add("one");
        verify(myList, times(1)).add(anyString());


    }
}
