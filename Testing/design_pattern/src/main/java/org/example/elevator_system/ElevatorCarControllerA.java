package org.example.elevator_system;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ElevatorCarControllerA extends  ElevatorCarController{

    public ElevatorCarControllerA(ElevatorCarA elevatorCar){
        super(elevatorCar);
    }
}
