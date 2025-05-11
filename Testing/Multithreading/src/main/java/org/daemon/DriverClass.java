package org.daemon;

public class DriverClass {

    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource();

        Runnable runnable = () -> sharedResource.produce();

        Thread daemonThread = new Thread(runnable, "daemon");
        Thread normalThread = new Thread(runnable, "normal");

        System.out.println("Starting main thread");
        daemonThread.setDaemon(true);

//        try{
//            Thread.sleep(3000);
//        }catch (Exception e){
//
//        }

        normalThread.start();
        daemonThread.start();
        System.out.println("Ending main thread");


    }
}
