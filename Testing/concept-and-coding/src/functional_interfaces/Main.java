package functional_interfaces;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

        public static void main(String[] args) {

//            FI1 add = (a,b) -> a+b;
//            System.out.println(add.calculate(5,6));
//
//            FI1 multiply = (a,b) -> a*b;
//            System.out.println(multiply.calculate(5,6));
//
//            FI1 divide = (a,b) ->{
//                if(b==0){
//                    return 0;
//                }
//                return a/b;
//            };
//
//            System.out.println(divide.calculate(5,6));
//
//            FI1 subtract = (a,b) -> a-b;
//            System.out.println(subtract.calculate(5,6));

//            StringManipulator reverse = (input) -> {
//                StringBuilder sb = new StringBuilder();
//                for(int i=input.length()-1;i>=0;i--){
//                    sb.append(input.charAt(i));
//                }
//                return sb.toString();
//            };
//            System.out.println(reverse.modify("hello"));

            Function<Integer,Integer> function = (a) -> a+1;
            Predicate<Integer> predicate = (a) -> a>5;
            Supplier<String> supplier = FI2::method1;
            Consumer<List<Integer>> consumer = (list) -> {
                for(int i=0;i<list.size();i++){
                    System.out.println(list.get(i));
                }
            };

            consumer.accept(List.of(1,2,3,4,5));

            TriFunction<String,String,String,String> triFunction = (a1,a2,a3)->{
                return a1+a2+a3;
            };
            System.out.println(triFunction.apply("Hello ","World ","Java"));
        }
}
