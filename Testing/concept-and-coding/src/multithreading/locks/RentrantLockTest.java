package multithreading.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RentrantLockTest {

    public static void main(String[] args) {

        SharedResource sharedResource1 = new SharedResource();
        Thread t1 = new Thread(()->{
            for(int i=0; i<15; i++) {
                sharedResource1.increment();
            }
        });
        SharedResource sharedResource2 = new SharedResource();
        Thread t2 = new Thread(()->{
            for(int i=0; i<10; i++) {
                sharedResource1.getCount();
            }
        });

        t1.start();
        t2.start();
    }
}

class SharedResource {

    private Lock lock = new ReentrantLock();
    private int count = 0;

    public void increment() {

        lock.lock();
        try {
            count++;
            System.out.println("Thread " + Thread.currentThread().getName() + " has acquired the lock and is incrementing the count to - "+count);
        } finally {
            System.out.println("Thread " + Thread.currentThread().getName() + " is releasing the lock");
            lock.unlock();
        }
    }

    public void getCount() {

       try {
           lock.lock();
           if(count == 0){
               System.out.println("Thread " + Thread.currentThread().getName() + " is waiting for the count to be updated");
           }else{
               count--;
               System.out.println("Thread " + Thread.currentThread().getName() + " has acquired the lock and is consuming the count - "+count);
           }
       }finally {
           System.out.println("Thread " + Thread.currentThread().getName() + " is releasing the lock");
           lock.unlock();
       }
    }
}
