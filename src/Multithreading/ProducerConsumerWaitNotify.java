package Multithreading;/*
 *@project Logic
 *@autho kamal.rajput on 28-03-2019
 */

import java.util.LinkedList;
import java.util.Scanner;

public class ProducerConsumerWaitNotify {
    public static void main(String args[]){
        ProdConsProcessor pc=new ProdConsProcessor();
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
class  ProdConsProcessor {

    private LinkedList<Integer> list = new LinkedList<Integer>();
    private final int Limit = 10;
    private Object lock1 = new Object();

    public void produce() throws InterruptedException {

        int val = 0;
        while (true) {
            synchronized (lock1) {
                while (list.size() == 10) {
                    lock1.wait();
                }
                list.add(val++);
           //     System.out.println("produced");
                lock1.notify();
            }

        }

    }

    public void consume() throws InterruptedException {
        while (true) {

            synchronized (lock1) {
                while (list.size() == 0) {
                    lock1.wait();
                }


                System.out.print("List size is : " + list.size());
                int value = list.removeFirst();
            //    System.out.println("consumed");
                System.out.println("; Value is :" + value);
                lock1.notify();
            }

            Thread.sleep(100);
        }
    }
}