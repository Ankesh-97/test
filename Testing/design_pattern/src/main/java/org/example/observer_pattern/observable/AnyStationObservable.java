package org.example.observer_pattern.observable;


import org.example.observer_pattern.observer.AnyDeviceObserver;

public interface AnyStationObservable extends Observable{

     void notifyObservers();

     void registerObserver(AnyDeviceObserver observer);

     void removeObserver(AnyDeviceObserver observer);

     String getData();
}
