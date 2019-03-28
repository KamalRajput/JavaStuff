package Multithreading;/*
 *@project Logic
 *@autho kamal.rajput on 28-03-2019
 */

import java.util.Scanner;

class Processor extends Thread {


    /* volatile is used to inform complier to take the value from
    main memory everytime instead of using cached value .

     here the value running will be changed to false only when main thread comes into action.
     and it can happen sometimes that main thread doesnt get the chance to execute or also if got chance it can read the cached value.
     So volatile is used to read the data from main memory

    */

    private volatile boolean running = true;

    @Override
    public void run() {
        while (running) {
            System.out.println("Hello Kamal");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void shutdown(){
        running=false;
    }
}

public class SyncronizationThreadExample {

            public static void main(String args[]){
            Processor proc1=new Processor();
            proc1.start();

            System.out.println("enter enter to stop");
            Scanner scn=new Scanner(System.in);
            scn.nextLine();

            proc1.shutdown();
            }


}
