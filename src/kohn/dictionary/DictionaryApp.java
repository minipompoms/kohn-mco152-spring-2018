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
import java.util.SortedMap;

public class DictionaryApp {

	public static void main (String [] args){
		
		Map<String, String> dictionary = new HashMap<String, String>();    
		Dictionary x = new Dictionary("src/dictionary.txt");
		try {
	           BufferedReader readFile = new BufferedReader(new FileReader
	        		   ("src/dictionary.txt"));
	           String line = readFile.readLine();	  		     		  
	           while (line != null) {	
	        	   
	        	   String [] split = line.split("\\s+");
	        	   
	        	   if (Character.isUpperCase(line.charAt(0))) {	       
	        		   String aWord = split[0].toString();
	        		   
	        		   String definition = line.substring(aWord.length());
	        		   
	        		   dictionary.put(aWord, definition);
	        		   
	        		   line = readFile.readLine();
	        	   }
	        	   else {
	        		   line = readFile.readLine();
	        	   }
	        	   		
	           }
	        	   
	        } catch (FileNotFoundException ex) {
	            System.out.println("Exception: file not found " + ex);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 ArrayList<String> dict = new ArrayList<String>(dictionary.keySet());
		 
		 
		 Collections.sort(dict);
		 for (int ix = 0; ix < 43; ix++) {
			 String word = (String) dict.get(ix);
			 String def = (String)dictionary.get(word);
			 System.out.println(word+" "+def);
		 }
		
		 /*for(String word: dictionary.keySet())
          
			 System.out.println(word + ": " + dictionary.get(word));*/
		 
		 if( x.contains("AA")){
			 System.out.println("found");
		 }
		 else {
			 System.out.println("not found");
		 }
		 if(x.isEmpty()) {
			 System.out.println("nothing");
		 }
		
	}
	
}
