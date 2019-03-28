package Multithreading;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
	
	public static void main(String args[]) {
		ExecutorService es =Executors.newCachedThreadPool();
	Future<Integer>future=	es.submit(new Callable<Integer>() {
			
       public Integer call() throws Exception {
       Random r=new Random();
       int duration =r.nextInt(4000);
       
       if(duration>2000) {
    	   throw new IOException("Sleeping for too long");
       }
       System.out.println("Starting");
    	   Thread.sleep(duration);
       System.out.println("finished");
       
       return duration;
    	   
       }	
		});
		es.shutdown();
	try {
		System.out.println(future.get());
	} catch (InterruptedException | ExecutionException e) {
		IOException ex=(IOException)e.getCause();
		System.out.println(ex.getMessage());
	}
	
	}
	
	
}
