package ie.atu.sw;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Indexer {

	private Map<String, List<Integer>> idx = new HashMap<String, List<Integer>>();   // Adjacency List (Graphs)
	private int count = 1;
	
	public void makeIndex(String book, String out)  throws Exception {
		parse(book);
		writeIndex(out);
	}
	
	
	private void parse(String book) throws Exception { // Imperative
		try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(book)))){
			String text;
			while ((text = br.readLine()) != null) {
				process(text);
			}
		}
	}
	
	
	private void process(String line) throws Exception {
		String[] words = line.split("\s+"); 
		for (String word : words) {
			word = word.replaceAll("[^a-zA-Z]", "");
			addWork(word);
		}
	}
	
	
	private void addWork(String word) throws Exception {
		 List<Integer> list;
		 if (idx.containsKey(word)) 
		 {
			 list = idx.get(word); // O(1) HASH MAP
		 }
		 else 
		 {
			 list = new ArrayList<>();
		 }
		 list.add(count);
		 idx.put(word, list);  // O(1)
		 count++;
	}
	
	
	private void writeIndex(String out) throws Exception {
		try(FileWriter fw = new FileWriter(new File(out))){
			Map<String, List<Integer>> temp = new TreeMap<>(idx); 
			
			
			for (Map.Entry<String, List<Integer>> entry : temp.entrySet()) {
				fw.write(entry.getKey() + "\t" + entry.getValue() + "\n");
			}
			
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		new Indexer().makeIndex("./1984.txt", "index.txt");
	}
}
