package com.guven.bora;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorTest {

    private Calculator calculator;

    @Mock
    CalculatorServive calculatorServiveMock;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before class .......");
    }

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator(calculatorServiveMock);
    }

    @Test
    public void shouldReturnInstanceOfCalculator() {
        assertNotNull(calculator);
    }

    @Test
    public void shouldNotRetunInstanceOfCalculator() {
        calculator = null;
        assertNull(calculator);
    }

    @Test
    public void ShouldReturnTwoWhenOnePlusOneCalledOnAdd() {
        when(calculatorServiveMock.add(1, 1)).thenReturn(2);
        int result = calculator.add(1, 1);
        assertEquals(result, 2);
        verify(calculatorServiveMock, times(1)).add(1, 1);


    }
}