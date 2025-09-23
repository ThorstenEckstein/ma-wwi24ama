package de.dhbw.loops;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings({"unused", "EnhancedSwitchMigration", "DuplicateBranchesInSwitch", "DataFlowIssue"})
public class LoopsDemoTest {

    @Test
    @DisplayName("Demo 1: for loop")
    public void demo1() {
        // given

        // when
        for (int i = 0; i < 5; i++) {
            System.out.println("For-Loop: i = " + i);
        }

        // then
    }

    @Test
    @DisplayName("Demo 2: do while loop")
    public void demo2() {
        // given
        int i = 0;

        // when ( mind. 1 Ausführung von do {...} )
        do {
            System.out.println("Do-While-Loop: i = " + i++);
        } while (i < 5);

        // then
        assertEquals(5, i);
    }

    @Test
    @DisplayName("Demo 3: switch case")
    public void demo3() {
        // given
        int i = 7;
        int _case;

        // when
        switch(i) {
            case 0:
                _case = i;
                break;
            case 1:
                _case = i;
                break;
            case 2:
                _case = i;
                break;
            default:
                _case = -1;
                break;
        }

        // then
        System.out.println("Executed case: " + _case);
    }

    @Test
    @DisplayName("Demo 4: pattern matching switch case")
    public void demo4() {
        // given
        int i = 1;
        int _case = switch (i) {
            case 0 -> i;
            case 1 -> i;
            case 2 -> i;
            default -> -1;
        };

        // when

        // then
        System.out.println("Executed case (pattern matching): " + _case);
    }
}