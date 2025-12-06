package ie.atu.sw;

import static java.lang.System.*;

import java.time.Duration;


public class ExternalTask implements Runnable{ // External class

	@Override
	public void run() {
		
		out.println(Thread.currentThread().getName() + " started.");

		try {
			Thread.sleep(Duration.ofSeconds(2));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		out.println(Thread.currentThread().getName() + " ending.");
		
	}

}
