package comparable_comparator;

import java.util.*;

public class ComparableTest {
    public static void main(String[] args) {
        // Create a list of integers
        Car[] arr = new Car[]{new Car(1,"A"),new Car(2,"B"),new Car(3,"C")};
        Comparator<Car> comp = (o1,o2) -> o1.id - o2.id;
        Comparator<Car> comp1 = Comparator.nullsFirst(Comparator.comparing(Car::getId).thenComparing(Car::getName));
        Arrays.sort(arr,comp1);

    }
}


class Car{
    public int id;
    public String name;

    Car(int id, String name){
        this.id = id;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

}
