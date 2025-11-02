package ie.atu.sw;

import java.util.*;

// Just doing this here for ease.

public class Runner {

	public static void main(String[] args) {
		
		// We are assuming the names are already in the list.. this will not work.
		//["John", "Patrick", "Mary", "Anthony", "Anne", "Margaret", "Peter"]
		
		// (a) 
		List<String> peopleArray = new ArrayList<String>();			// O(1) - constant time operation
		
		// (b)
		List<String> peopleLinked = new LinkedList<String>();		// O(1) - constant time operation
		
		// (c)
		peopleArray.add("Joe"); // Constant time operation O(1)... Added to the end of the list.
		//["John", "Patrick", "Mary", "Anthony", "Anne", "Margaret", "Peter", "Joe"]
		
		// (d)
		peopleArray.remove("Mary"); // List is looped to find Mary, Mary is removed and then the list is shifted. O(n)... mary mightn't be in the list
		// overloaded method therefore works with index int or string. String is an OBJECT!
		//["John", "Patrick", "Anthony", "Anne", "Margaret", "Peter", "Joe"]
		
		
		// ADDING AN ELEMENT TO THE MIDDLE OF A ARRAYLIST OR LINKEDLIST IS O(n)!!!!
		
		// (e)
		peopleArray.add(1, "Anthony");	// O(n)
		//["John","Anthony", "Patrick", "Anthony", "Anne", "Margaret", "Peter", "Joe"]
		
		// (f)
		peopleLinked.add(1, "Anthony"); // O(n) In a linkedlist if you add in middle it is O(n). If at beginning or end it is O(1).
		//["John", "Anthony", "Patrick", "Mary", "Anthony", "Anne", "Margaret", "Peter"]
		
		// (g)
		peopleArray.size();			// O(1) An element in the size() method tracks this as the list grows / shrinks
		peopleLinked.size();
		
		// (h) // This is answered differently in lecture slides and in the lab class.
		peopleArray.clear();				// O(n) - Loops and sets each element to null
		peopleArray = new ArrayList<>();	
		
		// (i)
		boolean hasTim = peopleArray.contains("Tim"); // O(n) Tim might not exist and you have to search to the end.
		
		// (j)											// O(n) you are looping over the list 
		for (String person : peopleArray ){
			System.out.println(person);
		}
		
		for (int i = 0; i < peopleArray.size(); i++) {
			System.out.println(peopleArray.get(i));
		}
	}
	
	

}
