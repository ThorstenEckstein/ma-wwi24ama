package de.dhbw.questions;

import de.dhbw.commons.Answer;
import de.dhbw.solution.ExamAnswers;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static de.dhbw.commons.Answers.*;
import static de.dhbw.commons.Answers.butMaybeWrong;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled
@SuppressWarnings({"All"})
@DisplayName(
        "Questions for module classes, objects, instances"
)
public class ExamQuestions {

    private final ExamAnswers correctAnswers = new ExamAnswers();

    @DisplayName(
            """
            Q1: Consider the following class definition:
            
            public class Test extends Base {
              public Test(int j) {}
              public Test(int j, int k) { super(j, k); }
            }
            
            Which of the following are legitimate calls to construct instances of the Test class?
            
            A. Test t = new Test();
            B. Test t = new Test(1);
            C. Test t = new Test(1, 2);
            D. Test t = new Test(1, 2, 3);
            E. Test t = new Base();
            """
    )
    @ValueSource(strings = {"?"})
    @ParameterizedTest
    public void question1(String studentAnswer) {
        // given
        Answer correctAnswer = correctAnswers.of(Q1);

        // when
        boolean isCorrect = correctAnswer.getLetters().contains(studentAnswer);

        // then
        assertTrue(isCorrect, butMaybeWrong(Q1, studentAnswer));
    }

    @DisplayName(
            """
            Q2: Liste die drei Schritte zur Erzeugung eines Objektes für eine Klasse auf?
            """
    )
    @Test
    public void question2() {
        // given
        Answer commonExplanation = correctAnswers.of(Q2);

        // when
        final String studentExplanation =
                """
                ... your answer here ...
                """;

        // then
        System.out.println(commonExplanation.face(studentExplanation));
    }

}