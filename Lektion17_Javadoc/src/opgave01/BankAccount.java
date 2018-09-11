package opgave01;

// Hotkey for JavaDoc block: ALT + SHIFT + J
// Select a method name and use the hotkey.
// JavaDoc can use HTML tags.
// <br> for line breaks.

/**
 * Models a bank account.
 *
 * @author Jonas Præstegaard
 *
 */
public class BankAccount {
    private double balance;
    private int id;

    private static int totalAccounts;

    /**
     * Initializes a bank account with an initial balance.
     *
     * <br>
     * <br>
     * <i>NOTE: Increments <b>BankAccount.totalAccounts</b>.</i>
     *
     * @param initialBalance
     */
    public BankAccount(double initialBalance) {
        id = totalAccounts;
        balance = initialBalance;
        totalAccounts++;
    }

    /**
     * Deposit (add) an amount to the account.
     *
     * <pre>
     * amount &gt; 0
     * </pre>
     *
     * @param amount
     */
    public void deposit(double amount) {
        balance += amount;
    }

    /**
     * Withdraw (substract) an amount from the account.
     *
     * <pre>
     * amount > 0
     * </pre>
     *
     * @param amount
     */
    public void withdraw(double amount) {
        balance -= amount;
    }

    /**
     * Gets the balance of the account.
     *
     * @return The current account balance.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Gets the id of the bank account.
     *
     * @return The ID of the account.
     */
    public int getID() {
        return id;
    }

    /**
     * Gets the amount of bank account objects.
     *
     * @return The total amount of bank accounts initialized.
     */
    public static int getTotalAccounts() {
        return totalAccounts;
    }
}
