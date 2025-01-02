package de.dhbw.demo.realization;

public interface Contract {

    /* public abstract */ int getId();

    /* public abstract */ void setId(int id);

    /* public */ default void print(String something) {
        System.out.println(something);
    }

}