package Bank;

import java.util.Scanner;

public class Account {
    private double balance;
    protected static int accountNumber;
    Person accountOwner;
    static Scanner receiver = new Scanner(System.in);
    static long amount;

    public Account(int balance, int accountNumber, Person accountOwner) {
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
            }
        } else {
            System.out.println("Your balance could not be retrieved.");
        }
        return 0.00001;
    }

    public static void depositFunds() {
        Account account = Bank.getAccount();
        Person person = Bank.getPerson();
        if(Bank.verifyAccount(account, person)) {
            System.out.println("Please state the amount of money you wish to deposit (Ex: 16.25).");
            amount = receiver.nextLong();
            account.balance = account.balance + amount;
            System.out.println("You have successfully deposited $" + amount + "to account #" + account.accountNumber + ".");
            System.out.println("Your new balance is $" + account.balance + ". Thank you.");
        }
    }

    public static void withdrawFunds() {
        Account account = Bank.getAccount();
        Person person = Bank.getPerson();
        if(Bank.verifyAccount(account, person)) {
            System.out.println("Please state the amount of money you wish to withdraw (Ex: 17.62).");
            amount = receiver.nextLong();
            account.balance = account.balance - amount;
            System.out.println("You have successfully withdrawn $" + amount + "from account #" + account.accountNumber + ".");
            System.out.println("Your new balance is $" + account.balance + ". Thank you.");
        }
    }
}
