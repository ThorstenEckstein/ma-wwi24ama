package de.dhbw.enums;

import de.dhbw.enums.demo.Color;
import de.dhbw.enums.demo.FoodGroup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("unused")
public class EnumsDemoTest {

    @Test
    @DisplayName("Demo 1: Standardfunktionalitäten von enums")
    public void demo1() {
        // given
        Color color = Color.Green;

        // when
        String name = color.name();
        int ordinal = color.ordinal();
        Color[] values = Color.values();
        Color red = Color.valueOf("Red");

        // then
        assertEquals("Green", name);
        assertEquals(1, ordinal);
        assertEquals(8, values.length);
        assertEquals(Color.Red, red);
    }

    @Test
    @DisplayName("Demo 2: Zusätzliche enum Methode")
    public void demo2() {
        // given
        Color red = Color.Unknown;

        // when
        String palette = red.getPalette();

        // then
        assertEquals("RGB", palette);
    }

    @Test
    @DisplayName("Demo 3: Using switch statements, but ...")
    public void demo3() {
        // given
        Color red = Color.Red;

        // when
        Color mixedColor = red.mix(Color.Green);

        // then
        assertEquals(Color.Brown, mixedColor);
    }

    @Test
    @DisplayName("Demo 4: Enhanced enums")
    public void demo4() {
        // given
        FoodGroup foodGroup; // = FoodGroup.Sonstiges;

        // when
        foodGroup = FoodGroup.from("Süßwaren");

        // then
        assertEquals(FoodGroup.Suesswaren, foodGroup);
    }

}