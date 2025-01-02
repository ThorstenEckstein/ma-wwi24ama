package de.dhbw.demo.ex1;

public class BasicThreadApp {
    public static void main(String[] args) {

        // create a separate Thread (is not the 'main Thread')
        Thread thread = new Thread();
        thread.start();

        // 'main' Thread terminates immediately here!
    }
}