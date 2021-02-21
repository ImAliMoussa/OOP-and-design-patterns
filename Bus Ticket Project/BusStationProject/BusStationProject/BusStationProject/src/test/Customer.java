package test;

import java.util.Scanner;

/**
 * Created by FAST on 13-Mar-18.
 */

public class Customer implements Icustomer{

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private int age;
    private int numOfSeats;
    private Ticket ticket;
    private Trip trip;
    private String codeName;
    private boolean roundTrip;

    public boolean isRoundTrip() {
        return roundTrip;
    }

    public void setRoundTrip(boolean roundTrip) {
        this.roundTrip = roundTrip;
    }

    public Customer() {
    }

    
    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }

    public void setNumOfSeats(int numOfSeats) {
        this.numOfSeats = numOfSeats;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Customer(String firstName , String lastName , String phoneNumber , int age , int numOfSeats , String codeName) {
        this.firstName = firstName;
        this.lastName= lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.numOfSeats = numOfSeats;
        this.codeName = codeName;
        /*int tripIndex = MyFilesManagement.findTrip(codeName);
        if( tripIndex == -1 )
        {
            System.out.println("ERROR; Trip code name not found in records. Reenter vehicle code name.");
        }
        else
            Manager.getListOfTrips().get(tripIndex).getCustomerList().add(this);*/
    }

    public boolean bookTicket(Trip trip)
    {
        
        this.trip = trip;
        
        boolean x =  trip.getVehicle().increaseSeatsTaken( numOfSeats );
        if( x ){
           trip.customerList.add(this);
           return true;
        }
        else{
            return false;
           
        }
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }//if object is uninitialized
        if (!Customer.class.isAssignableFrom(obj.getClass())) {
            return false;
        }//if not of class Customer
        final Customer otherCustomer = (Customer) obj;
        return this.firstName.equals(otherCustomer.firstName)
                && this.lastName.equals(otherCustomer.lastName)
                && this.age == otherCustomer.age
                && this.phoneNumber.equals(otherCustomer.phoneNumber)
                && this.numOfSeats == otherCustomer.numOfSeats
                && this.trip.equals(otherCustomer.trip);// note to self : implement equals() function bta3t Trip
    }


    @Override
    public String toString() {
        return firstName + "," + lastName + "," + phoneNumber + "," + age +  "," + numOfSeats + "," + codeName  + "," + roundTrip  ;
    }
}
