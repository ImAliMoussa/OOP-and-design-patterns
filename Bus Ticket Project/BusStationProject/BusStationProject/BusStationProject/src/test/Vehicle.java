package test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Vehicle {
    private final int numberOfSeats;
    private int numberOfSeatsTaken;
    //private String type; Make class abstract and type is child class
    private boolean isAvailable;
    private String codeName;
    //Implement Arraylist of trips

    public Vehicle(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
    
    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public int getNumberOfSeatsTaken() {
        return numberOfSeatsTaken;
    }

    public void setNumberOfSeatsTaken(int numberOfSeatsTaken) {
        this.numberOfSeatsTaken = numberOfSeatsTaken;
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public boolean increaseSeatsTaken(int num)
    {//print success aw full
        if((numberOfSeatsTaken + num) > numberOfSeats ){
            System.out.println("fail");
            return false;}
        else{   
            numberOfSeatsTaken += num;
            System.out.println("success");
            return true;
        }
            
    }
    public boolean isFull()
    {
         return numberOfSeatsTaken == numberOfSeats ;
    }

    public Vehicle(int numberOfSeats, int numberOfSeatsTaken, boolean isAvailable, String codeName) {
        this.numberOfSeats = numberOfSeats;
        this.numberOfSeatsTaken = numberOfSeatsTaken;
        this.isAvailable = isAvailable;
        this.codeName = codeName;
    }

    @Override
    public String toString() {
        return numberOfSeats + ","  + numberOfSeatsTaken+ "," + isAvailable + "," + codeName;
    }
    
    public static int compare(Vehicle v1 , Vehicle v2)
    {
        return v1.getCodeName().compareTo(v2.getCodeName());
    }
}
















