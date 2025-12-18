package ie.atu.sw.executor;

import java.util.*;
import java.util.concurrent.*;
import java.io.*;
import java.time.Duration;

import static java.lang.System.*;

public class BioSequenceProcessor {
	private Map<Integer, String> subject = new ConcurrentSkipListMap<>(); //Use this instead of a TreeMap...	
	private record Result (int id, float value){} //A record stores the result of the Levenshtein comparison

	public void compare(int size, String query, float maxEditDistance) throws Exception {
		var results = new ArrayList<Future<Result>>();
		try (var es = Executors.newFixedThreadPool(size)){
			subject.keySet().forEach(id -> {
				var future = es.submit(new Levenshtein(id, query, subject.get(id)));
				results.add(future);
			});
			
			out.println("Tasks submitted processing results....");
			results.stream().forEach(future -> {
				try {
					Result res = future.get();
					if (res.value <= maxEditDistance) {
						out.println("Match: Seq ID " + res.id() + "\t" + res.value());
					}
				} catch (Exception e) {
				}
			});
			
			out.println("Finished - shutting down thread pool.");
		}
		out.println("Done.");
	}
	

	
	//Parse the subject genome sequences into a map of <Integer, String>
	private void parse(String file) throws Exception {
		//Add the subject genome to the map "database"
		try (var br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))){
			String line = null;
			int counter = 0;
			
			while ((line = br.readLine()) != null) { //Read through the file line by line
				if (line.startsWith(">")) continue; //Skip annotation / sequence title
				
				counter++; //Increment the counter.
				subject.put(counter, line); //Add the counter as a key in the map and the 70 character sequence as a value
			}
			
			out.println("Added " + subject.size() + " sequences to the map.");
		}
	}
	
	
	/* 
	 * Levenshtein distance (Vladimir Levenshtein, 1965) is an approximate string comparison
	 * metric that measures the "edit distance" between two strings. The edit distance of two
	 * strings dist(s, t) is the number of changes to s required to transform it into t. There
	 * are many different ways of comparing strings for similarity, but they are mostly O(n^2)
	 * in their space and time complexity. See https://en.wikipedia.org/wiki/Levenshtein_distance
	 */
	private class Levenshtein implements Callable<Result>{ //Parameterise Callable<T> with a Result
		private int id; 	//The subject sequence number
		private String s; 	//The query sequence
		private String t; 	//The subject sequence
		
		public Levenshtein(int id, String s, String t) {
			this.id = id;
			this.s = s;
			this.t = t;
		}

		@Override
		public Result call() throws Exception {
			//Implement the Levenshtein distance algorithm in the threaded call() method
			int[][] distance = new int[s.length() + 1][t.length() + 1];

			for (int i = 0; i <= s.length(); i++) distance[i][0] = i;
			for (int j = 0; j <= t.length(); j++) distance[0][j] = j;

			for (int i = 1; i <= s.length(); i++){
				for (int j = 1; j <= t.length(); j++) {
					distance[i][j] = Math.min(distance[i - 1][j] + 1, Math.min(distance[i][j - 1] + 1, distance[i - 1][j - 1] + ((s.charAt(i - 1) == t.charAt(j - 1)) ? 0 : 1)));
				}
			}
			Thread.sleep(Duration.ofMillis(100)); //Go to sleep for 1s. The InterruptedException is thrown by call()
			
			//Return a new instance of Result that contains the sequence ID and Levenshtein distance.
			return new Result(id, (float) distance[s.length()][t.length()]);
		}		
	}
	
	public static void main(String[] args) throws Exception {
		var query = "TGCACTGGATAGACGTACACTACAGGATTTGAAATGGGCTAGAGTACACGTACACAGGTTCGGTACTATC";
		var runner = new BioSequenceProcessor();
		runner.parse("./SARS-CoV-2.fasta"); //Parse the subject sequences into a map for comparison
		runner.compare(5, query, 35.0f);
		out.println("Exiting...");
	}
}