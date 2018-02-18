package kohn.dictionary;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Dictionary {
	
	private Map<String, String> dictionary = new HashMap<String, String>(); 
	

	public Dictionary(String fileName) {
		String word = null;
			
		try {
			   FileReader read = new FileReader(fileName);
	           Scanner scanner = new Scanner(read);	
	           
	           while (scanner.hasNext()) {	  
	        	   word = scanner.next();
	        	   String definition =scanner.nextLine();
        		   dictionary.put(word.toLowerCase(), definition);	        		   
 		
	           }
	        	  
	        } catch (FileNotFoundException ex) {
	            System.out.println("Exception: file not found " + ex);				
			}				
		
	}

	public boolean contains(String word) {		
		if (dictionary.isEmpty()){
			return false;
		}		
		return dictionary.containsKey(word);			
	}
	
	public boolean isEmpty() {	
		return dictionary.isEmpty();
	}
	
	
	public String getDefinition(String word) {
		String definition = null;
		if (contains(word)) {
			definition = dictionary.get(word);
		}		
		return definition;
	}

	
	public ArrayList<String> getWords(){
		ArrayList<String> words = new ArrayList<String>(dictionary.keySet());
		Collections.sort(words);
		return words;
	}

	

}
