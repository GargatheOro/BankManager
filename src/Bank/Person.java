package Bank;

public class Person {

    protected static String firstName;
    protected static String middleName;
    protected static String lastName;
    static int age;
    protected static int SSN;

    public Person(String firstName, String middleName, String lastName, int age, int SSN) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.SSN = SSN;
    }
}
