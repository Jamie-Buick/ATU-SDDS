package ie.atu.sw;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class VirtualThreadPerTaskExecutor {
	public void go() {
		try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
		    IntStream.range(0, 1_000_000).forEach(i -> {
		        executor.submit(() -> {
		            Thread.sleep(Duration.ofMillis(1000));
		            return i;
		        });
		    });
		}
	}
	
	public static void main(String[] args) {
		new VirtualThreadPerTaskExecutor().go(); 
	}
}