
/* BankDeposit
 * 1> openAccount : Account number, Holder name, Amount of deposit, Account  type (Savings/Current)
 * 2> Show Account : Show the detail of account holder
 * 3> Deposit : We are merge this function with open account function
 * 4> Withdraw: Credit and Deposit amount
 */
import java.util.*;

class BankManagement {
    String accountNumber, hldrNm, accountType;
    int amount = 0;

    public void openAccount(String accNo, String hldrNm, int amount, char accType) {
        this.accountNumber = accNo;
        this.hldrNm = hldrNm;
        this.amount = amount;
        if (accType == 's') {
            accountType = "Saving";
        } else if (accType == 'c') {
            accountType = "Current";
        } else {
            System.out.println("Invalid choice");
        }
    }

    public void show() {
        System.out.println("Account number: " + accountNumber);
        System.out.println("Account holder: " + hldrNm.toUpperCase());
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
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String accountNumber, hldrNm;
        char accType;
        int amount = 0;

        BankManagement bnk = new BankManagement();

        System.out.print("Enter Account Number: ");
        accountNumber = inp.next();

        System.out.println("Enter Holder Name: ");
        hldrNm = inp.next();

        System.out.println("Enter amount of deposit: ");
        amount = inp.nextInt();

        System.out.print("Enter Account Types[Savings]/c[current]: ");
        accType = inp.next().charAt(0);

        bnk.openAccount(accountNumber, hldrNm, amount, accType);
        System.out.println("Account opened successfully!");

        char choice;
        System.out.println("Do you want to withdrawal or deposit? y[yes] or n[no]:");
        choice = inp.next().charAt(0);

        if (choice == 'y') {
            System.out.println("w[withdrawal] or d[deposit]: ");
            char decision = inp.next().charAt(0);

            System.out.println("Enter amount: ");

            int amt = inp.nextInt();

            if (decision == 'w') {
                bnk.withdrawal(amt);
            } else if (decision == 'd') {
                bnk.deposit(amt);
            } else {
                System.out.println("Invalid option!!!");
            }

        } 
        else if (choice == 'n') {
            System.out.println("Thank you for your trusting :)");
        } 
        else {
            System.out.println("Invalid option!!!");
        }
    }
}
