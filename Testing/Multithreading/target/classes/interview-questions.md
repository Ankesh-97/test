# Java Multithreading Interview Questions

## Theoretical Questions

1. **What is a thread in Java? How is it different from a process?**

2. **Explain the lifecycle of a thread in Java.**

3. **What are the different ways to create a thread in Java?**

4. **What is the difference between `start()` and `run()` methods?**

5. **Explain the concept of thread priorities in Java.**

6. **What is thread synchronization? Why is it important?**

7. **Explain the concept of deadlock. How can it be prevented?**

8. **What is thread starvation?**

9. **What are daemon threads? How are they different from user threads?**

10. **Explain the `synchronized` keyword in Java.**

11. **What are `wait()`, `notify()`, and `notifyAll()` methods? How do they work?**

12. **What is a thread pool? Why should we use it?**

13. **Explain the `volatile` keyword and its use in multithreading.**

14. **What is a ThreadLocal variable?**

15. **What is a race condition? How can it be prevented?**

16. **Explain the concept of thread safety in Java.**

17. **What is the difference between Runnable and Callable interfaces?**

18. **What are ReentrantLock, ReadWriteLock, and StampedLock?**

19. **Explain CountDownLatch, CyclicBarrier, and Semaphore.**

20. **What is the `ForkJoinPool` in Java and when would you use it?**

## Practical Implementation Questions

1. **Implement a basic thread using Thread class extension.**

```java
class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
    
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        
        thread1.setName("Thread-1");
        thread2.setName("Thread-2");
        
        thread1.start();
        thread2.start();
    }
}
```

2. **Implement a thread using Runnable interface.**

```java
class RunnableDemo implements Runnable {
    private Thread t;
    private String threadName;
    
    RunnableDemo(String name) {
        threadName = name;
    }
    
    public void run() {
        System.out.println("Running " + threadName);
        for (int i = 4; i > 0; i--) {
            System.out.println("Thread: " + threadName + ", " + i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println("Thread " + threadName + " interrupted.");
            }
        }
        System.out.println("Thread " + threadName + " exiting.");
    }
    
    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
    
    public static void main(String args[]) {
        RunnableDemo r1 = new RunnableDemo("Thread-1");
        r1.start();
        
        RunnableDemo r2 = new RunnableDemo("Thread-2");
        r2.start();
    }
}
```

3. **Implement a thread synchronization example to prevent race condition.**

```java
class Counter {
    private int count = 0;
    
    public synchronized void increment() {
        count++;
    }
    
    public int getCount() {
        return count;
    }
}

public class SynchronizationDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });
        
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });
        
        thread1.start();
        thread2.start();
        
        thread1.join();
        thread2.join();
        
        System.out.println("Final count: " + counter.getCount());
    }
}
```

4. **Implement a producer-consumer problem using wait() and notify().**

```java
class SharedBuffer {
    private int contents;
    private boolean available = false;
    
    public synchronized int get() {
        while (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }
        available = false;
        notify();
        return contents;
    }
    
    public synchronized void put(int value) {
        while (available) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        }
        contents = value;
        available = true;
        notify();
    }
}

class Producer implements Runnable {
    private SharedBuffer sharedBuffer;
    
    public Producer(SharedBuffer sharedBuffer) {
        this.sharedBuffer = sharedBuffer;
    }
    
    public void run() {
        for (int i = 0; i < 10; i++) {
            sharedBuffer.put(i);
            System.out.println("Producer: " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Producer interrupted");
            }
        }
    }
}

class Consumer implements Runnable {
    private SharedBuffer sharedBuffer;
    
    public Consumer(SharedBuffer sharedBuffer) {
        this.sharedBuffer = sharedBuffer;
    }
    
    public void run() {
        for (int i = 0; i < 10; i++) {
            int value = sharedBuffer.get();
            System.out.println("Consumer: " + value);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("Consumer interrupted");
            }
        }
    }
}

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        SharedBuffer sharedBuffer = new SharedBuffer();
        Thread producerThread = new Thread(new Producer(sharedBuffer));
        Thread consumerThread = new Thread(new Consumer(sharedBuffer));
        
        producerThread.start();
        consumerThread.start();
    }
}
```

5. **Implement a deadlock scenario and a solution to prevent it.**

