package ie.atu.sw.platform;

import java.time.Duration;
import static java.lang.System.out;

public class ObjectDeadLock {
	/* 
	 * Concurrent invocations on synchronized methods on the same object are not
	 * permitted, i.e. synchronised methods cannot interleave. When a thread is 
	 * executing a synchronized method on an object, any other threads that tries
	 * to invoke a synchronized method on the same object will be suspended (blocked)
	 * until the first thread has exited the synchronised block of code.
	 */
	
	private Object lock1 = new Object(); //A lock object 
	private Object lock2 = new Object(); //Another lock object
	
	public void go() {
		Runnable r1 = () -> {
			synchronized (lock1) { //One thread can hold lock1
				out.println("r1 holding lock1.");
				try {
					Thread.sleep(Duration.ofMillis(10));
				} catch (InterruptedException e) { }
				
				out.println("r1 waiting for lock2...");
				synchronized (lock2) { //One thread can hold lock2
					out.println("r1 holding lock1 and lock2.");
				}
			}
		};
		
		Runnable r2 = () -> {
			synchronized (lock2) { //One thread can hold lock2
				out.println("r2 holding lock2.");
				try {
					Thread.sleep(Duration.ofMillis(10));
				} catch (InterruptedException e) {
				}
				
				out.println("r2 waiting for lock1...");
				synchronized (lock1) { //
					System.out.println("r2 holding lock1 and lock2.");
				}
			}
		};
		
		new Thread(r1, "T1").start(); //Gets lock1 and goes to sleep
		new Thread(r2, "T2").start(); //Gets lock2 and causes deadlock
	}

	public static void main(String[] a) throws Exception {
		new ObjectDeadLock().go();
	}
}