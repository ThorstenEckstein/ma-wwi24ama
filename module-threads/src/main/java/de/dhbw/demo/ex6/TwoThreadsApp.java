package de.dhbw.demo.ex6;

public class TwoThreadsApp {

    public static void main(String[] args) {

        Runnable runnable = () -> {
            String name = Thread.currentThread().getName();
            System.out.println(name + " running");
            System.out.println(name + " finished");
        };

        // the order of threads executed is NOT guaranteed!

        Thread thread1 = new Thread(runnable, "My Thread 1");
        thread1.start();

        Thread thread2 = new Thread(runnable, "My Thread 2");
        thread2.start();
    }

}