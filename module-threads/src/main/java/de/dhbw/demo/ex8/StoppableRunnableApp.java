package de.dhbw.demo.ex8;

public class StoppableRunnableApp {

    public static void main(String[] args) {

        StoppableRunnable stoppableRunnable = new StoppableRunnable();
        Thread thread = new Thread(stoppableRunnable);
        thread.start();

        try {
            Thread.sleep(5000); // 'main' Thread shall sleep 5 secs
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Requesting stop");
        stoppableRunnable.requestStop();
        System.out.println("Stop requested");

        // 'main' Thread terminates here!
    }

}