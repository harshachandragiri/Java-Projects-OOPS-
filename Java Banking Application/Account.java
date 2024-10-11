// Account.java
public class Account {
    private static int accountCounter = 1000;
    private int accountNumber;
    private double balance;
    private Customer customer;

    // Constructor
    public Account(Customer customer, double initialDeposit) {
        this.customer = customer;
        this.balance = initialDeposit;
        this.accountNumber = ++accountCounter;
    }

    // Getters
    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    // Deposit Method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw Method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    // Display Account Details
    public void displayAccountInfo() {
        System.out.println("Account Number : " + accountNumber);
        customer.displayCustomerInfo();
        System.out.println("Balance        : $" + balance);
    }
}
