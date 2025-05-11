package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Iterators {
    public static void main(String[] args) {
        // Create a list of integers
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // Get the iterator
        Iterator<Integer> iterator = list.iterator();
        list.forEach(System.out::println);
        // Iterate over the list
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
