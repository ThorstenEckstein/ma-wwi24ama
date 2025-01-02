package de.dhbw.exceptions.solution;

public class Task implements Executable {

    @Override
    public void execute() throws CheckedException {
        // code to be executed, but is risk, can fail!
        executeSomethingRisky();
    }

    private void executeSomethingRisky() throws InterruptedException {
        // For example, user clicks a 'cancel' button to interrupt the current running process,
        // one way to react it to throw an exception ...
        throw new InterruptedException();
    }

}