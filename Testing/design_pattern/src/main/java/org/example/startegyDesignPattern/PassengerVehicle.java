package org.example.startegyDesignPattern;

public class PassengerVehicle extends Vehicle {

    public PassengerVehicle(DrivingStrategy drivingStrategy) {
        super(drivingStrategy);
    }

    @Override
    public void drive() {
        System.out.println("Passenger vehicle is driving");
        super.drive();
    }
}
