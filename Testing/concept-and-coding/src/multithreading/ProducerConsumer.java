package multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ProducerConsumer {

    public static void main(String[] args) throws InterruptedException {

        ResourceShared resourceShared = new ResourceShared();
        Runnable producer = ()->{
            for(int i=0; i<100; i++){
                resourceShared.produce();
            }
        };
        Runnable consumer = ()->{
            for(int i=0; i<100; i++){
                resourceShared.consume();
            }
        };

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }
}

class ResourceShared{

    Queue<Integer> queue = new LinkedList<>();

    public synchronized void consume() {

        System.out.println("Inside consumer method");
        try {
            while (this.queue.isEmpty()) {
                System.out.println("Queue is empty, waiting for producer to produce");
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Consumed: " + this.queue.poll());
        notify();
    }

    public synchronized void produce(){
        System.out.println("Inside producer method");
        try {
            while(this.queue.size() == 5){
                System.out.println("Queue is Full, waiting for consumer to consume");
                wait();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        this.queue.add(new Random().nextInt(100));
        notify();
    }
}
