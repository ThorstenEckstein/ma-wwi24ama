package de.dhbw.demo.ex8;

public class StoppableRunnable implements Runnable {

    private boolean stopRequested = false;

    /* NOTE
     * 'synchronized' basically means that this method can only be executed by
     * one thread at the same time for an instance of StoppableRunnable.
     */
    public synchronized void requestStop() {
        this.stopRequested = true;
    }

    public synchronized boolean isStopRequested() {
        return this.stopRequested;
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("StoppableRunnable running");

        while(!isStopRequested()) {
            sleep(1000);
            System.out.println("...");
        }

        System.out.println("StoppableRunnable stopped");
    }
}
