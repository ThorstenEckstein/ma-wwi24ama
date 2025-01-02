package de.dhbw.loops;

import de.dhbw.commons.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class LoopsSolutionsTest {

    private final Logger logger = new Logger(LoopsSolutionsTest.class);

    @Test
    @DisplayName("Solution for Exercise 1: Eine for Schleife, größte Zahl")
    public void solution1() {
        // given
        List<Integer> numbers = List.of(2,5,3,8,65,4);

        // when
        int max = 0;
        for (int i = 0; i < numbers.size(); i++) {
            int number = numbers.get(i);
            if (number > max) {
                max = number;
            }
        }

        // then
        assertEquals(65, max);

        /*
        Integer max1 = numbers.stream().reduce(Integer::max).orElseThrow();
        Integer max2 = numbers.stream().mapToInt(Integer::intValue).max().orElseThrow();
        Integer max3 = numbers.stream().max(Comparator.naturalOrder()).orElseThrow();

        assertEquals(65, max1);
        assertEquals(65, max2);
        assertEquals(65, max3);
        */
    }

    @Test
    @DisplayName("Solution for Exercise 2: While-Schleife, ein CountDown")
    public void exercise2() {
        // given
        int countdown = 10;

        // when
        System.out.println("CountDown:");
        while (countdown > 0) {
            System.out.println(countdown);
            countdown--;
        }
        System.out.println(countdown);
        System.out.println("... go rocket");

        // then
        assertEquals(0, countdown);
    }

}
