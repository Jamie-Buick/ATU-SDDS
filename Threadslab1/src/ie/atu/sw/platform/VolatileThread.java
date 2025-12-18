package ie.atu.sw.platform;

import java.time.Duration;
import static java.lang.System.out;
public class VolatileThread implements Runnable{
	private volatile boolean keepRunning = true; //This value is always fetched from RAM
	//private boolean keepRunning = true; //This value is cached by the CPU
	
	public void go() throws Exception {
		new Thread(this).start();
		Thread.sleep(Duration.ofMillis(100)); //Let sleeping threads lie
        
		this.keepRunning = false; //This sets the value in RAM
        assert keepRunning == false;
	}
	
	public void run() {
		long counter = 0;
		while (keepRunning) { //Read from cache if not flagged as volatile 
			counter++;
		}

		out.println("Terminated after " + counter + " iterations.");
	}

	public static void main(String[] args) throws Exception {
		new VolatileThread().go();
	}
}