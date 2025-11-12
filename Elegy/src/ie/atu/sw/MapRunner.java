package ie.atu.sw;

import java.util.*;
public class MapRunner {

	private Map<String, Integer> table = new HashMap<String, Integer>();
	
	public void process(String[] words) {
		for (String word : words) {
			
			String lcWord = word.toLowerCase();
			
			int frequency = 1;
			if (table.containsKey(lcWord)) {   //O(1)
				frequency = table.get(lcWord);
				frequency++;
			}
			table.put(lcWord, new Integer(frequency));   // O(1)
	
		}
		
		System.out.println(table);
		Map<String, Integer> sortedMap = new TreeMap<String, Integer>(table);
		
		
		
		Set<String> keys = table.keySet();
		for (String key : keys) {
			int number = table.get(key); // O(1)
		}
		
		
		Collection<Integer> values = table.values();
		for (Integer val : values) {
			System.out.println(val);
		}
		
	}
	
	
	
	public static void main(String[] args) {
		
		new MapRunner().process(args);
		
		
		
	}
	
	
	
}
