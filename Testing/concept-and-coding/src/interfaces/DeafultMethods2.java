package interfaces;

public interface DeafultMethods2 {
    default void print(){
        System.out.println("Default method");
    }
    static void printStatic(){
        System.out.println("Static method");
    }
}
