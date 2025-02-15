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
    @DisplayName("""
    Demo: Polymorphismus mit 'getId()'
    
          [SuperClass]
           /  ext.  \
    [SubClass1] [SubClass1]
    
    """)
    public void canUsePolymorphism1() {
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

    @Test
    @DisplayName("""
    Demo: Polymorphismus 'whoAmI'
    
    !!!
      Zum besseren Verständnis am besten durch den Test 'debuggen'
      und die Veränderungen be jedem Schritt nachvollziehen
    !!!
    
    """)
    public void canUsePolymorphism2() {
        // given :: when :: then
        SuperClass clazz = new SuperClass();
        String className = clazz.whoAmI();

        assertEquals("SuperClass", className);

        // given :: when :: then
        clazz = new SubClass1();
        className = clazz.whoAmI();

        assertEquals("SubClass1", className);

        // given :: when :: then
        clazz = new SubClass2();
        className = clazz.whoAmI();

        assertEquals("SubClass2", className);
    }

}