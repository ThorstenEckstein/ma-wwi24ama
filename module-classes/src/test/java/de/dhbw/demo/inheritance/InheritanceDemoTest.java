package de.dhbw.demo.inheritance;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InheritanceDemoTest {

    @Test
    @DisplayName("Demo: Vererbung von Methoden")
    public void canInheritSuperClass() {
        // given
        LongDistanceTrain longDistanceTrain = new LongDistanceTrain();

        // when
        String id = longDistanceTrain.getId();

        // then
        assertEquals("1", id);
    }

    @Test
    @DisplayName("""
    Demo: Polymorphismus mit 'getId()'
    
          [Train]
           /        \
          / extends  \
         /            \
    [LongDistanceTrain] [RegionalTrain]
    
    """)
    public void canUsePolymorphism1() {
        // given
        LongDistanceTrain longDistanceTrain = new LongDistanceTrain();
        RegionalTrain regionalTrain = new RegionalTrain();
        //Train train = new LongDistanceTrain();
        //Train train = new RegionalTrain();

        // when
        String id1 = longDistanceTrain.getId();
        String id2 = regionalTrain.getId();

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
        Train train = new Train();
        String className = train.whoAmI();

        assertEquals("Train", className);

        // given :: when :: then
        train = new LongDistanceTrain();
        className = train.whoAmI();

        assertEquals("LongDistanceTrain", className);

        // given :: when :: then
        train = new RegionalTrain();
        className = train.whoAmI();

        assertEquals("RegionalTrain", className);
    }

}