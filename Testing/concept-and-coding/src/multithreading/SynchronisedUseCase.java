package multithreading;

public class SynchronisedUseCase {

    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource();
        Producer producer = new Producer(sharedResource);
        Consumer consumer = new Consumer(sharedResource);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }
}

class SharedResource{

    int count = 0;
    public synchronized void consume(){

        System.out.println("Inside consumer method");
        try{
            if(this.count == 0){
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Consumed: " + this.count);
        this.count = 0;

    }

    public synchronized void produce(){

        System.out.println("Inside producer method");
        this.count++;
        //notifyAll();
    }
}

class Producer implements Runnable{

    SharedResource sharedResource;

    public Producer(SharedResource sharedResource){
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        sharedResource.produce();
    }
}

class Consumer implements Runnable{

    SharedResource sharedResource;

    public Consumer(SharedResource sharedResource){
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        sharedResource.consume();
    }
}
