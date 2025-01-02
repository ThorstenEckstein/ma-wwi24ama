package de.dhbw.semantics.demo;

@SuppressWarnings({"UnusedAssignment", "ReassignedVariable", "ParameterCanBeLocal"})
public class AccountManager {

    public void depositV1(int amount, int deposit) {
        // amount = amount + deposit;
        amount += deposit;
    }

    public void depositV2(Account account, int deposit) {
        account = new Account(250);
        account.deposit(deposit);
    }

    public void depositV3(Account account, int deposit) {
        account.deposit(deposit);
    }

}
