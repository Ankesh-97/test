package org.futureINterface;

import io.netty.util.concurrent.DefaultThreadFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class DrivingClass {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 10, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(4), new DefaultThreadFactory("Future-thread"), new ThreadPoolExecutor.AbortPolicy());

        List<Integer> list = new ArrayList<>();
        Future<?> future = threadPoolExecutor.submit(new MyRunnable(list));
        future.get();
        System.out.println("List size - " + list);
    }
}
