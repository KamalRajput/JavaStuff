package Multithreading;/*
 *@project Logic
 *@autho kamal.rajput on 28-03-2019
 */
class runners implements  Runnable {
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

}
public class RunnableThreadDemo {
    public static void main(String args[]){
    Thread thread=new Thread(new runners());
    Thread thread1=new Thread(new runners());
    thread.start();
    thread1.start();
    }


}
