package de.dhbw.generics.solution;

public class NumberCalculator<T extends Number> {

    public double add(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }

    public double subtract(T a, T b) {
        return a.doubleValue() - b.doubleValue();
    }

    public double multiply(T a, T b) {
        return a.doubleValue() * b.doubleValue();
    }

    public double divide(T a, T b) {
        if (b.doubleValue() == 0) {
            throw new ArithmeticException("Division durch Null ist nicht erlaubt.");
        }
        return a.doubleValue() / b.doubleValue();
    }
}