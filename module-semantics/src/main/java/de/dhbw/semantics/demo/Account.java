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
    public static Account process(Account acc) {

        Account a2 = new Account(100);
        acc = a2;

        acc.deposit(250);

        // ... and maybe more with 'acc' ...

        return a2;
    }
}
