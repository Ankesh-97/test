package multithreading.locks;

import java.sql.Timestamp;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RentrantReadWriteLockTest {

        public static void main(String[] args) {

            SharedResource1 sharedResource1 = new SharedResource1();
            Thread t1 = new Thread(()->{
                for(int i=0; i<15; i++) {
                    sharedResource1.increment();
                }
            });
            Thread t2 = new Thread(()->{
                for(int i=0; i<10; i++) {
                    sharedResource1.getCount();
                }
            });

            Thread t3 = new Thread(()->{
                for(int i=0; i<10; i++) {
                    sharedResource1.getCount();
                }
            });

            t1.start();
            t2.start();
            t3.start();
        }
}

class SharedResource1 {

    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private int count = 0;

    public void increment() {

        lock.writeLock().lock();
        try {
            count++;
            System.out.println("Thread " + Thread.currentThread().getName() + " has acquired the lock and is incrementing the count to - " + count);
        } finally {
            System.out.println("Thread " + Thread.currentThread().getName() + " is releasing the lock");
            lock.writeLock().unlock();
        }
    }

    public void getCount() {
        try {
            lock.readLock().lock();
            System.out.println("Thread " + Thread.currentThread().getName() + " is started sleeping - "+ Timestamp.from(java.time.Instant.now()));
            Thread.sleep(8000L);
            System.out.println("Thread " + Thread.currentThread().getName() + " is sleeping - "+ Timestamp.from(java.time.Instant.now()));
            if (count == 0) {
                System.out.println("Thread " + Thread.currentThread().getName() + " is waiting for the count to be updated");
            } else {
                count--;
                System.out.println("Thread " + Thread.currentThread().getName() + " has acquired the lock and is consuming the count - " + count);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Thread " + Thread.currentThread().getName() + " is releasing the lock");
            lock.readLock().lock();
        }
    }
}
