package ie.atu.sw.platform;

import java.time.Duration;
import static java.lang.System.out;
public class JoiningThread {

	public void go() throws Exception{
		var t1 = new Thread(new Task(), "T-1");
		var t2 = new Thread(new Task(), "T-2");
		var t3 = new Thread(new Task(), "T-3");
		t1.start();

		//Start t2 after waiting for 1 seconds or if t1 is dead
		t1.join(Duration.ofSeconds(1));
		t2.start();

		//Start t3 only when t1 is dead
		t1.join();
		t3.start();
		
		//Let all threads complete before finishing main thread
		t2.join();
		t3.join();

		out.println("[t1, t2, t3] dead, exiting main() thread");
	}
	
	private class Task implements Runnable{
	    public void run() {
	        out.println("Started:" + Thread.currentThread().getName());
	        try {
	            Thread.sleep(Duration.ofSeconds(3));
	        } catch (InterruptedException e) {}
	        out.println("Ended: "+Thread.currentThread().getName());
	    }     
	}

	public static void main(String[] a) throws Exception {
		new JoiningThread().go();
	}
}