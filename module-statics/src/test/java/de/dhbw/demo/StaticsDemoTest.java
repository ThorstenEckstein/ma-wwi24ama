package de.dhbw.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StaticsDemoTest {

    @Test
    @DisplayName("Demo 1: Nutzung eines statischen Feldes")
    public void canUseStaticField() {
        // given
        AClassWithStaticField aClass = null;

        // when
        String staticFieldValue = AClassWithStaticField.myField;

        // ist Folgendes möglich (Zugriff auf statisches Feld über die Klasseninstanz)?
        // String fieldValue = aClass.myField;

        // then
        assertNotNull(staticFieldValue);
    }

    @Test
    @DisplayName("Demo 2: Nutzung einer statischen Methode")
    public void canUseStaticMethod() {
        // given

        // when
        String returnValue = AClassWithStaticMethod.aMethod();

        // then
        assertNotNull(returnValue);
    }

    @Test
    @DisplayName("Demo 3: Configuration")
    public void canGetConfigurationSetting() {
        // given
        String key = Configuration.SETTING_KEY_AUTHOR;

        // when
        String setting = Configuration.getSetting(key);

        // then
        assertEquals("Johnny Walker", setting);
    }

}
