package ie.atu.sw.executor;


import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class RunnableAtomicThreadPool {
	private volatile long counter; //Don't cache
	private AtomicLong atomic = new AtomicLong(); //Lock-free thread-safe programming on single variables.
	
	public void go() throws Exception {
		
		/* ExecutorService.newFixedThreadPool(n)
		 * -------------------------------------
		 * Creates a thread pool that reuses a fixed number of threads operating off a 
		 * shared unbounded queue. At any point, at most nThreads threads will be active 
		 * processing tasks. If additional tasks are submitted when all threads are active, 
		 * they will wait in the queue until a thread is available. If any thread terminates 
		 * due to a failure during execution prior to shutdown, a new one will take its place 
		 * if needed to execute subsequent tasks. The threads in the pool will exist until 
		 * it is explicitly shutdown.
		 */
		
		try(var pool = Executors.newFixedThreadPool(10)){
			for (int i = 0; i < 500; i++){
				pool.execute(() -> { //An anonymous inner class
					while (counter < 10000) {
						counter++; //Update counter...
						atomic.getAndIncrement(); //Update atomically...
						try {
							Thread.sleep(Duration.ofMillis(1));
						} catch (InterruptedException e) {
						}
					}
				});
			}//Note that you don’t call start()...!
		}
		System.out.println("Counter: " + counter);
		System.out.println("Atomic Counter: " + atomic.get());
	}
	
	public static void main(String[] args) throws Exception {
		new RunnableAtomicThreadPool().go();
	}
}