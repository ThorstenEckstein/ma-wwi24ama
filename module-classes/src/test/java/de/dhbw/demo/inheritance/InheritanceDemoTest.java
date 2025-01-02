package de.dhbw.demo.inheritance;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InheritanceDemoTest {

    @Test
    @DisplayName("Demo: Vererbung von Methoden")
    public void canInheritSuperClass() {
        // given
        SubClass1 subClass1 = new SubClass1();

        // when
        String id = subClass1.getId();

        // then
        assertEquals("1", id);
    }

    @Test
    @DisplayName("Demo: Polymorphismus 'whoAmI'")
    public void canUsePolymorphism1() {
        // given
        SuperClass clazz = new SuperClass();

        // when
        String className = clazz.whoAmI();

        // then
        assertEquals("SuperClass", className);

        clazz = new SubClass1();
        className = clazz.whoAmI();
        assertEquals("SubClass1", className);

        clazz = new SubClass2();
        className = clazz.whoAmI();
        assertEquals("SubClass2", className);
    }

    @Test
    @DisplayName("Demo: Polymorphismus 'getId()'")
    public void canUsePolymorphism2() {
        // given
        SuperClass class1 = new SubClass1();
        SuperClass class2 = new SubClass2();

        // when
        String id1 = class1.getId();
        String id2 = class2.getId();

        // then
        assertEquals("1", id1);
        assertEquals("2", id2);
    }

}