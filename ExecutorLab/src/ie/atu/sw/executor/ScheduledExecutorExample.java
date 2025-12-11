package ie.atu.sw.executor;

import java.time.Duration;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import static java.lang.System.out;

public class ScheduledExecutorExample {
	public void go() throws Exception {
		Runnable r = () -> out.println("r...");
		Runnable s = () -> out.println("s...");
		Runnable t = () -> out.println("t...");
		
		try(var pool = new ScheduledThreadPoolExecutor(1)){
			pool.schedule(r, 2, TimeUnit.SECONDS);
			pool.scheduleAtFixedRate(s, 5, 2, TimeUnit.SECONDS);
			pool.scheduleWithFixedDelay(t, 1, 3, TimeUnit.SECONDS);
			Thread.sleep(Duration.ofSeconds(20));
		}
	}
	
	public static void main(String[] args) throws Exception {
		new ScheduledExecutorExample().go();
	}
}