package de.dhbw.demo.ex4;

public class CreateThreadWay3App {

    public static void main(String[] args) {

        /*
         * Way 3: Use an anonymous implementation of Runnable
         */

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous Runnable running");
                System.out.println("Anonymous Runnable finished");
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }

}