package com.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class NumberListConverterTest {

    @Mock
    private MathFunction function;

    private NumberListConverter underTest;

    @Before
    public void setUp() {
        underTest = new NumberListConverter();
    }

    @Test
    public void test1() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);

        List<Integer> result = underTest.convert(numbers, function);

        verify(function).apply(1);
        verify(function).apply(2);
        verify(function).apply(3);
        verifyNoMoreInteractions(function);
    }



}