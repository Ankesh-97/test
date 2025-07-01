package src.design_patterns.observer_pattern.observer;

import src.design_patterns.observer_pattern.observable.AnyStationObservable;

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
