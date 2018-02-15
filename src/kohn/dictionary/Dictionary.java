package kohn.dictionary;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class Dictionary {
	
	private Map<String, String> dictionary = new HashMap<String, String>(); 
	

	public Dictionary(String fileName) {
		String word = null;
		
		
		try {
	           BufferedReader readFile = new BufferedReader(new FileReader(fileName));
	           String line = readFile.readLine();	  
	           
	           while (line != null) {	   
	        	   
	        	   String [] split = line.split("\\s+");
	        	   
	        	   if (Character.isUpperCase(line.charAt(0))) {	        
	        		    word = split[0].toString();
	        		   String definition = line.substring(word.length());
	        		   dictionary.put(word, definition);	        		   
	        		   line = readFile.readLine();
	        		   
	        		   
	        	   }
	        	   else {
	        		   line = readFile.readLine();
	        		   
	        	   }	        	   		
	           }
	        	  
	        } catch (FileNotFoundException ex) {
	            System.out.println("Exception: file not found " + ex);
			} catch (IOException e) {				
				e.printStackTrace();
				
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
	
	public ArrayList<String> getWords()
	{
		ArrayList<String> words = new ArrayList<String>(dictionary.keySet());
		Collections.sort(words);
		return words;
	}

	

}
