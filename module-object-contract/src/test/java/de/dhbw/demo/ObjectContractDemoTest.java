package de.dhbw.demo;

import de.dhbw.demo.objectcontract.MyOwnClass;
import de.dhbw.demo.objectcontract.Passenger;
import de.dhbw.demo.objectcontract.Train;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ObjectContractDemoTest {

    @Test
    @DisplayName("Object Contract")
    //tag::object-contract[]
    public void objectContract() {
        // given
        Object obj1 = new Object();
        Object obj2 = new Object();

        // when
        int hashCode1       = obj1.hashCode();
        int hashCode2       = obj1.hashCode();
        boolean areEqual    = obj1.equals(obj2);
        String obj1AsString = obj1.toString();
        String obj1Name     = obj1.getClass().getName();

        // then
        assertEquals(hashCode1, hashCode2);
        assertFalse(areEqual);
        assertTrue(obj1AsString.startsWith("java.lang.Object@")); System.out.println("obj1.toString() => "+obj1AsString);
        assertEquals("java.lang.Object", obj1Name);

        MyOwnClass myOwnClass = new MyOwnClass();
        assertNotNull(myOwnClass);
    }
    //end::object-contract[]

    //tag::object-contract-1[]
    @Test
    @DisplayName("Demo 1: Instances Not Equal")
    public void cannotCommitEqualInstances() {
        // given
        Passenger passenger1 = new Passenger("Brad Pitt");
        Passenger passenger2 = new Passenger("Brad Pitt");

        // when
        boolean areEqual = passenger1.equals(passenger2);

        // then
        assertFalse(areEqual);
        System.out.printf(
                "%s != %s  %n",
                passenger1.hashCode(),
                passenger2.hashCode());
    }
    //end::object-contract-1[]

    //tag::object-contract-2[]
    @Test
    @DisplayName("Demo 2: Instance Equality")
    public void canCommitEqualInstances() {
        // given
        Train train1 = new Train("RB-10");
        Train train2 = new Train("RB-10");

        // when
        boolean areEqual = train1.equals(train2);

        // then
        assertTrue(areEqual);
        System.out.printf(
                "%s == %s  %n",
                train1.hashCode(),
                train2.hashCode());
    }
    //end::object-contract-2[]

}