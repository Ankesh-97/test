package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Collection_Interface {
    public static void main(String[] args) {
        // Create a list of integers
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);


        // Get the iterator
        Iterator<Integer> iterator = list.iterator();

        // Iterate over the list
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Print the size of the list
        System.out.println("Size of the list: " + list.size());
    }
}
