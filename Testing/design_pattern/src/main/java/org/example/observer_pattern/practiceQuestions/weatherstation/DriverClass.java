package src.design_patterns.observer_pattern.practiceQuestions.weatherstation;

public class DriverClass {
    public static void main(String[] args) {
        Subject weatherSubject = new WeatherSubject();
        weatherSubject.addObserver(new MobileObserver());
        weatherSubject.updateState(5);
    }
}
