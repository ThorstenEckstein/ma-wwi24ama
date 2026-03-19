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

    // "Devide" erfordert eine Fließkommazahl als Rückgabewert, daher festgelegt auf 'double'

    public double divide(T a, T b) {
        if (b.doubleValue() == 0) {
            throw new ArithmeticException("Division durch 0 ist nicht erlaubt.");
        }
        return a.doubleValue() / b.doubleValue();
    }
}