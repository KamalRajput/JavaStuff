package Multithreading;/*
 *@project Logic
 *@autho kamal.rajput on 28-03-2019
 */

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {

    /* here in this class i am not using any low level methods to synchronized production & consumption of data.
    * Blocking Queue interface is helping us to performing enqueue and dequeue restrictions.
    * */

    private static BlockingQueue<Integer> bqueue=new ArrayBlockingQueue<>(10);
    public static void main(String args[]){
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                producer();
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();


        try {
            t1.join();
            t2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    private static void producer(){
        Random random=new Random();
        while(true){
            try {
                bqueue.put(random.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void consumer() throws InterruptedException {
        Random random=new Random();

        while(true){
            Thread.sleep(100);
            if(random.nextInt(10)==0){
                Integer value=bqueue.take();
                System.out.println("Taken Value; "+value + " ; queue size is "+bqueue.size());

            }
        }
    }

}
