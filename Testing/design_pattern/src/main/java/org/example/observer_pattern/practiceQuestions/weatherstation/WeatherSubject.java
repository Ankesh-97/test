package org.example.observer_pattern.practiceQuestions.weatherstation;

import java.util.ArrayList;
import java.util.List;

public class WeatherSubject implements Subject {

    private List<Observer> observerList = new ArrayList<>();
    private int temprature;

    @Override
    public void addObserver(Observer o) {
        observerList.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observerList.remove(o);
    }

    @Override
    public void notifyObserver() {
        observerList.forEach(e -> e.update(this.temprature));
    }

    @Override
    public void updateState(Object o) {
        if (o instanceof Integer) {
            this.temprature = (Integer) o;
            notifyObserver();
        }
    }
}
