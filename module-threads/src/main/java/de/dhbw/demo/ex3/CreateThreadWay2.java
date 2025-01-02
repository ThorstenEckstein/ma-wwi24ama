package de.dhbw.demo.ex3;

public class CreateThreadWay2 implements Runnable {

    public static final String clazz = CreateThreadWay2.class.getSimpleName();

    @Override
    public void run() {
        System.out.println(clazz + " running");
        System.out.println(clazz + " finished");
    }

}