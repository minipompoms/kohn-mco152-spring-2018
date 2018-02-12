package kohn.dictionary;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class DictionaryApp {
	/**
	 * @param args
	 */
	public static void main (String [] args)
	{
		Map<String, String> dictionary = new HashMap<String, String>();    
		Collection <String> words = new ArrayList<>();

		try {
	           BufferedReader readFile = new BufferedReader(new FileReader
	        		   ("src/dictionary.txt"));
	           String line = readFile.readLine();	  		     		  
	           while (line != null) {	
	        	   
	        	   String [] split = line.split("\\s+");
	        	   
	        	   if (Character.isUpperCase(line.charAt(0))) {	       
	        		   String aWord = split[0].toString();
	        		   
	        		   String definition = line.substring(aWord.length());
	        		   words.add(aWord);
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
		 for (int ix = 0; ix < dict.size(); ix++) {
			 String word = (String) dict.get(ix);
			 String def = (String)dictionary.get(word);
			 System.out.println(word+" "+def);
		 }
	
		
	      
	}
}
