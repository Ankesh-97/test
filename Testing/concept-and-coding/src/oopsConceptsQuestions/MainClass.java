package oopsConceptsQuestions;

public class MainClass {
    public static void main(String[] args) {
        Vehicle vehicle = new Bike();
        System.out.println("Vehicle Type: " + vehicle.getType());

    }
}

enum VehicleType {
    BIKE, CAR, TRUCK
}

abstract class Vehicle {

    VehicleType type;

    public abstract void start();

    public VehicleType getType() {
        return type;

    }
    public void stop() {
        System.out.println("Vehicle Stopped");
    }

    public void stop(boolean isEngineOff) {
        if (isEngineOff) {
            System.out.println("Engine is off");
        } else {
            System.out.println("Engine is on");
        }
    }
}

class Bike extends Vehicle {

    public Bike() {
        this.type = VehicleType.BIKE;
    }

    @Override
    public void start() {
        System.out.println("Bike Started");
    }
}

class Car extends Vehicle {

    public Car() {
        this.type = VehicleType.CAR;
    }

    @Override
    public void start() {
        System.out.println("Car Started");
    }
}


