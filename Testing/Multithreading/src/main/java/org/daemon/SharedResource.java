package org.daemon;

public class SharedResource {

    public synchronized void produce(){
        try{
            Thread.sleep(3000);
        }catch(Exception e){

        }
        System.out.println("Releasing lock - " + Thread.currentThread().getName());
    }
}
