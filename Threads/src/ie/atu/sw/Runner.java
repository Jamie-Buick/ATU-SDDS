package ie.atu.sw;

import static java.lang.System.out;

import java.time.Duration;

public class Runner {

	
	public void go() throws Exception {
		
		
		for (int i = 0; i < 100000000; i++) {
			new Thread(()->{
				try {
					Thread.sleep(Duration.ofSeconds(5));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}).start();
		}
		
	}
	
	
	
	public static void main(String[] args) throws Exception {
		new Runner().go();
	}
	
	
		
		
		
		
		
		
		
		
		
		/*
		Thread t1 = new Thread(new Runnable() {   // an anom inner class
			public void run() {
					
					out.println(Thread.currentThread().getName() + " started.");
			
				try {
					Thread.sleep(Duration.ofSeconds(2));
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				out.println(Thread.currentThread().getName() + " ending.");
			}
		});
		
		
		Thread t = new Thread(() -> { // a lambda expression

			out.println(Thread.currentThread().getName() + " started.");

			try {
				Thread.sleep(Duration.ofSeconds(2));
			} catch (Exception e) {
				e.printStackTrace();
			}

			out.println(Thread.currentThread().getName() + " ending.");

		});

		t.setName("T1");
		t.start();
		
		t.join(); // Blocks....!
		
	}
	
	
	
	public static void main(String[] args) throws Exception {
		new Runner().go();
	}
	
	
	// inner class
	public class Task implements Runnable{

		@Override
		public void run() {
			
			out.println(Thread.currentThread().getName() + " started.");

			try {
				Thread.sleep(Duration.ofSeconds(2));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			out.println(Thread.currentThread().getName() + " ending.");
			
		}

	}

	*/
	}

