import java.time.Instant;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // write your code here
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list.sort((i1, i2)->i1.compareTo(i2));
           System.out.println(list.get(list.size()-3));

    }

}

//class A{
//    public A(){
//        System.out.println("A");
//    }
//
//}
//
//class B {
//    public B(){
//        System.out.println("B");
//    }
//}
//
//class C extends A, B{
//    public C(){
//        System.out.println("C");
//    }
//}
//
//class Person{
//
//    public Person(){
//
//    }
//    public Person(String name,String gender){
//        this.gender = gender;
//        this.name = name;
//    }
//    private String name;
//    private String gender;
//}