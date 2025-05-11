package oopsConceptsQuestions;

import java.util.ArrayList;
import java.util.List;

/*
Generics enable compile-time type checking
Code Reusability
Consistency Across Collections API
 */


public class GenericClassAndMethods{
    public static void main(String[] args) {
        Box<String> box1 = new Box<>();
        List<String> list = List.of("String");
    }

    public static void method1(List<T extends Number> list1, List<T extends Number> list2){

    }

    public static <? extends Number> method2(List<? extends Number> list1, List<? extends Number> list2){
          return new ArrayList<Integer>();
    }


}

class Box<T>{
    private T t;

    public void set(T t){
        this.t = t;
    }

    public T get(){
        return t;
    }

//    public <T extends Number> void setMethod(T t1){
//
//    }
}


