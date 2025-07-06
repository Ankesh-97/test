package org.example.observer_pattern.practiceQuestions.stocksmarket;


import org.example.observer_pattern.practiceQuestions.weatherstation.Observer;

public class StockMarketObserver implements Observer {
    @Override
    public void update(Object o) {
        if (o instanceof Stock) {
            Stock s = (Stock) o;
            System.out.println("Price of " + s.getName() + " updated to - " + s.getPrice());
        }
    }
}
