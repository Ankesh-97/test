package org.example.startegyDesignPattern;

public class PassengerVehicleDrivingStrategy implements DrivingStrategy {
    @Override
    public void drive() {
        System.out.println("This is Passenger Vehicle Driving Strategy");
    }
}
