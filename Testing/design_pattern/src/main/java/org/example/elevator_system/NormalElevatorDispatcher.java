package org.example.elevator_system;

import java.util.List;

public class NormalElevatorDispatcher extends ExternalButtonDispatcher{
    public NormalElevatorDispatcher(List<? extends ElevatorCarController> elevatorCarControllerList) {
        super(elevatorCarControllerList);
    }
}
