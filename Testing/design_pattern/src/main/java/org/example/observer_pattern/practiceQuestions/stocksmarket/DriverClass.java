package org.example.observer_pattern.practiceQuestions.stocksmarket;

import org.example.observer_pattern.practiceQuestions.weatherstation.Subject;

public class DriverClass {

    public static void main(String[] args) {
        Subject stockMarketTicker = new StockMarketTicker();
        stockMarketTicker.addObserver(new StockMarketObserver());
        stockMarketTicker.updateState(new Stock("stock1", "4748.90"));
    }
}
