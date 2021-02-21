package test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class InternalTrip extends Trip{

    public InternalTrip(String destination, String locationFrom, int duration, int numberOfStops, String codeName, String vehicleCodeName,String date) {
        super(destination, locationFrom, duration, numberOfStops, codeName, vehicleCodeName,date);
    }

    @Override
    public int calculateStopsDiscount() {
        return super.calculateStopsDiscount(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double calculateRoundTripPrice(boolean isRound) {
        System.out.println("internal class");
         return super.calculateRoundTripPrice(isRound);
    }
    

    @Override
    public String toString() {
        return super.toString() + ",internal";
    }
}
