package ie.atu.sw;

import java.util.*;

public class Ques {

	
	public static void main(String[] args) {
		
		
		// Question 1
		
		
		// Declare a TreeSet and a HashSet of the following types:
		
		// Float
		Set<Float> ft = new TreeSet<>();
		Set<Float> fh = new HashSet<>();
		
		// Add to Tree set
		ft.add(111f);
		ft.add(200f);
		
		// Add to hash set
		fh.add(10292f);
		fh.add(23433f);
		
		
		// String 
		Set<String> st = new TreeSet<>();
		Set<String> sh = new HashSet<>();
		
		// Add to Tree set
		st.add("Jamie");
		st.add("Buick");
		
		
		// Add to hash set
		sh.add("Jamie");
		sh.add("Buick");
		
		
		/*
		// Student 
		Set<Student> sdt = new TreeSet<>();
		Set<Student> sdh = new HashSet<>();
		
		// Add to Tree set
		sdt.add(new Student());
		sdt.add(new Student());
		
		// Add to hash set
		sdh.add(new Student());
		sdh.add(new Student());
		
		
		
		
		// Student 
		Set<Ninja> nt = new TreeSet<>();
		Set<Ninja> nh = new HashSet<>();
		
		// Add to Tree set
		nt.add(new Ninja("Jamie", 10));
		nt.add(new Ninja("Jamieb", 100));
		
		// Add to hash set
		nh.add(new Ninja("Jamie", 101));
		nh.add(new Ninja("Jamie", 102));
	
	*/
	
	
	// Treeset run time error?
	// Because treesets guarantree order or iteration and it is unsure how to order student. It works fine for 
	// normal java variables but objects no. Elements must be comparable or comparator. 

	
	// How to fix?
	// Make the student object comparable and order the student object. compareTo.
	
	
	// Question 2
	
	// Add element 					- Treeset - ologn
	// Remove element 				- Treeset - ologn
	// Add collection of elements 	- Treeset - 
	// Searching for set of elem 	- Treeset - ologn
	// Comp. intersect of 2 elems 	- Treeset - 
	// Comp. cardinality of set 	- Treeset - 
	
	// Add element 					- Hashset - o(1)
	// Remove element 				- Hashset - o(1)
	// Add collection of elements 	- Hashset - 
	// Searching for set of elem 	- Hashset - o(1)
	// Comp. intersect of 2 elems 	- Hashset - 
	// Comp. cardinality of set 	- Hashset - 
	
	
	
	// Question 3
	Iterator<String> i = st.iterator();
	while(i.hasNext()) {
		System.out.println(i.next());
	}
	
	Iterator<String> i1 = sh.iterator();
	while(i1.hasNext()) {
		System.out.println(i1.next());
	}
	
	
	// ST is ordered in some way with the strings? maybe ascii vals? The hash has no natural ordering and is ordered by the 
	// hash table.
	
	
	// Question 4
	
	// Strings to strings
	Map<String, String> M1 = new TreeMap<>();
	Map<String, String> M2 = new HashMap<>();
	
	M1.put("Jamie", "Jamie");
	M2.put("Jamie", "Jamie");
	
	// Doubles to integers
	Map<Double, Integer> M3 = new TreeMap<>();
	Map<Double, Integer> M4 = new HashMap<>();
	
	M3.put(123456d, 125);
	M4.put(123456d, 125);
	
	// Floats to strings
	Map<Float, String> M5 = new TreeMap<>();
	Map<Float, String> M6 = new HashMap<>();
	
	M5.put(123456f, "RALPH");
	M6.put(123456f, "RALPH");
	
	// Intergers to lists of strings
	
	List<String> names = List.of("RALPH", "SARAH", "JOHN");
	
	Map<Integer, List<String>> M7 = new TreeMap<>();
	Map<Integer, List<String>> M8 = new HashMap<>();
	
	
	M7.put(1234, names);
	M8.put(1234, names );

	
	
	// Question 5 
	
	// Add a key/value pair 						- TreeMap - ologn
	// Remove key/value pair  						- TreeMap - ologn
	// Check if a key/value pair exits 				- TreeMap - ologn
	// Add an existing key/value pair to a map  	- TreeMap - ologn
	// Retrieve and iterate over the map keys		- TreeMap - o(n)
	// Retrieve and iterate over the map values 	- TreeMap -  o(n)
	
	
	// Add a key/value pair 						- HashMap - o(1)
	// Remove key/value pair 						- HashMap - o(1)
	// Check if a key/value pair exits  			- HashMap - o(1)
	// Add an existing key/value pair to a map		- HashMap - o(1)
	// Retrieve and iterate over the map keys		- HashMap - o(n)
	// Retrieve and iterate over the map values 	- HashMap - o(n)
	
	
	// Question 6
	// This is from the lab of week 7... I will do this separately.
	
	}
}

