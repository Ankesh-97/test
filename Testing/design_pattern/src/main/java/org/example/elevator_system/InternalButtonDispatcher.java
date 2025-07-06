package org.example.elevator_system;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
public class InternalButtonDispatcher {

    private List<? extends ElevatorCarController> elevatorCarControllerList;

    public void submitRequest(int id, int floor){
        Optional<? extends ElevatorCarController> optionalElevatorCarController = elevatorCarControllerList.stream().filter(e-> e.getElevatorCar().getId()==id).findFirst();
        ElevatorCarController elevatorCarController = optionalElevatorCarController.orElseThrow(() -> new RuntimeException("Could not find Elevator Controller"));
        elevatorCarController.acceptRequest(floor, elevatorCarController.getElevatorCar().getDirection());
    }


}
