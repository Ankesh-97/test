package org.example.startegyDesignPattern;

public abstract class Vehicle {

    private final DrivingStrategy drivingStrategy;

    protected Vehicle(DrivingStrategy drivingStrategy) {
        this.drivingStrategy = drivingStrategy;
    }

    protected void drive() {
        this.drivingStrategy.drive();
    }


}
