package de.dhbw.commons;

public class Assertions {

    public static final String ASSERTION_FAILURE =
            "[Assertion Failure] Expected '%s', but was '%s'";
    public static final String ASSERTION_FAILURE_WITH_DEFAULT =
            "[Assertion Failure] Expected '%s', but was '%s' (default='%s')";

    public static void assertEquals(String expected, String actual) {
        if (!expected.equals(actual)) {
            String message = String.format(ASSERTION_FAILURE, expected, actual);
            System.err.println(message);
        }
    }

    public static void assertEquals(String expected, String actual, String _default) {
        if (!expected.equals(actual)) {
            String message = String.format(
                    ASSERTION_FAILURE_WITH_DEFAULT, expected, actual, _default);
            System.err.println(message);
        }
    }

    public static void assertEquals(int expected, int actual) {
        if (expected != actual) {
            String message = String.format(ASSERTION_FAILURE, expected, actual);
            System.err.println(message);
        }
    }

    public static void assertTrue(boolean actual) {
        if (!actual) {
            String message = String.format(ASSERTION_FAILURE, true, actual);
            System.err.println(message);
        }
    }

}
