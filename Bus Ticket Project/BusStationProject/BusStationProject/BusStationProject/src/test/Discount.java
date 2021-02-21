package test;

/**
 * Created by FAST on 22-Mar-18.
 */
public interface Discount {

    double calculateRoundTripPrice(boolean isRound);

    int calculateStopsDiscount();
}
