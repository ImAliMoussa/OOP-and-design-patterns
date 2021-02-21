package test;

/**
 * Created by FAST on 22-Mar-18.
 */
public class Driver extends Employee{

    private String id;
    
    public Driver(String firstName, String lastName, String address, String phoneNumber, int salary , String id) {
        super(firstName, lastName, address, phoneNumber, salary);
        this.id = id;
    }
    
    @Override
    public String toString() {
        
        return super.toString() + "," + id + ",driver";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
}