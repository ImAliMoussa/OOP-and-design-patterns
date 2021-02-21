package test;


public class ExternalTrip extends Trip{

    public ExternalTrip(String destination, String locationFrom, int duration, int numberOfStops, String codeName, String vehicleCodeName,String date) {
        super(destination, locationFrom, duration, numberOfStops, codeName, vehicleCodeName,date);
    }
    
    @Override
    public int calculateStopsDiscount() {
        return super.calculateStopsDiscount(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double calculateRoundTripPrice(boolean isRound) {
        System.out.println("external class");
        return super.calculateRoundTripPrice(isRound);
    }
    
    public String toString() {
        return super.toString() + ",external";
    }
}
