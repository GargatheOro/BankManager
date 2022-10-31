package Bank;

import java.util.Scanner;

public class Account {
    long balance;
    int accountNumber;
    Person accountOwner;
    static Scanner receiver = new Scanner(System.in);

    public Account(int balance, int accountNumber, Person accountOwner) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.accountOwner = accountOwner;
    }

    public static void checkBalance() {

        String input = receiver.nextLine();
        //if(input)
    }

    public static void depositFunds() {
        String input = receiver.nextLine();
    }

    public static void withdrawFunds() {
        String input = receiver.nextLine();
    }
}
