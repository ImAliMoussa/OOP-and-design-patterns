/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Collections;

/**
 *
 * @author FAST
 */
public class TestingNewCodeClass {
    public static void main(String[] args) {
        MyFilesManagement manage = new MyFilesManagement();
        manage.readFiles();
        for (Employee employee : Manager.getListOfEmployees()) {
            System.out.println(employee);
        }
        System.out.println("AFTER\n\n\n");
        Manager.getListOfEmployees().sort(Employee::compare);
        for (Employee employee : Manager.getListOfEmployees()) {
            System.out.println(employee);
        }
        
        for (Trip trip : Manager.getListOfTrips()) {
            System.out.println(trip);
        }
        System.out.println("AFTER\n\n\n");
        Manager.getListOfTrips().sort(Trip::compare);
        for (Trip trip : Manager.getListOfTrips()) {
            System.out.println(trip);
        }
        System.out.println("VEHICLES: \n\n\n");
        for (Vehicle vehicle : Manager.getListOfVehicles()) {
            System.out.println(vehicle);
        }
        System.out.println("AFTER\n\n\n");
        Manager.getListOfVehicles().sort(Vehicle::compare);
        for (Vehicle vehicle : Manager.getListOfVehicles()) {
            System.out.println(vehicle);
        }
        
    }
    
    void sortTrips()
    {
        Manager.getListOfTrips().sort(Trip::compare);
        //THEN refresh table of trips
    }
    
    void sortVehicles()
    {
        Manager.getListOfVehicles().sort(Vehicle::compare);
        //refresh table of vehicles
    }
    
    void sortEmployees()
    {
        Manager.getListOfEmployees().sort(Employee::compare);
        //refresh table of employees
    }
}
