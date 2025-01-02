package de.dhbw.generics;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Disabled
@SuppressWarnings({"NewClassNamingConvention", "ConstantValue"})
@DisplayName(
        "Questions for module data types"
)
public class ExamQuestions {

    //private final ExamAnswers correctAnswers = new ExamAnswers();

    @DisplayName(
            """
            Q1:...
            """
    )
    @Test
    public void question1() {
        // question without a parameter as answer
    }

    @DisplayName(
            """
            Q2:...
            """
    )
    // Please give your answer here:
    @ValueSource(strings = {"?"})
    @ParameterizedTest
    public void question2(String studentAnswer) {
        // question with a letter as answer
    }

}