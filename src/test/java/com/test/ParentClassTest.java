package com.test;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ParentClassTest {

    @Mock
    private ChildClass childClass;

    @InjectMocks
    private ParentClass underTest;

    @Test
    public void givenResultFromChildClass_thenReturnThisValue() {
        when(childClass.getResult()).thenReturn("Fake Result");

        String result = underTest.getResultFromChild();

        assertThat(result, Matchers.is("Fake Result"));
        verify(childClass).getResult();
    }

}