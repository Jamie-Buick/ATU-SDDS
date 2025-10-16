package ie.atu.sw;

import java.util.*;

public class Runner {

	public static void main(String[] args) {
		
		// Creating collections
		// <type> <id> = <legal value>, e.g. int i = 42
		ArrayList<String> al = new ArrayList<String>(); // Poor!!!!!
		ArrayList<String> al1 = new ArrayList<>(); 		// Better!!!!
		ArrayList al2 = new ArrayList(); 				// BAD!!!!! Raw list, can store anything on it. Takes an object in methods.
		List<String> al3 = new ArrayList<>(); 			// Good!!!!! Keep type on left abstract so we can swap in any kind of list.
		Collection<String> al4 = new ArrayList<>(); 	// Best!!!! Doesn't need algorithms to sort. Its very vague. Collection is a grouping of same type without ordering.
		var al5 = new ArrayList<>(); 					// same as this ArrayList<String> al1 = new ArrayList<>(); 		
		
		
		
		
		LinkedList<String> ll = new LinkedList<String>(); // BAD!!
		
		
	
		
	}
}
