package ie.atu.sw.executor;

import java.util.concurrent.*;
import static java.lang.System.out;

public class SimpleRunnableExecutor {

	public static void main(String[] args) throws Throwable {
		var rand = ThreadLocalRandom.current();
		var es = Executors.newFixedThreadPool(50);

		for (int i = 0; i < 1000; i++) {
			es.execute(new Runnable() {
				public void run() {
					out.println(rand.nextInt(1, 101));
				}
			});
		}
		
		es.shutdown();
		es.awaitTermination(5, TimeUnit.SECONDS);
		es.shutdownNow();
	}
}