package de.dhbw.exam;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProgrammingTests {

    @Test
    @DisplayName("Aufzählungen")
    public void canImplementControlStructureForEnum() {

        // implement your test code here

    }

    @Test
    @DisplayName("Gleich ist nicht gleich gleich")
    public void canImplementEqualsIsNotEquals() {
        // given
        Password p1 = new Password("askdujhasjd6we5463");
        Password p2 = new Password("askdujhasjd6we5463");

        // when
        boolean areEqual = p1.equals(p2);

        // then
        assertTrue(areEqual);

        List<Object> objects = new LinkedList<>();
    }

}