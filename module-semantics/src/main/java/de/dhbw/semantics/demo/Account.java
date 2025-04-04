package de.dhbw.semantics.demo;

public class Account {

    private int amount;

    public Account() {}

    public Account(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void deposit(int amount) {
        this.amount += amount;
    }

    // just for demonstration purposes!
    public static void process(Account acc) {
        acc.deposit(250);
    }
}
