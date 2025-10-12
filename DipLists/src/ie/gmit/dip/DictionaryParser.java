package ie.gmit.dip;

import java.util.*;
import java.io.*;




public class DictionaryParser {

	
	public List<String> getWords(String file) throws IOException{
		
		// Set up the reader to read the file, convert to char and add to buffer
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(file))));
		String word = null;
		
		// Create a list of 'words'. Loop over the lines while they are not NULL and add each word into the words list.
		// List will automatically expand.
		List<String> words = new ArrayList<String>();
		while ((word = br.readLine()) != null) {
			//words.add(word);
			words.add(word);
		}
		
		return words;
	}

}
