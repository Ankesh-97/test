package org.example.observer_pattern.practiceQuestions.stocksmarket;


import org.example.observer_pattern.practiceQuestions.weatherstation.Subject;
import org.example.observer_pattern.practiceQuestions.weatherstation.Observer;

import java.util.ArrayList;
import java.util.List;

public class StockMarketTicker implements Subject {

    List<Observer> observerList = new ArrayList<>();
    private Stock stock;

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
        this.observerList.forEach(o -> o.update(stock));
    }

    @Override
    public void updateState(Object o) {
        if (o instanceof Stock) {
            this.stock = (Stock) o;
            notifyObserver();
        }
    }
}
