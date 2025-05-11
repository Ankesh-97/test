import java.util.List;
import java.util.Map;

public class Generic1<T>{

    public void method(T t){
        System.out.println(t);
    }
}


class Generic2<K,V>{

        public void method(Map<K,V> pair1, Map<K,V> pair2){
            System.out.println(pair1.isEmpty());
            System.out.println(pair2.isEmpty());
        }
}

class Generic3<T extends Number>{
    public void method(List<? extends Number> list){
        System.out.println(list.isEmpty());
    }
}

class Object<T,V>{
    public void method(){
        System.out.println("Object method");
    }
    public void method(T t){
        System.out.println(t);
    }
}

abstract class A1{
    protected abstract void method();
}

 class A2 extends A1{
    public void method(){

    }
}

