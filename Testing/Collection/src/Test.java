//import java.util.*;
//import java.util.function.Function;
//import java.util.function.Supplier;
//import java.util.stream.Collectors;
//
//import static java.lang.Math.random;
//
//public class Test {
//
//    public static void main(String[] args) {
//         Set<String> set  = Set.of("a", "b", "c","a");
////        System.out.println(test2(Test::test));
//    }
//
//
//
//    static int test() {
//        try{
//            throw new Exception("");
//        }catch (Exception e){
//            return 1;
//        }finally {
//            return 2;
//        }
//    }
//
//    List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        list.add(6);
//        list.add(7);
//
//    Map<Integer,Set<Integer>> map=list.stream().collect(Collectors.groupingBy(e->e,Collectors.toSet()));
//        list.stream().collect(Collectors.toMap(Function.identity(), e->e));
//
////       //String filtered = list.stream().filter(e->e%2==0).collect(Collector.of());
////
////        ///Arrays.stream(get(1,2,3,4,5,6,7,8,9,10)).filter(e->e%2==0).forEach(System.out::println)
//////        Stream<Integer> stream = Stream.iterate(0, e->e+1);
//////        IntStream.of(1,2,3);
////
////        list.stream().collect(Collectors.groupingBy(e->e, Collectors.counting())).entrySet().forEach(e-> System.out.println(e.getKey()+" "+e.getValue()));
//
//    // Stream.iterate(1,e->e+1).limit(20).parallel().forEach(e-> System.out.println(e+" "+Thread.currentThread().getName()));
//
////        Map<String,String> map1 = new HashMap<>();
////        map1.put("1","1");
////
////        map1.containsValue();
//
//        System.out.println(UUID.randomUUID());
//
//    static int test2(Supplier<Integer> supplier) {
//        return supplier.get();
//    }
//}
