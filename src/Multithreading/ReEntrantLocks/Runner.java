package Multithreading.ReEntrantLocks;/*
 *@project Logic
 *@autho kamal.rajput on 28-03-2019
 */

import org.omg.CORBA.CODESET_INCOMPATIBLE;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
/* its always a good practice to put unlock code in finally block , so that even if exception is thrown.Object is unlocked.. */


    private int count=0;
    private Lock lock=new ReentrantLock();
    private Condition cond=lock.newCondition();
    private void increment() {
        for(int i=0;i<10000;i++){
            count++;
        }
    }


    public void firstThread()throws InterruptedException {
        lock.lock();
        System.out.println("waiting");
        cond.await();
        try {
            increment();
        } finally {
            lock.unlock();
        }
    }

    public void secondThread()throws InterruptedException{
        lock.lock();
        System.out.println("press the return key");
        new Scanner(System.in).nextLine();
        System.out.println("Got return key");
        cond.signal();
        try {
            increment();
        } finally {
            lock.unlock();
        }
    }

    public void finished(){
        System.out.println("count is : "+ count);
    }

}