```java
public class DeadlockDemo {
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();
    
    // Deadlock scenario
    public static void deadlockScenario() {
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1: Holding lock 1...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 1: Waiting for lock 2...");
                synchronized (lock2) {
                    System.out.println("Thread 1: Holding lock 1 & 2...");
                }
            }
        });
        
        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println("Thread 2: Holding lock 2...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 2: Waiting for lock 1...");
                synchronized (lock1) {
                    System.out.println("Thread 2: Holding lock 1 & 2...");
                }
            }
        });
        
        thread1.start();
        thread2.start();
    }
    
    // Deadlock prevention
    public static void deadlockPrevention() {
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1: Holding lock 1...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 1: Waiting for lock 2...");
                synchronized (lock2) {
                    System.out.println("Thread 1: Holding lock 1 & 2...");
                }
            }
        });
        
        Thread thread2 = new Thread(() -> {
            // Both threads acquire locks in the same order
            synchronized (lock1) {
                System.out.println("Thread 2: Holding lock 1...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 2: Waiting for lock 2...");
                synchronized (lock2) {
                    System.out.println("Thread 2: Holding lock 1 & 2...");
                }
            }
        });
        
        thread1.start();
        thread2.start();
    }
    
    public static void main(String[] args) {
        System.out.println("Starting deadlock scenario...");
        // Uncomment this to see the deadlock
        // deadlockScenario();
        
        System.out.println("Starting deadlock prevention...");
        deadlockPrevention();
    }
}
```

6. **Implement a thread pool using ExecutorService.**

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        // Create a fixed size thread pool with 5 threads
        ExecutorService executor = Executors.newFixedThreadPool(5);
        
        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            executor.execute(() -> {
                System.out.println("Task " + taskId + " is running on thread " + 
                                   Thread.currentThread().getName());
                try {
                    // Simulate some work
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Task interrupted");
                }
                System.out.println("Task " + taskId + " completed");
            });
        }
        
        // Shutdown the executor
        executor.shutdown();
        System.out.println("All tasks submitted, executor shutdown initiated");
    }
}
```

7. **Implement a future task using Callable and Future.**

```java
import java.util.concurrent.*;

public class CallableFutureDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        
        // Create a Callable task that returns a result
        Callable<Integer> callableTask = () -> {
            System.out.println("Callable task is running on thread: " + 
                               Thread.currentThread().getName());
            // Simulate work and calculate result
            Thread.sleep(2000);
            return 42;  // Return the computed result
        };
        
        System.out.println("Submitting Callable task...");
        Future<Integer> future = executor.submit(callableTask);
        
        try {
            // Check if task is done
            System.out.println("Task done? " + future.isDone());
            
            // Wait for the task to complete and get the result
            Integer result = future.get();
            System.out.println("Task done? " + future.isDone());
            System.out.println("Task result: " + result);
            
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // Shutdown the executor
            executor.shutdown();
        }
    }
}
```

8. **Implement a thread-safe counter using AtomicInteger.**

```java
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounterDemo {
    private static class Counter {
        private AtomicInteger count = new AtomicInteger(0);
        
        public void increment() {
            count.incrementAndGet();
        }
        
        public int getCount() {
            return count.get();
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });
        
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });
        
        thread1.start();
        thread2.start();
        
        thread1.join();
        thread2.join();
        
        System.out.println("Final count: " + counter.getCount());
    }
}
```

9. **Implement a thread-local variable example.**

```java
public class ThreadLocalDemo {
    // ThreadLocal variable to store user IDs for each thread
    private static ThreadLocal<Integer> userIdThreadLocal = new ThreadLocal<>();
    
    // Method to set user ID for the current thread
    public static void setUserId(int userId) {
        userIdThreadLocal.set(userId);
    }
    
    // Method to get user ID for the current thread
    public static int getUserId() {
        return userIdThreadLocal.get();
    }
    
    // Method that uses the ThreadLocal variable
    public static void displayUserId() {
        System.out.println("User ID for thread " + Thread.currentThread().getName() + 
                           ": " + getUserId());
    }
    
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            setUserId(1001);
            displayUserId();
        }, "Thread-1");
        
        Thread thread2 = new Thread(() -> {
            setUserId(1002);
            displayUserId();
        }, "Thread-2");
        
        thread1.start();
        thread2.start();
    }
}
```

10. **Implement a CountDownLatch example.**

```java
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        // CountDownLatch with a count of 3
        CountDownLatch latch = new CountDownLatch(3);
        
        // Service 1
        Thread service1 = new Thread(() -> {
            try {
                System.out.println("Service 1 initializing");
                Thread.sleep(1000);
                System.out.println("Service 1 initialized");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        // Service 2
        Thread service2 = new Thread(() -> {
            try {
                System.out.println("Service 2 initializing");
                Thread.sleep(2000);
                System.out.println("Service 2 initialized");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        // Service 3
        Thread service3 = new Thread(() -> {
            try {
                System.out.println("Service 3 initializing");
                Thread.sleep(3000);
                System.out.println("Service 3 initialized");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        // Main application thread
        Thread mainApp = new Thread(() -> {
            try {
                System.out.println("Main application waiting for services to initialize");
                latch.await();
                System.out.println("All services initialized, main application starting");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        service1.start();
        service2.start();
        service3.start();
        mainApp.start();
    }
}
```