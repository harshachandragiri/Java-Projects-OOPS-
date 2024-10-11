import java.util.List;        // Import the List interface
import java.util.ArrayList;   // Import the ArrayList class

public class Bank {
    private String bankName;
    private List<Account> accounts;

    // Constructor
    public Bank(String bankName) {
        this.bankName = bankName;
        this.accounts = new ArrayList<>();
    }

    // Getter for bankName
    public String getBankName() {
        return bankName;
    }

    // Create New Account
    public Account createAccount(String name, String address, String phoneNumber, double initialDeposit) {
        Customer customer = new Customer(name, address, phoneNumber);
        Account account = new Account(customer, initialDeposit);
        accounts.add(account);
        System.out.println("Account created successfully. Account Number: " + account.getAccountNumber());
        return account;
    }

    // Find Account by Account Number
    public Account findAccount(int accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber() == accountNumber) {
                return acc;
            }
        }
        System.out.println("Account not found.");
        return null;
    }

    // Display All Accounts
    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts to display.");
            return;
        }
        for (Account acc : accounts) {
            acc.displayAccountInfo();
            System.out.println("---------------------------");
        }
    }
}
