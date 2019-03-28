package Multithreading;/*
 *@project Logic
 *@autho kamal.rajput on 28-03-2019
 */

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Latches {
    public static void main(String args[]){

        CountDownLatch latch=new CountDownLatch(3);
        ExecutorService ex= Executors.newFixedThreadPool(3);
        for(int i=0;i<3;i++){
            ex.submit(new ProcessorsLatches(latch,i));
        }


        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("completed");
    }
}


class ProcessorsLatches implements Runnable{


    private CountDownLatch latch;
    private int id;

    public ProcessorsLatches(CountDownLatch latch,int id){
        this.latch=latch;
        this.id=id;
    }

    @Override
    public void run() {
        System.out.println("started"+id);
        try {
            Thread.sleep(3000);
            latch.countDown();
            System.out.println(Thread.currentThread().getName() + "finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}