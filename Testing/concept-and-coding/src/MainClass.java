import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MainClass {
    public static void main(String[] args) {
//        Generic1 generic1 = new Generic1();
//        generic1.method(5);
//
//        GenericMethod genericMethod = new GenericMethod();
//        genericMethod.method(5);
//
//        Generic2<Integer,String> generic2 = new Generic2<>();
//        generic2.method(Map.of(1,"one"),Map.of(2,"two"));
//
         List<Integer> list = Arrays.asList(1,2,3,4,5);
         list.stream().map(i -> i*i).forEach(System.out::println);
    }
}


//class PrintImpl implements Print {
//    @Override
//    public void print() {
//        System.out.println("Hello");
//    }
//}
