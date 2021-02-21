package test;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class MyFilesManagement {

    public void readFiles() //At start of program
    {
        //this order matters!
        readVehiclesFromFile();
        readTripsFromFile();
        readCustomersFromFile();
        readEmployeesFromFile();
    }

    public void printToFiles() //Gasser use this function lama ta3ml save
    {
        printEmployeesToFile();
        printCustomersToFile();
        printTripsToFile();
        printVehiclesToFile();
    }

    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%//

    
    
    
    private void addDriverToTrips(Driver driver)
    {
        for (int i = 0; i < Manager.getListOfTrips().size() ; i++) {
            Trip trip = Manager.getListOfTrips().get(i);
            if( (trip.getDriverId()).equals(driver.getId()) )
            {
                trip.setDriver(driver);
            }
        }
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

    public static int findVehicleForTrip(Trip trip)
    {
        for( int i = 0 ; i < Manager.getListOfVehicles().size() ; i++)
        {
            String vehicleCodeName = Manager.getListOfVehicles().get(i).getCodeName();
            if( vehicleCodeName.equals(trip.getVehicleCodeName()) )
            {
                return i;
            }
        }
        return -1;
    }

    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%//

    private PrintWriter createPrintWriter(String fileName) {
        File listOfNames = new File(fileName);
        PrintWriter infoToWrite = null;
        try {
            infoToWrite = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter(listOfNames) ));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return infoToWrite;
    }

    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%//

    private Customer returnCustomerFromFile(String lineFromFile)
    {
        String[] array = lineFromFile.split(",");
        Customer customer = new Customer(array[0] , array[1] , array[2] , Integer.parseInt(array[3]) , Integer.parseInt(array[4]) , array[5]);
        customer.setRoundTrip(Boolean.parseBoolean(array[6]));
        return customer;
    }

private Employee returnEmployeeFromFile(String lineFromFile)
    {
        String[] array = lineFromFile.split(",");
        Employee employee = employeeFactory(array);
        return employee;
    }



    private Trip returnTripFromFile(String lineFromFile)
    {
        String[] array = lineFromFile.split(",");
        Trip trip = tripFactory(array);
        return trip;
    }

    private Vehicle returnVehicleFromFile(String lineFromFile)
    {
        String[] array = lineFromFile.split(",");
        Vehicle vehicle = vehicleFactory(array);
        return vehicle;
    }

    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%//

    private void readTripsFromFile()
    {
        try {
            File file = new File("trips.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String lineFromFile = scanner.nextLine();
                Trip trip = returnTripFromFile( lineFromFile );

                int vehicleIndex = findVehicleForTrip(trip);
                trip.setVehicle( Manager.getListOfVehicles().get(vehicleIndex) );

                Manager.getListOfTrips().add(trip);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void readCustomersFromFile()
    {
        try {
            File file = new File("customers.txt");
            Scanner scanner = new Scanner(file);
            String lineFromFile;
            while (scanner.hasNextLine())
            {

                lineFromFile = scanner.nextLine();
                Customer customer = returnCustomerFromFile( lineFromFile );
                int trip = findTrip( customer );
                if(trip != -1)
                {
                    Manager.getListOfTrips().get(trip).addCustomer(customer);
                    customer.setTrip(Manager.getListOfTrips().get(trip));
                }
                else
                    System.out.println(lineFromFile + " => This customer's trip wasn't found. Error in reading from customer's file.");
            }

        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void readEmployeesFromFile()
    {
        try {
            File file = new File("employees.txt");
            Scanner scanner = new Scanner(file);
            String lineFromFile;
            
            while (scanner.hasNextLine())
            {
                lineFromFile = scanner.nextLine();
                Employee employee = returnEmployeeFromFile( lineFromFile );
                if( employee instanceof Driver)
                {
                    addDriverToTrips((Driver)employee);
                }
                Manager.getListOfEmployees().add(employee);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void readVehiclesFromFile()
    {
        try {
            File file = new File("vehicles.txt");
            Scanner scanner = new Scanner(file);
            String lineFromFile;
            while (scanner.hasNextLine())
            {
                lineFromFile = scanner.nextLine();
                Vehicle vehicle = returnVehicleFromFile( lineFromFile );
                Manager.getListOfVehicles().add(vehicle);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%//

    public void printTripsToFile()
    {
        PrintWriter printToFile = createPrintWriter("trips.txt");
        for (Trip trip : Manager.getListOfTrips()) {
            printToFile.println(trip);
        }
        printToFile.close();
    }

    public void printCustomersToFile()
    {
        PrintWriter printToFile = createPrintWriter("customers.txt");
        for (Trip trip : Manager.getListOfTrips()) {
            for (Customer customer: trip.customerList) {
                printToFile.println(customer);
            }
        }
        printToFile.close();
    }

    public void printEmployeesToFile()
    {
        PrintWriter printToFile = createPrintWriter("employees.txt");
        for (Employee employee : Manager.getListOfEmployees()) {
            printToFile.println(employee);
        }
        printToFile.close();
    }

    public void printVehiclesToFile()
    {
        PrintWriter printToFile = createPrintWriter("vehicles.txt");
        for (Vehicle vehicle : Manager.getListOfVehicles()) {
            vehicle.setNumberOfSeatsTaken(0);
            printToFile.println(vehicle);
        }
        printToFile.close();
    }

    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%//
    
    private Employee employeeFactory(String[] array)
    {
        Employee employee = null;
        if(array[6].equals("manager"))
            employee = new Manager( array[0] , array[1] , array[2] , array[3] , Integer.parseInt(array[4]));

        else if(array[6].equals("driver"))
            employee = new Driver( array[0] , array[1] , array[2] , array[3] , Integer.parseInt(array[4]) , array[5]);

        return employee;
    }

    private Trip tripFactory(String[] array)
    {
        Trip trip = null;
        System.out.println("Inside trip factory");
        for (String string : array) {
            System.out.println(string);
        }
        if(array[9].equals("internal"))
            trip = new InternalTrip(array[0] , array[1] , Integer.parseInt(array[2]) , Integer.parseInt(array[3]) , array[4] , array[5],array[6]);

        else if(array[9].equals("external"))
            trip = new ExternalTrip(array[0] , array[1] , Integer.parseInt(array[2]) , Integer.parseInt(array[3]) , array[4] , array[5],array[6]);
        trip.setPrice(Integer.parseInt(array[7]));
        trip.setDriverId(array[8]);
        return trip;
    }

    private Vehicle vehicleFactory(String[] array)
    {
        Vehicle vehicle = null;
        if(array[3].contains("bus"))
            vehicle = new Bus( Integer.parseInt(array[1]) , Boolean.parseBoolean(array[2]) , array[3]);

        else if(array[3].contains("limo"))
            vehicle = new Limo( Integer.parseInt(array[1]) , Boolean.parseBoolean(array[2]) , array[3]);
        else if(array[3].contains("mini"))
            vehicle = new MiniBus(Integer.parseInt(array[1]) , Boolean.parseBoolean(array[2]) , array[3]);

        return vehicle;
    }
}


