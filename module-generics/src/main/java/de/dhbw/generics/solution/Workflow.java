package de.dhbw.generics.solution;

public class Workflow {

    public static <T extends Step> void execute(T step) {
        System.out.printf(
                "Ausführung des Schrittes '%s' ...\n",
                step.getClass().getSimpleName());
    }

}