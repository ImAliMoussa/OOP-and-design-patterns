package test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Trip implements Discount {

    private String destination;
    private String locationFrom;
    private int duration;
    private int numberOfStops;
    private Vehicle vehicle;
    private String vehicleCodeName;
    private String codeName;
    private boolean tripIsRound;
    private int price;
    private String date;
    private Driver driver;
    private String driverId;
    ArrayList<Customer> customerList ;
    //Implement Date
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
 
    public boolean isTripIsRound() {
        return tripIsRound;
    }

    public void setTripIsRound(boolean tripIsRound) {
        this.tripIsRound = tripIsRound;
    }
    public String getVehicleCodeName() {
        return vehicleCodeName;
    }

    public void setVehicleCodeName(String vehicleCodeName) {
        this.vehicleCodeName = vehicleCodeName;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }

    public Trip(String locationFrom, String destination ,  int duration, int numberOfStops , String codeName , String vehicleCodeName,String date) {
        this.destination = destination;
        this.locationFrom = locationFrom;
        this.duration = duration;
        this.numberOfStops = numberOfStops;
        //this.vehicle = vehicle;
        this.codeName = codeName;
        this.date = date;
        this.vehicleCodeName = vehicleCodeName;
        customerList = new ArrayList<Customer>();
        int vehicleIndex = MyFilesManagement.findVehicleForTrip(this);
        if( vehicleIndex == -1 )
        {
            System.out.println("ERROR; Vehicle code name not found in records. Reenter vehicle code name.");
        }
        else
            this.vehicle = Manager.getListOfVehicles().get(vehicleIndex);
    }

    //MAKE A SET VEHICLE FUNCTION

    public void addCustomer(Customer customer)
    {
        customerList.add(customer);
    }

    public boolean removeCustomer(Customer customer)
    {
        //return false if not found
        boolean found = false;
        for(int i = 0 ;  i < customerList.size() ; i++)
        {
            if( customerList.get(i).equals(customer) )
            {
                customerList.remove(i);
                this.vehicle.increaseSeatsTaken(-customer.getNumOfSeats());
                found = true;
            }
        }
        return found;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }



    public String getLocationFrom() {
        return locationFrom;
    }

    public void setLocationFrom(String locationFrom) {
        this.locationFrom = locationFrom;
    }

    /*public void newTrip()
    {
        System.out.println("");
        Vehicle vehicle = new Vehicle(10);
        vehicle.incrementNumberOfSeats();
        Customer customer = new Customer();
        Ticket ticket = new SingleTicket();
    }*/

    public Trip() {
    }

    
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getlocationFrom() {
        return locationFrom;
    }

    public void setlocationFrom(String locationFrom) {
        this.locationFrom = locationFrom;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getNumberOfStops() {
        return numberOfStops;
    }

    public void setNumberOfStops(int numberOfStops) {
        this.numberOfStops = numberOfStops;
    }
    

    public double calculateRoundTripPrice(boolean isRound) {
        if( isRound )
            return 2 * 0.85;
        
        return 1;
    }


    public int calculateStopsDiscount() {
        return (int)(numberOfStops * 0.05 * this.price); // returns a 5% discount for each stop that needs to be made
    }
    
    @Override
    public String toString() {
        return destination
                + "," + locationFrom
                + "," + duration
                + "," + numberOfStops
                + "," + codeName
                + "," + vehicleCodeName
                + "," + date
                + "," + price
                + "," + driverId;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }
    
    public static int compare(Trip trip1, Trip trip2)
    {
        return trip1.getCodeName().compareTo(trip2.getCodeName());
    }
}
