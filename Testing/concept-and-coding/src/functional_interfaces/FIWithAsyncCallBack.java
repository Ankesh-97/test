package functional_interfaces;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class FIWithAsyncCallBack {

    public static void main(String[] args) {
        CompletableFuture<String> future = fetchDataFromRemoteService();
        future.thenApply(data ->{
            System.out.println("Data received: " + data);
            return data;
        });

        System.out.println("Main thread is not blocked!");

        try {
            future.get(); // This is just to keep the main thread alive for demonstration purposes
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static CompletableFuture<String> fetchDataFromRemoteService() {
        return CompletableFuture.supplyAsync(() -> {
            // Simulate a long-running operation, e.g., network request
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Data from remote service";
        });
    }
}
