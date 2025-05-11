package solid_design_principle;

public class LiskovosSubstitutionPrinciple {
}


// Liskov's Substitution Principle violation example
// In the below example bike has property to refuel and child class whoever extends that class
// should have property to refuel, but in the below example ElectricBike class does not have property to refuel
// anyone who use the bike class to refer the ElectricBike class will get runtime exception while calling the refuel method.

//So its kind of narrowing down the parent property rather than extending it.


class Bike{

    public void startEngine(){
        System.out.println("Bike started");
    }

    public void stop(){
        System.out.println("Bike stopped");
    }

    public void refuel(){
        System.out.println("Bike refueled");
    }
}

class ElectricBike extends Bike{

    @Override
    public void refuel(){
        throw new RuntimeException("Electric bike does not need fuel");
    }
}


