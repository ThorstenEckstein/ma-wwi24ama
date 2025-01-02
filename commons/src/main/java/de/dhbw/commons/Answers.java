package de.dhbw.commons;

import java.util.HashMap;
import java.util.Map;

public class Answers {

    public static final String Q1 = "Q1";
    public static final String Q2 = "Q2";
    public static final String Q3 = "Q3";
    public static final String Q4 = "Q4";
    public static final String Q5 = "Q5";
    public static final String Q6 = "Q6";
    public static final String Q7 = "Q7";
    public static final String Q8 = "Q8";
    public static final String Q9 = "Q9";
    public static final String Q10 = "Q10";

    protected static final Map<String, Answer> answers = new HashMap<>();

    public Answer of(String question) {
        Answer _value = answers.get(question);

        if (_value == null) {
            throw new NullPointerException(
                    "Missing answer for question: " + question);
        }
        return _value;
    }

    public static String butMaybeWrong(String question, Object studentAnswer) {
        return String.format(
                "Sorry, the given answer \"%s\" for question \"%s\" is wrong, try again!",
                studentAnswer,
                question);
    }

}