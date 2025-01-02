package de.dhbw.operators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("InnerClassMayBeStatic")
public class OperatorDemoTests {

    private final List<Combination> combinations = new LinkedList<>();

    private class Combination {
        public boolean operand1, operand2;

        public Combination(boolean operand1, boolean operand2) {
            this.operand1 = operand1;
            this.operand2 = operand2;
        }
    }

    @BeforeEach
    public void beforeEach() {
        combinations.add(new Combination(true, true));
        combinations.add(new Combination(true, false));
        combinations.add(new Combination(false, true));
        combinations.add(new Combination(false, false));
    }

    @Test
    @DisplayName("(1) Logischer Operator: & (both evaluated)")
    public void testOperator1() {
        // given
        for (Combination combination : combinations) {
            // when - both are evaluated!
            boolean result = combination.operand1 & combination.operand2;

            // then
            System.out.printf("\n%s & %s -> %s",
                combination.operand1,
                combination.operand2,
                result
            );
        }
    }

    @Test
    @DisplayName("(2) Logischer Operator: &&")
    public void testOperator2() {
        // given
        for (Combination combination : combinations) {
            // when - evaluation stops after operand1 has been evaluated to 'false'
            boolean result = combination.operand1 && combination.operand2;

            // then
            System.out.printf("\n%s && %s -> %s",
                combination.operand1,
                combination.operand2,
                result
            );
        }
    }

    @Test
    @DisplayName("(3) Logischer Operator: | (both evaluated)")
    public void testOperator3() {
        // given
        for (Combination combination : combinations) {
            // when
            boolean result = combination.operand1 | combination.operand2;

            // then
            System.out.printf("\n%s | %s -> %s",
                combination.operand1,
                combination.operand2,
                result
            );
        }
    }

    @Test
    @DisplayName("(4) Logischer Operator: ||")
    public void testOperator4() {
        // given
        for (Combination combination : combinations) {
            // when - evaluation stops after operand1 has been evaluated to 'false'
            boolean result = combination.operand1 || combination.operand2;

            // then
            System.out.printf("\n%s || %s -> %s",
                combination.operand1,
                combination.operand2,
                result
            );
        }
    }

    @Test
    @DisplayName("(5) Logischer Operator: ^")
    public void testOperator5() {
        // given
        for (Combination combination : combinations) {
            // when
            boolean result = combination.operand1 ^ combination.operand2;

            // then
            System.out.printf("\n%s ^ %s -> %s",
                combination.operand1,
                combination.operand2,
                result
            );
        }
    }

}
