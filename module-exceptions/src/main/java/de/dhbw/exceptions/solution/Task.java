package de.dhbw.exceptions.solution;

public class Task implements Executable {

    @Override
    public void execute() throws CheckedException {
        // code to be executed, but is risk, can fail!
        executeSomethingRiskyButUserCancels();
    }

    /**
     * For example, user clicks a 'cancel' button to interrupt the current running process, one way to react
     * is to throw an exception ...
     *
     * @throws InterruptedException thrown if user interrupts risky process
     */
    private void executeSomethingRiskyButUserCancels() throws InterruptedException {
        throw new InterruptedException();
    }

}