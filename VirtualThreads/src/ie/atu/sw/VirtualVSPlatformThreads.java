package ie.atu.sw;

/*
DO NOT Pool the Virtual Threads
Avoid using Thread-local Variables
Use ReentrantLock instead of Synchronized Blocks

******Don't use synchronised for virtual threads use ReentrantLock

Thread.startVirtualThread(() -> {
  // code to run in thread
});

Thread.ofVirtual().start(() -> {
  // code to run in thread
});

Thread.Builder threadBuilder = createThreadBuilder();
threadBuilder.start(() -> {
  // code to run in thread
});

Thread.currentThread().isVirtual();


ExecutorService executor = Executors.newFixedThreadPool(100);
ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
*/

import java.time.Duration;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;
import static java.lang.System.out;
public class VirtualVSPlatformThreads {

	public void go() throws Exception{
		var set = ConcurrentHashMap.newKeySet();	
		IntStream.range(0, 10_000_000).forEach(i -> {
			var t = Thread.ofVirtual()
				.unstarted(()-> {
					try {
						String s = Thread.currentThread().toString();
						set.add(s.substring(s.indexOf("@") + 1));
						Thread.sleep(Duration.ofSeconds(1));
						
					} catch (InterruptedException e) {
			     }
			});
			t.start();
		});
		
		set.stream().sorted().forEach(System.out::println);
		
		out.println("Processors: " + Runtime.getRuntime().availableProcessors());
		out.println("Platform Threads: " + set.size());	
	}
	
	public static void main(String[] args) throws Exception {
		new VirtualVSPlatformThreads().go();
	}
}
