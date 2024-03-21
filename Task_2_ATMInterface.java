import java.util.Scanner;

// BankAccount class to represent the user's bank account
class BankAccount {
    private double balance;

    // Constructor
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to withdraw funds from the account
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: " + balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    // Method to deposit funds into the account
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }
        balance += amount;
        System.out.println("Deposit successful. Current balance: " + balance);
    }

    // Method to check the account balance
    public double checkBalance() {
        return balance;
    }
}

// ATM class to represent the ATM machine
public class Task_2_ATMInterface {
    private BankAccount userAccount;

    // Constructor
    public Task_2_ATMInterface(BankAccount userAccount) {
        this.userAccount = userAccount;
    }

    // Method to withdraw funds
    public void withdraw(double amount) {
        userAccount.withdraw(amount);
    }

    // Method to deposit funds
    public void deposit(double amount) {
        userAccount.deposit(amount);
    }

    // Method to check account balance
    public void checkBalance() {
        double balance = userAccount.checkBalance();
        System.out.println("Your account balance is: " + balance);
    }

    // Main method to interact with the ATM
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000.0);
        Task_2_ATMInterface atm = new Task_2_ATMInterface(bankAccount);
        Scanner scanner = new Scanner(System.in);

        int choice;
        double amount;

        do {
            System.out.println("ATM Menu");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the amount to withdraw: ");
                    amount = scanner.nextDouble();
                    atm.withdraw(amount);
                    break;
                case 2:
                    System.out.println("Enter the amount to deposit: ");
                    amount = scanner.nextDouble();
                    atm.deposit(amount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
