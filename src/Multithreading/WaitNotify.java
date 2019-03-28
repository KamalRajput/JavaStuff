package Multithreading;/*
 *@project Logic
 *@autho kamal.rajput on 28-03-2019
 */


import java.util.Scanner;

class  ProducerConsumerWorker{

    /* this program explains the usage of wait and notify. here i have two threads, one calls producer and other calls consumer.
    wait()-It tells the calling thread to give up the lock and go to sleep until some other thread enters the same monitor and calls notify().
    notify()-It wakes up one single thread that called wait() on the same object. It should be noted that calling notify() does not actually give up a lock on a resource until whole block is completed.
    notifyAll()-It wakes up all the threads that called wait() on the same object.
     */

    public void produce() throws InterruptedException {
        synchronized (this){

            System.out.println("producer thread is running "+Thread.currentThread().getName());
            wait();
            System.out.println("producer thread is resumed "+Thread.currentThread().getName());
        }
    }

    public void consume() throws InterruptedException {
        Thread.sleep(2000);

        Scanner scn=new Scanner(System.in);
        synchronized (this){
            System.out.println("waiting for return key");
            scn.nextLine();
            notify();
     //use this to see that notify doesnt release a lock on the resource.       Thread.sleep(5000);
        }
    }

}

 public class WaitNotify {

   static ProducerConsumerWorker pc=new ProducerConsumerWorker();
    public static void main(String args[]){
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
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

}

