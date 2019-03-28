package Multithreading;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {

	/*A semaphore controls access to a shared resource through the use of a counter. 
	 * If the counter is greater than zero, then access is allowed. If it is 
	 * zero, then access is denied. What the counter is counting are permits that allow access to the shared resource.
	 *  Thus, to access the resource, a thread must be granted a permit from the semaphore.
	 */
		  public static void main(String[] args) throws InterruptedException {
		        //creating Random numbers
		        Random random = new Random();
		        for (int i = 0; i < 10; i++) {
		            System.out.println("Integer random is: " + random.nextInt(10));
		        }
		        //semaphore , number of permits
		        Semaphore sem = new Semaphore(1);
		        sem.acquire();
		        sem.release();
		        sem.acquire();
		        sem.release();
		        System.out.println("Available Permits " + sem.availablePermits());
		    }

	}


