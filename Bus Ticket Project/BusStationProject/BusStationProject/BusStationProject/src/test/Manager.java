package test;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by FAST on 15-Mar-18.
 */
public class Manager extends Employee{

    private static ArrayList<Trip> listOfTrips = new ArrayList<Trip>();
    private static ArrayList<Employee> listOfEmployees= new ArrayList<Employee>();
    private static ArrayList<Vehicle> listOfVehicles = new ArrayList<Vehicle>();

    //temporary constructor
    public Manager(String firstName, String lastName, String address, String phoneNumber, int salary) {
        super(firstName, lastName, address, phoneNumber, salary);
    }

    public Manager() {
    }


    public static ArrayList<Trip> getListOfTrips() {
        return listOfTrips;
    }

    public static void setListOfTrips(ArrayList<Trip> listOfTrips) {
        Manager.listOfTrips = listOfTrips;
    }

    public static ArrayList<Employee> getListOfEmployees() {
        return listOfEmployees;
    }

    public static void setListOfEmployees(ArrayList<Employee> listOfEmployees) {
        Manager.listOfEmployees = listOfEmployees;
    }

    public static ArrayList<Vehicle> getListOfVehicles() {
        return listOfVehicles;
    }

    public static void setListOfVehicles(ArrayList<Vehicle> listOfVehicles) {
        Manager.listOfVehicles = listOfVehicles;
    }
     public int findTrip(Customer customer)
    {
        for( int i = 0 ; i < Manager.getListOfTrips().size() ; i++)
        {
            String customerTripCodeName = customer.getCodeName();
            String tripCodeName = Manager.getListOfTrips().get(i).getCodeName();
            if( customerTripCodeName.equals(tripCodeName) )
            {
                return i;
            }
        }
        return -1;
    }

    public static int findTrip(String codeName)
    {
        for( int i = 0 ; i < Manager.getListOfTrips().size() ; i++)
        {
            String tripCodeName = Manager.getListOfTrips().get(i).getCodeName();
            if( codeName.equals(tripCodeName) )
            {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return super.toString() + ",manager";
    }
    
}
