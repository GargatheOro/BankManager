package Bank;

public class Person {

    protected String firstName;
    protected String middleName;
    protected String lastName;
    int age;
    protected int SSN;

    public Person(String firstName, String middleName, String lastName, int age, int SSN) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.SSN = SSN;
    }
}
