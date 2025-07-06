package org.example.startegyDesignPattern;

public class Driver {

    public static void main(String[] args) {
        Vehicle passengerVehicle = new PassengerVehicle(new PassengerVehicleDrivingStrategy());
        passengerVehicle.drive();
    }
}
