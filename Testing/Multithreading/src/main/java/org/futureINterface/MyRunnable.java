package org.futureINterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyRunnable implements Runnable{

    List<Integer> list;
    int i;

    public MyRunnable(List<Integer> list) {
        this.list = list;
        this.i = 1;
    }

    @Override
    public void run() {
       for(int j=0;j<10;j++){
           System.out.println("Running - " + Thread.currentThread().getName());
           try{
               Thread.sleep(3000);
           }catch (Exception e){
               System.out.println("Exception - " + Thread.currentThread().getName());
           }
           System.out.println("Ending - " + Thread.currentThread().getName());
           list.add(i++);
       }
    }
}
