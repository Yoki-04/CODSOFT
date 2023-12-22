import java.util.Scanner;


class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds. Withdrawal failed.");
            return false;
        }
        balance -= amount;
        return true;
    }
}


class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount userAccount) {
        this.userAccount = userAccount;
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void processOption(int option) {
        switch (option) {
            case 1:
                checkBalance();
                break;
            case 2:
                deposit();
                break;
            case 3:
                withdraw();
                break;
            case 4:
                System.out.println("Exiting ATM. Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private void checkBalance() {
        double balance = userAccount.getBalance();
        System.out.println("Your account balance: $" + balance);
    }

    private void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter deposit amount: $");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        } else {
            userAccount.deposit(amount);
            System.out.println("Deposit successful. New balance: $" + userAccount.getBalance());
        }
    }

    private void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter withdrawal amount: $");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount. Please enter a positive value.");
        } else {
            boolean success = userAccount.withdraw(amount);
            if (success) {
                System.out.println("Withdrawal successful. New balance: $" + userAccount.getBalance());
            }
        }
    }
}

public class CheckBalance{
    public static void main(String[] args) {
        
        BankAccount userAccount = new BankAccount(1000.0);

        
        ATM atm = new ATM(userAccount);

        
        while (true) {
            atm.displayMenu();

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your choice (1-4): ");
            int option = scanner.nextInt();

            atm.processOption(option);
        }
    }
}
