package org.example.observer_pattern.practiceQuestions.weatherstation;

public class MobileObserver implements Observer {
    @Override
    public void update(Object temperature) {
        System.out.println("Temparature Updated in mobile - " + temperature);
    }
}
