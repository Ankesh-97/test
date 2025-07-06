package org.example.observer_pattern.observable;

import org.example.observer_pattern.observer.AnyDeviceObserver;

import java.util.ArrayList;
import java.util.List;

public class WeatherStationObservable implements AnyStationObservable{

        List<AnyDeviceObserver> observers = new ArrayList<>();

        private float temperature;
        private float humidity;
        private float pressure;

        public WeatherStationObservable() {
            this.temperature = 0;
            this.humidity = 0;
            this.pressure = 0;

        }

        public void setMeasurements(float temperature, float humidity, float pressure) {
            this.temperature = temperature;
            this.humidity = humidity;
            this.pressure = pressure;
            notifyObservers();
        }

        public float getTemperature() {
            return temperature;
        }

        public float getHumidity() {
            return humidity;
        }

        public float getPressure() {
            return pressure;
        }

        @Override
        public void notifyObservers() {

            for(AnyDeviceObserver observer : observers) {

            }
        }

        @Override
        public void registerObserver(AnyDeviceObserver observer) {
            // TODO Auto-generated method stub
        }

        @Override
        public void removeObserver(AnyDeviceObserver observer) {
            // TODO Auto-generated method stub
        }

        public String getData() {
            return "Temperature: " + temperature + " Humidity: " + humidity + " Pressure: " + pressure;
        }
}
