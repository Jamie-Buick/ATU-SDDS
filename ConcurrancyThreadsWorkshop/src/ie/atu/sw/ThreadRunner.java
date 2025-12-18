package ie.atu.sw;

import java.time.Duration;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThreadRunner {

	public void go() throws Exception{
		System.out.println("Go: " + this.getClass().getName());
		/*
		for (int i = 0; i < 100; i++) {
			
			new Thread(new Task(), "T-" + i).start();
		}
		
		
		
		Runnable task = new Task();
		Thread worker = new Thread(task);
		worker.start();
		//worker.join();
		*/
		
		
		try (var es = Executors.newFixedThreadPool(100)) {
			for (int i = 0; i < 10000; i++) {
				es.submit(new Task());
			}
		
		}
		
		
		
	}
	
	
	public class Task implements Runnable{     // runnable is an interface and has a single method
		public void run() {
			System.out.println("Started: " + Thread.currentThread().getId());
			
			try {
				Thread.sleep(Duration.ofSeconds(5));
			} catch (InterruptedException e) {
			}
		
			System.out.println("Thread is about to die.....");
		} 
	}
		
	
	
	
	public static void main(String[] args) throws Exception {
		//int i = System.in.read(); // This just blocks until something added to console.
		new ThreadRunner().go();
		System.out.println("Exiting main.... I'm outta here");
		
	}
	
	
	
	
}
