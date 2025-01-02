package de.dhbw.solution;

import de.dhbw.solution.model.FreightWagon;
import de.dhbw.solution.model.PassengerWagon;
import de.dhbw.solution.model.Wagon;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModelSolutionTest {

    @Test
    @DisplayName("Lösung 3: Ein kleines, aber 'vollständiges' Klassenmodell")
    public void solution1() {
        // given
        Wagon passengerWagon = new PassengerWagon();
        Wagon freightWagon = new FreightWagon();

        // when
        passengerWagon.setOrder(1);
        freightWagon.setOrder(2);

        // then
        assertEquals(1, passengerWagon.getOrder());
        assertEquals(2, freightWagon.getOrder());
    }

}
