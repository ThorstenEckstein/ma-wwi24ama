package de.dhbw.demo.ex5;

public class GetCurrentThreadNameApp {

    public static void main(String[] args) {

        Runnable runnable = () -> {

            // get the name of the current executing thread
            String name = Thread.currentThread().getName();

            System.out.println(name + " running");
            System.out.println(name + " finished");
        };

        // set the name of the thread to execute
        Thread thread = new Thread(runnable, "My Thread");
        thread.start();
    }

}