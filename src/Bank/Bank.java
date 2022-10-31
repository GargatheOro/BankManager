package Bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {

    public static List<Person> registry = new ArrayList<>();
    public static List<Account> bank = new ArrayList<>();
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
        registry.add(new Person(firstName, middleName, lastName, age, SSN));
        System.out.println("Please state your initial deposit:");
        int initialDeposit = opener.nextInt();
        System.out.println("Please verify your Social Security number:");
        bank.add(new Account(initialDeposit, SSN, getPerson()));
        System.out.println("Account opened successfully! Your account number is your SSN. Thank you!");
        Main.Main.mainMenu();
    }

    //Retrieves the information of an account based on last name
    private static Person getPerson() {
        Scanner scanner = new Scanner(System.in);
        int entry = scanner.nextInt();
        return registry.get(registry.indexOf(entry));
    }

    //Retrieves the information of an account based on SSN
    private static Account getAccount() {
        Scanner scanner = new Scanner(System.in);
        int entry = scanner.nextInt();
        return bank.get(bank.indexOf(entry));
    }

    //Ensures account matches user
    public static boolean accountVerifier() {
        Person person = getPerson();
        Account account = getAccount();
        if(person.SSN == account.accountNumber) {
            return true;
        } else {
            return false;
        }
    }

    public static void registerDefaults() {
        registry.add(new Person("Andrew", "Walter", "Hart", 36, 573041748));
    }
}
