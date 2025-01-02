package de.dhbw.demo.ex7;

public class ThreadSleepApp {

    public static void main(String[] args) {

        Runnable runnable = () -> {

            // get the name of the current executing thread
            String name = Thread.currentThread().getName();

            System.out.println(name + " running");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(name + " finished");
        };

        // set the name of the thread to execute
        Thread thread = new Thread(runnable, "My Thread");
        thread.start();

        // 'main' Thread terminates here!
    }

}