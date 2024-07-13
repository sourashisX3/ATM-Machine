package ATM;
import java.util.ArrayList;
import java.util.Scanner;

// Class representing the ATM Machine

public class ATM {
    private String accountNumber;
    private int pin;
    private double balance;
    private ArrayList<String> transactionHistory;

    // Constructor
    public ATM(String accountNumber, int pin, double balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }

    // Method to display menu and handle user input
    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean sessionActive = true;

        while (sessionActive) {
            displayMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    withdraw(scanner);
                    break;
                case 3:
                    deposit(scanner);
                    break;
                case 4:
                    changePin(scanner);
                    break;
                case 5:
                    showTransactionHistory();
                    break;
                case 6:
                    sessionActive = false;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 6.");
            }
        }
        scanner.close();
    }

    // Display menu options
    private void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw Cash");
        System.out.println("3. Deposit Cash");
        System.out.println("4. Change PIN");
        System.out.println("5. View Transaction History");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    // Method to check account balance
    private void checkBalance() {
        System.out.println("\nAccount Balance: $" + balance);
        transactionHistory.add("Checked balance: $" + balance);
    }

    // Method to withdraw cash
    private void withdraw(Scanner scanner) {
        System.out.print("Enter amount to withdraw: $");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: $" + balance);
            transactionHistory.add("Withdrawal: $" + amount);
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }

    // Method to deposit cash
    private void deposit(Scanner scanner) {
        System.out.print("Enter amount to deposit: $");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
            transactionHistory.add("Deposit: $" + amount);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    // Method to change PIN
    private void changePin(Scanner scanner) {
        System.out.print("Enter current PIN: ");
        int currentPin = scanner.nextInt();
        if (currentPin == pin) {
            System.out.print("Enter new PIN: ");
            int newPin = scanner.nextInt();
            pin = newPin;
            System.out.println("PIN changed successfully.");
            transactionHistory.add("PIN changed");
        } else {
            System.out.println("Incorrect PIN. PIN change failed.");
        }
    }

    // Method to display transaction history
    private void showTransactionHistory() {
        System.out.println("\nTransaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    // Main method to start the ATM simulation
    public static void main(String[] args) {
        // Example usage
        ATM atm = new ATM("1234567890", 1234, 1000.0);
        atm.run();
    }
}
