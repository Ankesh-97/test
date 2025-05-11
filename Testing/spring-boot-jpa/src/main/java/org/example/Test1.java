package org.example;

import java.lang.ref.WeakReference;
import java.util.Arrays;

public class Test1 {

    public static void main(String[] args) {
        int[] tickets = {84,49,5,24,70,77,87,8};
        int k = 3;
        //System.out.println(timeRequiredToBuy(tickets, k));
        //WeakReference<String> weakReference = new WeakReference<>("Hello");
        Test1 test1 = new Test1();
        StaticClass2 staticClass2 = test1.new StaticClass2();

    }

//    public static int timeRequiredToBuy(int[] tickets, int k) {
//        int seconds = 0;
//        while (tickets[k] != 0) {
//            for (int i = 0; i < tickets.length; i++) {
//                if (tickets[i] == 0) {
//                    continue;
//                } else {
//                    tickets[i]--;
//                    seconds++;
//                    if (i == k && tickets[i] == 0) {
//                        return seconds;
//                    }
//                }
//            }
//        }
//        System.out.println(Arrays.toString(tickets));
//        return seconds;
//    }

    static class StaticClass1{
        int name ;
        int number;
    }

    class StaticClass2 extends StaticClass1{
        int age;
        int caste;

        public StaticClass2(){
            super();
        }
    }

}
