package design_patterns.startegyDesignPattern;

public class GoodsVehicleDrivingStrategy implements DrivingStrategy {
    @Override
    public void drive() {
        System.out.println("This is Goods Vehicle Driving Strategy");
    }
}
