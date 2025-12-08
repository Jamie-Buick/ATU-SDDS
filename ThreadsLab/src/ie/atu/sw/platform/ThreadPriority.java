package ie.atu.sw.platform;

import static java.lang.System.out;

import java.time.Duration;
import java.util.stream.IntStream;

public class ThreadPriority {

	public void go() throws Exception{
		IntStream.range(0, 100).forEach(i -> {
			new Thread(() -> {
				var counter = 0;
				while (++counter < i) {
					try {
						Thread.currentThread().setPriority(
							i > 50 ? Thread.MAX_PRIORITY : Thread.MIN_PRIORITY
						);
						Thread.sleep(Duration.ofMillis(300));
					} catch (InterruptedException e) {}
					out.println(Thread.currentThread().getName() + " is running.");
				}
				out.println(Thread.currentThread().getName() + " is done.");
			}).start();
		});
	}
	
	public static void main(String[] args) throws Exception{
		new ThreadPriority().go();
	}
}