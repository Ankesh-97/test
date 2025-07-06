package org.example.elevator_system;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

@Getter
@Setter
@NoArgsConstructor
public abstract class ElevatorCarController {

    private AbstractElevatorCar elevatorCar;
    private Queue<Integer> queue = new LinkedList<>();
    private PriorityQueue<Integer> minQueue = new PriorityQueue<>();
    private PriorityQueue<Integer> maxQueue = new PriorityQueue<>((e1,e2)-> Integer.compare(e2,e1));

    public ElevatorCarController(AbstractElevatorCar elevatorCar){
        this.elevatorCar  = elevatorCar;
    }

    public void acceptRequest(int floor, Direction direction){
         controlElevator(floor, direction);
    }

    public void controlElevator(int floor, Direction direction){

    }
}
