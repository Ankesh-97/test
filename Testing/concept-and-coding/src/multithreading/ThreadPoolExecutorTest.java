package multithreading;

import java.util.concurrent.*;

public class ThreadPoolExecutorTest {
    public static void main(String[] args) {

        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(2);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,4,10, TimeUnit.MINUTES, queue, new MyThreadFactory(), new MyRejectedExecutionHandler());
        for(int i=0; i<10; i++) {
            executor.execute(() -> {
                try{
                    Thread.sleep(5000);
                    System.out.println("Thread Name: " + Thread.currentThread().getName());
                    executor.getQueue().forEach(r -> System.out.println("Queue: " + r+ "  "+Thread.currentThread().getName()));
                }catch(Exception e){
                    System.out.println("Exception: " + e.getMessage());
                }
            });

            //executor.submit();
        }
        executor.shutdown();
    }
}

class MyThreadFactory implements  ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread thread =  new Thread(r);
        thread.setPriority(Thread.MAX_PRIORITY);
        return thread;
    }
}

class MyRejectedExecutionHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task Rejected");
    }
}
