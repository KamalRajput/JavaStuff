package Multithreading;/*
 *@project Logic
 *@autho kamal.rajput on 28-03-2019
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* here one way to guarantee synchronization is to apply synchronized keyword on method,
but it will have performance issues ,as if one thread acquire a lock on synchronized method of a class, all other threads should wait
until the lock is released. Also here the data is written on two different objects in this class, So best way is to have synchronized blocks which takes an object lock.
 time diff : when synchronized applied on method -6000+ seconds
 synchronized block - 3000+ seconds

 */
class worker {

   private Random r=new Random();
   private List<Integer> list1=new ArrayList<Integer>();
   private List<Integer> list2=new ArrayList<Integer>();

   private Object lock1=new Object();
   private  Object lock2=new Object();

    public  void stageone() {
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1.add(r.nextInt(100));
        }
    }
    public  void stagetwo() {
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2.add(r.nextInt(100));
        }
    }
    public void processing(){
        for(int i=0;i<1000;i++){
            stageone();
            stagetwo();
        }
    }
    public void main(){
            System.out.println("Starting...");
            long start=System.currentTimeMillis();
            Thread t1= new Thread(new Runnable() {
                @Override
                public void run() {
                    processing();
                }
            });
        Thread t2= new Thread(new Runnable() {
            @Override
            public void run() {
                processing();
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
        long end=System.currentTimeMillis();

            System.out.println("time taken:"+(end-start));
            System.out.println("List1Size:"+list1.size()+" list 2 size:"+list2.size());

    }


}
public class MultipleLocks {
    public static void main(String args[]){
        new worker().main();
    }
}
