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
@SuppressWarnings({"All"})
@DisplayName("Questions for module associations")
public class ExamQuestions {

    private final ExamAnswers correctAnswers = new ExamAnswers();

    @DisplayName(
            """
            Q1: Question template for type "explanation"
            """
    )
    @Test
    public void question1() {
        // given
        Answer commonExplanation = correctAnswers.of(Q1);

        // when
        final String studentExplanation =
                """
                ... my answer is ...
                """;

        // then
        System.out.println(commonExplanation.face(studentExplanation));

    }

    @DisplayName(
            """
            Q2: Question template for type "single"
            
            A. ?
            B. ?
            C. ?
            """
    )
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
            Q3: Question template for type "multi"
            
            A. ?
            B. ?
            C. ?
            """
    )
    @ValueSource(strings = {"?","?","?"})
    @ParameterizedTest
    public void question3(String studentAnswer) {
        // given
        Answer correctAnswer = correctAnswers.of(Q3);

        // when
        boolean isCorrect = correctAnswer.getLetters().contains(studentAnswer);

        // then
        assertTrue(isCorrect, butMaybeWrong(Q3, studentAnswer));
    }

}