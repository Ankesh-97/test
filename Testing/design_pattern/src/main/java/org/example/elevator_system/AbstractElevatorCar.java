package org.example.elevator_system;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AbstractElevatorCar {

    private int id;
    private Display display;
    private Status status;
    private int current_floor;
    private Direction direction;
    private InternalButton internalButton;
    private String Name;

}
