package de.dhbw.demo.refactoring;

public class AfterRefactoring {

    public String process(String msg, int i, Object... args) {
        StringBuilder errorMessage = prepareMessage(msg);
        insertWhitespaces(errorMessage, i);
        appendArguments(errorMessage, args);
        return errorMessage.toString();
    }

    private StringBuilder prepareMessage(String originalMessage) {
        return new StringBuilder(originalMessage);
    }

    private void insertWhitespaces(StringBuilder text, int nChars) {
        int counter = 1;
        while (counter <= nChars) {
            text.insert(0, " ");
            counter++;
        }
    }

    private void appendArguments(StringBuilder text, Object... args) {
        for (Object arg : args) {
            text.append(": ").append(arg);
        }
    }
}
