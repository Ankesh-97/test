package functional_interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ComparatorImpl {

    public static void main(String[] args) {
        Comparator<Integer> function = (a1, a2) -> {
            if(a1>a2)
                return -1;
            else if(a1<a2)
                return 1;
            else
                return 0;
        };

        Predicate<Integer> predicate = (a) -> a%2!=0;

        List<Integer> list = new ArrayList<>();
        //add random numbers to list
        list.add(5);
        list.add(3);
        list.add(7);
        list.add(1);
        list.add(9);
        list.sort(function);
        Consumer<List<Integer>> consumer = (list1) -> {
            for(Integer i : list1){
                if(predicate.test(i))
                    System.out.println(i);
            }
        };
        consumer.accept(list);
        list.stream().collect(Collectors.toList());
        combiner();
        FI1 fi1 = (a,b) -> a+b;
    }

    public static void average(){

        List<Integer> list = new ArrayList<>();
        //add random numbers to list
        list.add(5);
        list.add(3);
        list.add(7);
        list.add(1);
        list.add(9);
        double avg = list.stream().map(Integer::doubleValue).mapToDouble(a->a).average().getAsDouble();
    }

    public static void combiner(){

        List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> list2 = Arrays.asList(11,12,13,14,15,16,17,18,19,20);

        BiFunction<List<Integer>,List<Integer>,List<Integer>> biFunction = (l1,l2) -> {
            List<Integer> list3 = new ArrayList<>();
           for(int i=0;i<Math.min(l1.size(),l2.size());i++){
               list3.add(l1.get(i)+l2.get(i));
           }
           return list3;
        };
        Consumer<List<Integer>> consumer = (list) -> {
            for(Integer i : list){
                    System.out.println(i);
            }
        };
        consumer.accept(biFunction.apply(list1,list2));
    }


}
