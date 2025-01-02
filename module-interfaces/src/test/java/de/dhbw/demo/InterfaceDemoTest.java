package de.dhbw.demo;

import de.dhbw.demo.realization.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InterfaceDemoTest {

    //tag::interface-demo-1[]
    @Test
    @DisplayName("Demo 1: Interface & Realisierung")
    public void canRealizeInterface() {
        // given
        Contract contract;

        // when
        contract = new EmploymentContract();
        contract.setId(4);

        // then
        assertEquals(4, contract.getId());

    }
    //end::interface-demo-1[]

    //tag::interface-demo-2[]
    @Test
    @DisplayName("Demo 2: Polymorphismus durch Interfaces")
    public void canRealizePolymorphism() {
        // given
        List<Shape> shapes = new ArrayList<>();

        Shape circle = new Circle();
        Shape square = new Square();

        shapes.add(circle);
        shapes.add(square);

        // when
        for (Shape shape : shapes) {
            System.out.println(shape.name());
        }

        // then
        assertEquals(2, shapes.size());
    }
    //end::interface-demo-2[]

}
