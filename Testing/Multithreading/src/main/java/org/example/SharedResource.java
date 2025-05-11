package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {

    private Queue<Double> queue;
    private static final int MAX_SIZE = 5;
    public SharedResource() {
        this.queue = new LinkedList<>();
    }

    public synchronized void addItem(){

        while(this.queue.size()>=MAX_SIZE){
            System.out.println("Queue is not empty to add more items for thread - "+ Thread.currentThread().getName());
            try{
               wait();
            }catch (InterruptedException e){

            }
        }

        System.out.println("Adding more items to queue using thread - " + Thread.currentThread().getName());
        queue.add(Math.random());
        notifyAll();
    }

    public synchronized void removeItem(){
        while(this.queue.isEmpty()){
           try{
               System.out.println("Queue is empty, Cannot Consume using thread - " + Thread.currentThread().getName());
               wait();
           }catch (InterruptedException e){

           }
        }
        System.out.println("Consuming the resource from queue using thread - " + Thread.currentThread().getName() +"  Resource Consumed " + queue.poll());
        notifyAll();
    }
}
