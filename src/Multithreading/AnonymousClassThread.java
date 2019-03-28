package Multithreading;/*
 *@project Logic
 *@autho kamal.rajput on 28-03-2019
 */

public class AnonymousClassThread {

    public static void main(String args[]){
        System.out.println("kamal");
        Thread t1=new Thread(new Runnable(){

            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("hello" + i);

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
        }
    }


