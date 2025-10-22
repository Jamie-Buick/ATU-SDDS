package ie.atu.sw;

import java.time.LocalDate;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class GoRunner {

	
	// This method is O(n) because the main loop is going to run n times regardless.
	public void go(int n) {
		var sm = new StudentManager();				// unit cost 1
		var rnd = ThreadLocalRandom.current();		// unit cost 1
		
		for (int i = 0; i < n; i++) {
			var s = new Student(rnd.nextInt(1000,100000),
								UUID.randomUUID().toString(),
								LocalDate.now());
			sm.add(s);								// O(1)
		}
		
		System.out.println(sm.size());
		System.out.println(sm);
	}
	
	
	public static void main(String[] args) {
		new GoRunner().go(100);
	}
	
}
