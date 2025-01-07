package de.dhbw.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BasicsTest {

    @Test
    public void canDefinePrimitiveVariable() {
        // given
        int index = 1;

        // when
        index = index + 1;

        // then
        assertEquals(2, index);
    }

    @Test
    public void canDefineClassVariable() {
        // given
        College college = new College();

        // when
        System.out.println(college);

        // then
        assertNotNull(college);
    }

}