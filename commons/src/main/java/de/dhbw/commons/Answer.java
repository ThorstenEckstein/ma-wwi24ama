package de.dhbw.commons;

import java.util.Arrays;
import java.util.List;

import static de.dhbw.commons.Colourizer.green;
import static de.dhbw.commons.Colourizer.red;

public class Answer {

    private List<String> letters;
    private String detail;

    public static final String EXPLANATION = "Z";

    private Answer(String letter, String detail) {
        this.letters = List.of(letter);
        this.detail = detail;
    }

    private Answer(List<String> letters, String detail) {
        this.letters = letters;
        this.detail = detail;
    }

    public static Answer from(String letter) {
        return new Answer(letter, null);
    }

    public static Answer fromMany(String... letters) {
        return new Answer(Arrays.asList(letters), null);
    }

    public static Answer from(String letter, String detail, Object... args) {
        if (args == null || args.length == 0) {
            return new Answer(letter, detail);
        } else {
            return new Answer(letter, String.format(detail, args));
        }
    }

    public static Answer fromExplanation(String detail) {
        return new Answer(EXPLANATION, detail);
    }

    public List<String> getLetters() {
        return letters;
    }

    public String getLetter() {
        if (letters.size() > 1) {
            throw new RuntimeException("Please use getLetters(), because this is a multi-answer question!");
        }
        return letters.get(0);
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void showDetail(boolean answerIsCorrect) {
        if (answerIsCorrect) {
            System.out.printf("%s: %s", letters, detail);
        }
    }

    public String face(String studentExplanation) {
        if (isNoValidAnswer(studentExplanation)) {
            setDetail("HINT: Please give an answer BEFORE (!) checking the common explanation ... ;-)");
        }
        return """
               
               YOUR explanation:
               > %s
               COMMON explanation:
               > %s
               """.formatted(
                       red(studentExplanation) ,
                       green(getDetail())
                );
    }

    private boolean isNoValidAnswer(String studentAnswer) {
        return studentAnswer == null ||
                studentAnswer.isBlank() ||
                studentAnswer.contains("your answer here");
    }

}