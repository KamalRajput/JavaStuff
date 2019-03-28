package Multithreading;/*
 *@project Logic
 *@autho kamal.rajput on 28-03-2019
 */

class runner extends Thread{
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("hello"+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
public class Thread1 {
 public static void main(String args[]){
        runner r=new runner();
        r.start();

        runner r1=new runner();
        r1.start();
 }

}
