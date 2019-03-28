package Multithreading;/*
 *@project Logic
 *@autho kamal.rajput on 28-03-2019
 */

public class SynchronizedExample {

    /* As count is set to 0 initially, and count++ is an operation which involves 3 step(count=Count+1), possibility is thread that second thread can pick up the operation before
    first one stops completing its operation. So here synchronization comes into use.
     */

    private int count=0;
    public static void main(String args[]){
        SynchronizedExample sc=new SynchronizedExample();
        sc.doWork();

    }

    private synchronized  void increment(){
        count++;
    }

        public void doWork(){
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<1000;i++){
                    increment();
                }
            }
        });

            Thread t2=new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0;i<1000;i++){
                        increment();
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


            System.out.println(count);
        }

}
