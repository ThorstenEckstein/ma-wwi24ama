package de.dhbw.solution;

import de.dhbw.commons.Answer;
import de.dhbw.commons.Answers;

public class ExamAnswers extends Answers {

    static {

        // Type "explanation": multiline answer to be compared to student's answer
        answers.put(Q1, Answer.fromExplanation("""
                multiline answer to be compared to student's answer"""));

        // Type "single": multiple choice having exactly one single letter as the correct answer option
        answers.put(Q2, Answer.from(
                "?"));

        // Type "multi": multiple choice having more than one correct answer option
        answers.put(Q3, Answer.fromMany(
                "?",
                "?",
                "?"));
    }

}