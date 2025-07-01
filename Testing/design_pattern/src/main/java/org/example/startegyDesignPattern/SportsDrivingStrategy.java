package design_patterns.startegyDesignPattern;

public class SportsDrivingStrategy implements DrivingStrategy {

    @Override
    public void drive() {
        System.out.println("This is Sports Driving Strategy");
    }
}
