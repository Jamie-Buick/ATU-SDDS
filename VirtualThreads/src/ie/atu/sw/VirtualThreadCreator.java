package ie.atu.sw;

import java.util.concurrent.ForkJoinPool;

public class VirtualThreadCreator {
	
	public void go() throws Exception {
		var t1 = Thread.ofPlatform()
				       .unstarted(()-> System.out.println(Thread.currentThread()));
		t1.start();
		t1.join();
		
		var t2 = Thread.ofVirtual()
			       .unstarted(()-> System.out.println(Thread.currentThread()));
		t2.start();
		t2.join();		
 	   	System.out.println(t2.getClass());
 	   	
 	   	
 	   	var task = ForkJoinPool.commonPool() //Not the same FJP used by virtual threads
 	   			               .submit(()-> System.out.println(Thread.currentThread().getClass()));
 	   	task.join();
 	   	
 	   	
 	   	System.out.println("Cores: " + Runtime.getRuntime().availableProcessors());	   	
 	   	System.out.println("Pools: " + Runtime.getRuntime().availableProcessors());
 	   	System.out.println("Platform Threads: " + Thread.activeCount());
 	   	
	}
	
	public static void main(String[] args) throws Exception {
		new VirtualThreadCreator().go();
	}
}