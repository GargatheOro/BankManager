package Bank;

import java.security.Principal;
import java.util.Scanner;

public class Account {
    protected static double balance;
    protected static int accountNumber;
    Person accountOwner;
    static Scanner receiver = new Scanner(System.in);
    static double amount;

    public Account(double balance, int accountNumber, Person accountOwner) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.accountOwner = accountOwner;
    }

    public static double checkBalance() {
        Account account = Bank.getAccount();
        Person person = Bank.getPerson();
        if(account !=null && person !=null) {
            if(Bank.verifyAccount(account, person)) {
                return account.balance;
            } else {
                System.out.println("Your balance could not be retrieved due to an account information mismatch.");
            }
        } else {
            System.out.println("Your balance could not be retrieved due to an unexpected error.");
        }
        return 0.00001;
    }

    public static void depositFunds() {
        Account account = Bank.getAccount();
        Person person = Bank.getPerson();
        if(Bank.verifyAccount(account, person)) {
            System.out.println("Please state the amount of money you wish to deposit (Ex: 16.25).");
            amount = receiver.nextDouble();
            account.balance = account.balance + amount;
            System.out.println("You have successfully deposited $" + amount + " to account #" + account.accountNumber + ".");
            System.out.println("Your new balance is $" + account.balance + ". Thank you.");
        }
    }

    public static void withdrawFunds() {
        Account account = Bank.getAccount();
        Person person = Bank.getPerson();
        if(Bank.verifyAccount(account, person)) {
            System.out.println("Please state the amount of money you wish to withdraw (Ex: 17.62), to a maximum of $1000.");
            amount = receiver.nextDouble();
            if (amount > 1000) {
                System.out.println("The maximum daily withdraw amount is $1000. We are modifying your withdrawal.");
                amount = 1000;
            }
            double proposal = account.balance - amount;
            if(proposal > account.balance) {
                System.out.println("Overdrafting is disabled at Oro Bank. We are modifying your withdrawal.");
                proposal = account.balance;
            }
            account.balance = proposal;
            System.out.println("You have successfully withdrawn $" + amount + " from account #" + account.accountNumber + ".");
            System.out.println("Your new balance is $" + account.balance + ". Thank you.");
        }
    }
}
