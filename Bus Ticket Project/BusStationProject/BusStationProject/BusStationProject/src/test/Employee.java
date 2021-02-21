package test;

public class Employee {

    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private int salary;



    public Employee() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Employee(String firstName, String lastName, String address, String phoneNumber, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return firstName + "," + lastName + "," + address + "," + phoneNumber + "," + salary ;
    }
    
    public static int compare(Employee e1, Employee e2)
    {
        return e1.getFirstName().compareTo(e2.getFirstName());
    }
}
