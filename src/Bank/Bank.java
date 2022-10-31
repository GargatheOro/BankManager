package Bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Bank {

    protected static List<Person> registry = new ArrayList<>();
    protected static List<Account> bank = new ArrayList<>();

    //Registers a new person and a corresponding account
    public static void openAccount() {
        Scanner opener = new Scanner(System.in);
        System.out.println("Thank you for choosing to open an account with Oro Bank! We need some information from you.");
        System.out.println("Please provide your first name:");
        String firstName = opener.nextLine();
        System.out.println("Please provide your first middle name:");
        String middleName = opener.nextLine();
        System.out.println("Please provide your last name:");
        String lastName = opener.nextLine();
        System.out.println("Please provide your age:");
        int age = opener.nextInt();
        System.out.println("Please provide your Social Security number:");
        int SSN = opener.nextInt();
        System.out.println("The minimum initial deposit is $10. Please state your initial deposit:");
        double initialDeposit = opener.nextDouble();
        if(initialDeposit < 10) {
            System.out.println("The initial deposit is $10. Please try again.");
            openAccount();
        }
        int newAccountNumber = generateAccountNumber();
        System.out.println("Account number generated successfully: " + newAccountNumber);
        registry.add(new Person(firstName, middleName, lastName, age, SSN));
        bank.add(new Account(initialDeposit, newAccountNumber, pullPerson(SSN)));
        System.out.println("Account opened successfully! Your account number is " + newAccountNumber + ". Thank you!");
    }

    //Retrieves the information of a person based on SSN
    public static Person getPerson() {
        Scanner scannerper = new Scanner(System.in);
        System.out.println("Please provide your 9-digit Social Security number:");
        int entry = scannerper.nextInt();
        for(Person person : registry) {
            if(entry == person.SSN) {
                System.out.println("User pulled successfully: " + person.SSN);
                System.out.println("Hello " + person.firstName + " " + person.lastName);
                return person;
            }
        }
        return null;
    }

    //Retrieves the information of an account for the purposes of opening new accounts (array input)
    public static Person pullPerson(int ssn) {
        for(Person person : registry) {
            if(ssn == person.SSN) {
                return person;
            }
        }
        return null;
    }

    //Retrieves the information of an account based on account number
    public static Account getAccount() {
        Scanner scanneracc = new Scanner(System.in);
        System.out.println("Please provide your 5-digit account number:");
        int entry = scanneracc.nextInt();
        for(Account account : bank) {
            if(entry == account.accountNumber) {
                System.out.println("Account pulled successfully: " + account.accountNumber);
                System.out.println("Account owner: " + account.accountOwner.firstName);
                return account;
            }
        }
        return null;
    }

    //Ensures account matches user
    public static boolean verifyAccount(Account account, Person person) {
        if(person == account.accountOwner) {
            System.out.println("Your account has been successfully verified as " + person.firstName + " " + person.lastName + "'s account owned by " + account.accountOwner.firstName);
            return true;
        } else {
            System.out.println("Your account could not be verified.");
            return false;
        }
    }

    //Registers the test users and their accounts
    public static void registerDefaults() {
        registry.add(new Person("Andrew", "Walter", "Hart", 36, 573041748));
        registry.add(new Person("Leah", "Madison", "Smith", 28, 591673815));
        registry.add(new Person("Chloe", "Lynn", "White", 25, 678180561));
        bank.add(new Account(500, 57369, registry.get(0)));
        bank.add(new Account(150, 20682, registry.get(1)));
        bank.add(new Account(50000, 74856, registry.get(2)));
    }

    //Generates a unique 5-digit account number
    public static int generateAccountNumber() {
        int random = ThreadLocalRandom.current().nextInt(10000, 99999);
        for (int i = 0; i < 2; i++) {
            if (bank.indexOf(random) != random) {
                break;
            } else i--;
        }
        return random;
    }
}
