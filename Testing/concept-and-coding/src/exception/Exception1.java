package exception;

import java.io.FileNotFoundException;

public class Exception1 {
    public static void main(String[] args){
        method1();
    }

    private static void method1(){
        try{
            throw new ClassNotFoundException();
        }catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
        }
    }
}
