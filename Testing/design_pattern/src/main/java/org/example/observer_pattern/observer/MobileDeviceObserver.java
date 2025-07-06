package org.example.observer_pattern.observer;

import org.example.observer_pattern.observable.AnyStationObservable;

public class MobileDeviceObserver implements AnyDeviceObserver {

    private AnyStationObservable anyStationObservable;

    public MobileDeviceObserver(AnyStationObservable anyStationObservable) {
        this.anyStationObservable = anyStationObservable;
    }

    @Override
    public void update() {
        System.out.println(this.anyStationObservable.getData());;
    }
}
