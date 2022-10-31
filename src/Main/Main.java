package Main;

import Bank.Account;

import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Bank.Bank.registerDefaults();
        mainMenu();
    }

    public static void mainMenu() {
        System.out.println("Welcome to Oro Bank! Read the options carefully!");
        System.out.println("To check your balance, type '/bal'.");
        System.out.println("To make a deposit, type '/dep'.");
        System.out.println("To make a withdrawal, type '/with'.");
        System.out.println("To open a new account, type '/open'.");
        System.out.println("To exit this program, type anything else.");
        String command = scanner.nextLine();
        if (command.equals("/bal")) {
            double bal = Account.checkBalance();
            System.out.println("Your balance is: $" + bal);
            System.out.println("Returning you to the main menu now.");
            mainMenu();
        } else if (command.equals("/dep")) {
            Account.depositFunds();
            System.out.println("Returning you to the main menu now.");
        } else if (command.equals("/with")) {
            Account.withdrawFunds();
            System.out.println("Returning you to the main menu now.");
        } else if (command.equals("/open")) {
            Bank.Bank.openAccount();
            System.out.println("Returning you to the main menu now.");
        } else {
            System.out.println("Thank you for using Oro Bank services.");
            System.exit(0);
        }
    }
}