package ie.atu.sw.platform;

import java.time.Duration;
import static java.lang.System.out;
public class ClassDeadLock {
	private volatile boolean keepRunning = true;
	
	/*
	 * Don't call a synchronized anything from a synchronized anything.
	 */
	private synchronized void execute(String s) {
		out.println(s);
	}
	
	public void go() {
		/*
		 * This thread will hog the "this" instance of ClassDeadLock.
		 * May cause deadlock. Will definitely cause a bottleneck.
		 */
		var t1 = new Thread(() -> {
			while (keepRunning) { //keepRunning is volatile.
				synchronized (ClassDeadLock.this) { //Hogs the whole class
					try {
						Thread.sleep(Duration.ofMillis(100));
					} catch (InterruptedException e) { }
					
					/*
					 * Don't call a synchronized anything from a synchronized 
					 * anything. The instance of "this" remains locked until 
					 * the following statement executes:
					 */
					execute("execute t-1");
				}
			}
		});

		/*
		 * All synchronized methods of this instance of ClassDeadLock are
		 * blocked by t1. Thread t2 will have to wait (deadlocked)
		 * before it can invoke the synchronized execute() method.
		 */
		var t2 = new Thread(() -> {
			execute("execute t-2"); //Call a synchronized method
			keepRunning = false; //Terminate a thread gracefully
		});
		
		t1.start();
		t2.start();
	}
	
	public static void main(String[] a) {
		new ClassDeadLock().go();
	}
}