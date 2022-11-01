package Main;

import Bank.Account;

import java.util.Scanner;

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
        switch (command) {
            case "/bal" -> {
                double bal = Account.checkBalance();
                System.out.println("Your balance is: $" + bal);
                System.out.println("Returning you to the main menu now.");
                mainMenu();
            }
            case "/dep" -> {
                Account.depositFunds();
                System.out.println("Returning you to the main menu now.");
                mainMenu();
            }
            case "/with" -> {
                Account.withdrawFunds();
                System.out.println("Returning you to the main menu now.");
                mainMenu();
            }
            case "/open" -> {
                Bank.Bank.openAccount();
                System.out.println("Returning you to the main menu now.");
                mainMenu();
            }
            default -> {
                System.out.println("Thank you for using Oro Bank services.");
                System.exit(0);
            }
        }
    }
}