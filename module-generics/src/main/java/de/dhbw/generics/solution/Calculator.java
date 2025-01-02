package de.dhbw.generics.solution;

public interface Calculator<T extends Number> {
    T add(T first, T second);
    T subtract(T first, T second);
    T multiply(T first, T second);
    T divide(T first, T second);
}
