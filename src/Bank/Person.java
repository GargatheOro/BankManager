package Bank;

import java.util.Scanner;

public class Person {

    static String firstName;
    static String middleName;
    static String lastName;
    static int age;
    protected static int SSN;

    public Person(String firstName, String middleName, String lastName, int age, int SSN) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.SSN = SSN;
    }

    public static void getFullName() {
        System.out.println(firstName + middleName + lastName);
    }
}
