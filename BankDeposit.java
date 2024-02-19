/* 
BankDeposit
1> openAccount : Account number, Holder name, Amount of deposit, Account type (Savings/Current)
2> Show Account : Show the detail of account holder
3> Deposit : We are merge this function with open account function
4> Withdraw: Credit and Deposit amount
*/

import java.util.*;

class BankManagement {
    String accountNumber, holderName, accountType;
    int amount = 0;

    public void openAccount(String accNo, String holderName, int amount, char accType) {
        this.accountNumber = accNo;
        this.holderName = holderName;
        this.amount = amount;

        if (accType == 's') {
            accountType = "Savings";
        } else if (accType == 'c') {
            accountType = "Current";
        } else {
            System.out.println("Invalid choice");
        }
    }

    public void show() {
        System.out.println("Account number: " + accountNumber);
        System.out.println("Account holder: " + holderName);
        System.out.println("Current amount: " + amount);
        System.out.println("Account type: " + accountType);
    }

    public void deposit(int amount) {
        show();
        this.amount += amount;
        System.out.println("Amount added to your account successfully!");
        System.out.println("Current Amount: " + this.amount);
    }

    public void withdrawal(int amount) {
        show();
        if (this.amount < 0) {
            System.out.println("You don't have enough balance in the account.");
        } else {
            this.amount -= amount;
            System.out.println(amount + " is withdrawn from your account.");
        }
    }
}

public class BankDeposit {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        String accountNumber, holderName;
        char accountType;
        int amount = 0;
        BankManagement bank = new BankManagement();

        System.out.print("Enter Account Number: ");
        accountNumber = input.next();

        System.out.print("Enter Holder Name: ");
        holderName = input.next();

        System.out.print("Enter amount of deposit: ");
        amount = input.nextInt();

        System.out.print("Enter Account Types [Savings]/c[current]: ");
        accountType = input.next().charAt(0);

        bank.openAccount(accountNumber, holderName, amount, accountType);
        System.out.println("Account opened successfully!");

        char choice;
        System.out.print("Do you want to withdrawal or deposit? y[yes] or n[no]: ");
        choice = input.next().charAt(0);

        if (choice == 'y') {
            System.out.print("w[withdrawal] or d[deposit]: ");
            char decision = input.next().charAt(0);

            System.out.print("Enter amount: ");
            int amt = input.nextInt();

            if (decision == 'w') {
                bank.withdrawal(amt);
            } else if (decision == 'd') {
                bank.deposit(amt);
            } else {
                System.out.println("Invalid option!!!");
            }
        } else if (choice == 'n') {
            System.out.println("Thank you for trusting us :)");
        } else {
            System.out.println("Invalid option!!!");
        }
    }
}