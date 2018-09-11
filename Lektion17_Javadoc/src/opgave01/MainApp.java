package opgave01;

import java.util.concurrent.ThreadLocalRandom;

public class MainApp {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            double balance = Math.round(ThreadLocalRandom.current().nextDouble(-10.0, (1000.0 + 1.0)));
            BankAccount bc = new BankAccount(balance);
            System.out.println("Created account with $" + balance + ". There are now " + BankAccount.getTotalAccounts()
                    + " accounts total.");
            System.out.println("Balance of account " + bc.getID() + ": " + bc.getBalance());
            System.out.println("Depositing $500.");
            bc.deposit(500);
            System.out.println("Balance of account " + bc.getID() + ": " + bc.getBalance());
            System.out.println("Withdrawing $700.");
            bc.withdraw(700);
            System.out.println("Test Complete!");
            System.out.println("\n\n");
        }

    }

}
