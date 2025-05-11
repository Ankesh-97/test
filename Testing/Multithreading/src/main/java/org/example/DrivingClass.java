package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DrivingClass {
        public static void main(String[] args) {

            SharedResource sharedResource = new SharedResource();
            Runnable consumerTask = () -> sharedResource.removeItem();
            Runnable producerTask = () -> sharedResource.addItem();

            Thread th1 = new Thread();
            th1.start();
            th1.start();

            //List<Thread> listOfThreads = new ArrayList<>();

//            for(int i=0;i<5;i++){
//                listOfThreads.add(new Thread(consumerTask));
//            }
//
//            for(int i=0;i<5;i++){
//                listOfThreads.add(new Thread(producerTask));
//            }
//
//            System.out.println("Starting the producer Consumer task - "+ Thread.currentThread().getName());
//            for(int i=0;i<10;i++){
//                listOfThreads.get(i).start();
//            }
//            System.out.println("Ending the producer Consumer task - "+ Thread.currentThread().getName());
        }
}
