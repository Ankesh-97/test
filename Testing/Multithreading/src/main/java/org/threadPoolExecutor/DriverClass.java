package org.threadPoolExecutor;

import java.util.concurrent.*;

public class DriverClass {

    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,5,10, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(4), new CustomThreadFactory(), new CustomRejectionHandler());

        for(int i=0;i<5;i++){
            threadPoolExecutor.submit(()->{
                try{
                   // Thread.sleep(8000);
                }catch (Exception e){
                    //System.out.println("");
                }
                System.out.println("Executed Task By - " + Thread.currentThread().getName());
            });
        }

        threadPoolExecutor.shutdown();
    }
}

 class CustomThreadFactory implements ThreadFactory{

    private int i;

    @Override
    public Thread newThread(Runnable r) {
        System.out.println("Creating new Thread");
        Thread th = new Thread(r, "CustomThreadExecutor"+ i++);
        th.setDaemon(false);
        return th;
    }
}

 class CustomRejectionHandler implements RejectedExecutionHandler{

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task rejected - " + Thread.currentThread().getName());
    }
}
