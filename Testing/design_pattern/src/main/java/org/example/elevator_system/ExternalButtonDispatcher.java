package org.example.elevator_system;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public abstract class ExternalButtonDispatcher {

    private List<? extends ElevatorCarController> elevatorCarControllerList;





}
