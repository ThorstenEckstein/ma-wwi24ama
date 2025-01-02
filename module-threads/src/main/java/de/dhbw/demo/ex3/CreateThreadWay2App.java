package de.dhbw.demo.ex3;

public class CreateThreadWay2App {
    public static void main(String[] args) {

        /*
         * Way 2: Use a class that implements Runnable
         */

        Thread thread = new Thread(new CreateThreadWay2());
        thread.start();
    }

}