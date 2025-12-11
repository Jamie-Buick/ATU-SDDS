package ie.atu.sw.executor;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.IntStream;
import static java.lang.System.*;

import java.time.Duration;
public class ThreadPoolRandomiser {
	public void go() throws Exception {
		var results = new ArrayList<Future<Integer>>();
		
		try(var pool = Executors.newFixedThreadPool(2)){
			IntStream.range(0, 5).forEach(i -> {
				var future = pool.submit(new Randomiser());
				out.println("Task-" + i + "\n\tDone: " + future.isDone());
				out.println("\tCancelled: " + future.isCancelled());
				results.add(future);
			});
			
			out.println("\nProcessing results:");
			results.stream().forEach(n -> {
				try {
					out.println("Waiting..." + n.get());
				} catch (Exception e) {
				}
			});
		}
	}
	
	private class Randomiser implements Callable<Integer>{
		private ThreadLocalRandom rand = ThreadLocalRandom.current();
		public Integer call() throws Exception {
			Thread.sleep(Duration.ofSeconds(2));
			return (rand.nextInt() >>> 1); //Positive only
		}
	}

	public static void main(String[] args) throws Exception {
		new ThreadPoolRandomiser().go();
	}
}