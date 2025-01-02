package de.dhbw.enums;

import de.dhbw.enums.solution.Color;
import de.dhbw.enums.solution.RgbColor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class EnumsSolutionTest {

    @Test
    @DisplayName("Exercise 1: 'Switch' anstelle von 'if-elseif-else'")
    public void exercise1Solution() {
        // given
        Color red = Color.Red;

        // when
        Color mixed = red.mix(Color.Blue);

        // then
        assertEquals(Color.Lila, mixed);
    }

    @Test
    @DisplayName("Exercise 2: r,g,b color enum mit Konstruktor-Argumenten")
    public void exercise2Solution() {
        // given
        RgbColor color = RgbColor.Black;

        // when
        String rgb = color.getRGB();

        // then
        assertEquals("(0,0,0)", rgb);
    }

    @Test
    @DisplayName("Exercise 3: Logische Negierung")
    public void exercise3Solution() {
        // given
        boolean value = true;

        // when
        boolean negated = !value;

        // then
        assertFalse(negated);
    }

}
