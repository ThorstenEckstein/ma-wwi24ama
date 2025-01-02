package de.dhbw.demo.refactoring;

public class BeforeRefactoring {

    public void process(String msg, int i, StringBuilder out, Object... args) {
        int ind = 1;
        out.append(msg);
        while (ind <= i) {
            out.insert(0, " ");
            ind++;
        }
        for (Object arg : args) {
            out.append(": ").append(arg);
        }
    }

}
