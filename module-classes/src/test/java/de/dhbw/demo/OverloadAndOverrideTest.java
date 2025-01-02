package de.dhbw.demo;

import de.dhbw.demo.override.DefaultDisplay;
import de.dhbw.demo.override.Display;
import de.dhbw.demo.override.PlatformDisplay;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OverloadAndOverrideTest {

    //tag::overload[]
    @Test
    public void canOverloadMethods() {
        // given
        de.dhbw.demo.overload.PlatformDisplay display = new de.dhbw.demo.overload.PlatformDisplay();

        // when
        display.update();
        display.update("MA-DA");
        display.update(List.of("MA-DA", "FFM-MUE"));

        // then
    }
    //end::overload[]

    @Test
    public void canOverrideMethods1() {
        // given
        Display display = new DefaultDisplay();

        // when
        display.update(0, "5 minutes delay");

        // then
    }

    //tag::override[]
    @Test
    public void canOverrideMethods2() {
        // given
        Display display = new PlatformDisplay();

        // when
        display.update(0, "5 minutes delay");

        // then
    }
    //end::override[]

}