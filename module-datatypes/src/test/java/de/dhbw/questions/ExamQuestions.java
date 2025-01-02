package de.dhbw.questions;

import de.dhbw.commons.Answer;
import de.dhbw.solution.ExamAnswers;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static de.dhbw.commons.Answers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled
@SuppressWarnings({"NewClassNamingConvention", "ConstantValue"})
@DisplayName(
        "Questions for module data types"
)
public class ExamQuestions {

    private final ExamAnswers correctAnswers = new ExamAnswers();

    @DisplayName(
            """
            Q1: What do you mean by 'Access Modifier'?
            
            Explain in your own words!
            """
    )
    @Test
    public void question1() {
        // given
        Answer commonExplanation = correctAnswers.of(Q1);

        // when
        final String studentExplanation =
                """
                ... your answer here ...
                """;

        // then
        System.out.println(commonExplanation.face(studentExplanation));
    }

    @DisplayName(
            """
            Q2: What is the default value of byte datatype in Java?
            
            A. null
            B. 0
            C. 0.0
            """
    )
    // Please give your answer here:
    @ValueSource(strings = {"?"})
    @ParameterizedTest
    public void question2(String studentAnswer) {
        // given
        Answer correctAnswer = correctAnswers.of(Q2);

        // when
        boolean isCorrect = studentAnswer.equals(correctAnswer.getLetter());

        // then
        assertTrue(isCorrect, butMaybeWrong(Q2, studentAnswer));
    }

    @DisplayName(
            """
            Q3: What is the default value of boolean datatype in Java?
            
            A. null
            B. true
            C. false
            """
    )
    // Please give your answer here:
    @ValueSource(strings = {"?"})
    @ParameterizedTest
    public void question3(String studentAnswer) {
        // given
        Answer correctAnswer = correctAnswers.of(Q3);

        // when
        boolean isCorrect = studentAnswer.equals(correctAnswer.getLetter());

        // then
        assertTrue(isCorrect, butMaybeWrong(Q3, studentAnswer));
    }

    @DisplayName(
            """
            Q4: What is the range of values that can be assigned to a variable of type 'short'?
            (with i.e. "2exp16" -> "2 hoch 16")
            
            A. Depends on the underlying hardware
            B.       0 .. 2exp16 - 1
            C.       0 .. 2exp32 - 1
            D. -2exp15 .. 2exp15 - 1
            E. -2exp31 .. 2exp31 - 1
            """
    )
    // Please give your answer here:
    @ValueSource(strings = {"?"})
    @ParameterizedTest
    public void question4(String studentAnswer) {
        // given
        Answer correctAnswer = correctAnswers.of(Q4);

        // when
        boolean isCorrect = studentAnswer.equals(correctAnswer.getLetter());

        // then
        assertTrue(isCorrect, butMaybeWrong(Q4, studentAnswer));

        correctAnswer.showDetail(isCorrect);
    }

}