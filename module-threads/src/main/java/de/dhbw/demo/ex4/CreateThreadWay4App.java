package de.dhbw.demo.ex4;

public class CreateThreadWay4App {

    public static void main(String[] args) {

        /*
         * Way 4: Use a Lambda Expression
         */

        Runnable runnable = () -> {
            System.out.println("Lambda expression running");
            System.out.println("Lambda expression finished");
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }

}