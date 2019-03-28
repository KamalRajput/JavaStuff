package Multithreading;/*
 *@project Logic
 *@autho kamal.rajput on 28-03-2019
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processors extends  Thread{

    private int id;
    public Processors(int id){
        this.id=id;
    }

    @Override
    public void run() {
        System.out.println("Starting" +id);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ending" +id);
    }
}


public class Executor {

    public static void main(String args[]){
        ExecutorService ex= Executors.newFixedThreadPool(2);
        System.out.println("Started Execution");
        for(int i=0;i<5;i++){
            ex.submit(new Processors(i));
        }
        ex.shutdown();

        try {
            ex.awaitTermination(100, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finished Execution");
    }
}
