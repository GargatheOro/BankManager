package Bank;

import java.security.Principal;
import java.util.Scanner;

public class Account {
    protected static double balance;
    protected static int accountNumber;
    Person accountOwner;
    static Scanner receiver = new Scanner(System.in);

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
            double amount = receiver.nextDouble();
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
            double proposal = overdraftRule(maxWithdraw(receiver.nextDouble()), account);
            account.balance = account.balance - proposal;
            System.out.println("You have successfully withdrawn $" + proposal + " from account #" + account.accountNumber + ".");
            System.out.println("Your new balance is $" + account.balance + ". Thank you.");
        }
    }

    public static double maxWithdraw (double input) {
        if (input > 1000) {
            System.out.println("The maximum daily withdraw amount is $1000. We are modifying your withdrawal to $1000.");
            return 1000;
        } else {
            System.out.println("Your withdrawal proposal clears the max withdrawal requirement.");
            return input;
        }
    }

    public static double overdraftRule (double input2, Account account) {
        if(input2 > account.balance) {
            System.out.println("Overdrafting is disabled for your account. We are modifying your withdrawal to $" + account.balance);
            return account.balance;
        } else {
            System.out.println("Your withdrawal proposal passes the overdraft rule.");
            return input2;
        }
    }
}
