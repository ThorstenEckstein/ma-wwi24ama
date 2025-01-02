package de.dhbw.demo.ex2;

public class CreateThreadWay1App {
    public static void main(String[] args) {

        /*
         * Way 1: Use a class that extends Thread
         */

        CreateThreadWay1 thread = new CreateThreadWay1();
        thread.start();
    }

}