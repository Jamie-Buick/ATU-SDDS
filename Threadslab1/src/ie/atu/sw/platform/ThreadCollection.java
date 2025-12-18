package ie.atu.sw.platform;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import static java.lang.System.out;

import java.time.Duration;
public class ThreadCollection {
	
	/*
	 * See if you can re-write the following go() method to use
	 * the standard imperative programming style instead of
	 * declarative streams. There is no computational benefit 
	 * from using streams. However, they can make Java much less
	 * verbose and easier to read and write.
	 */
	public void go() throws Exception{
		var col = new ArrayList<Thread>();
		var rand = ThreadLocalRandom.current();
		
		//Create 1000 threads that generate random numbers and add to a collection
		IntStream.range(1, 1000) //Same as a for loop
		         .forEach(i -> col.add(new Thread(() -> {
		        	 try {
						Thread.sleep(Duration.ofSeconds(1));
						 out.println(rand.nextInt(0, i));
					} catch (InterruptedException e) {
					}
		        	
		         }
		)));
		
		col.stream().forEach(Thread::start); //Loop over the collection and start each thread
	}
	
	public static void main(String[] args) throws Exception {
		new ThreadCollection().go();
	}
}