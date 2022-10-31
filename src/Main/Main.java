package Main;

import Bank.Account;
import Bank.Person;

import java.util.*;

import static Bank.Bank.registry;

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
        if (scanner.nextLine().equals("/bal")) {
            Account.checkBalance();
        } else if (scanner.nextLine().equals("/dep")) {
            Account.depositFunds();
        } else if (scanner.nextLine().equals("/with")) {
            Account.withdrawFunds();
        } else if (scanner.nextLine().equals("/open")) {
            Bank.Bank.openAccount();
        } else {
            return;
        }
    }
}