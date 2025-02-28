import java.util.Scanner;

public class ATM {
    // Initial account balance
    static double balance = 1000.00;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pin = 1234; // Default PIN
        int enteredPin;

        // Welcome message
        System.out.println("Welcome to the ATM");

        // PIN authentication loop
        System.out.print("Enter your PIN: ");
        enteredPin = scanner.nextInt();

        if (enteredPin != pin) {
            System.out.println("Incorrect PIN. Access Denied.");
            return;
        }

        // ATM operation menu
        boolean exit = false;
        while (!exit) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney(scanner);
                    break;
                case 3:
                    withdrawMoney(scanner);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to check the balance
    public static void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }

    // Method to deposit money
    public static void depositMoney(Scanner scanner) {
        System.out.print("Enter the amount to deposit: $");
        double depositAmount = scanner.nextDouble();
        if (depositAmount > 0) {
            balance += depositAmount;
            System.out.println("You have successfully deposited $" + depositAmount);
        } else {
            System.out.println("Invalid amount. Deposit failed.");
        }
    }

    // Method to withdraw money
    public static void withdrawMoney(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: $");
        double withdrawAmount = scanner.nextDouble();
        if (withdrawAmount > 0 && withdrawAmount <= balance) {
            balance -= withdrawAmount;
            System.out.println("You have successfully withdrawn $" + withdrawAmount);
        } else if (withdrawAmount > balance) {
            System.out.println("Insufficient funds. Withdrawal failed.");
        } else {
            System.out.println("Invalid amount. Withdrawal failed.");
        }
    }
}
