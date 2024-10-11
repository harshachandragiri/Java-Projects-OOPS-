// Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("MyBank");
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Welcome to " + bank.getBankName() + " Banking System");

        while (!exit) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Create New Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Display Account Details");
            System.out.println("6. Display All Accounts");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 7.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Customer Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();

                    System.out.print("Enter Phone Number: ");
                    String phone = scanner.nextLine();

                    System.out.print("Enter Initial Deposit: ");
                    double deposit = 0;
                    try {
                        deposit = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid amount. Account creation failed.");
                        break;
                    }

                    bank.createAccount(name, address, phone, deposit);
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    int accNumDeposit = Integer.parseInt(scanner.nextLine());
                    Account accDeposit = bank.findAccount(accNumDeposit);
                    if (accDeposit != null) {
                        System.out.print("Enter Deposit Amount: ");
                        double depAmount = Double.parseDouble(scanner.nextLine());
                        accDeposit.deposit(depAmount);
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    int accNumWithdraw = Integer.parseInt(scanner.nextLine());
                    Account accWithdraw = bank.findAccount(accNumWithdraw);
                    if (accWithdraw != null) {
                        System.out.print("Enter Withdrawal Amount: ");
                        double withdrawAmount = Double.parseDouble(scanner.nextLine());
                        accWithdraw.withdraw(withdrawAmount);
                    }
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    int accNumBalance = Integer.parseInt(scanner.nextLine());
                    Account accBalance = bank.findAccount(accNumBalance);
                    if (accBalance != null) {
                        System.out.println("Current Balance: $" + accBalance.getBalance());
                    }
                    break;

                case 5:
                    System.out.print("Enter Account Number: ");
                    int accNumDisplay = Integer.parseInt(scanner.nextLine());
                    Account accDisplay = bank.findAccount(accNumDisplay);
                    if (accDisplay != null) {
                        accDisplay.displayAccountInfo();
                    }
                    break;

                case 6:
                    bank.displayAllAccounts();
                    break;

                case 7:
                    exit = true;
                    System.out.println("Thank you for using " + bank.getBankName() + " Banking System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please select between 1 and 7.");
            }
        }

        scanner.close();
    }
}
