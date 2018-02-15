package kohn.dictionary;



public class DictionaryApp {

	public static void main (String [] args){
		
		String fileName = args[0];
		Dictionary dictionary = new Dictionary(fileName);
 
	
		 for (int ix = 0; ix < 88; ix++) {
			 System.out.println(": " + dictionary.getWords().get(ix) + " :");
		
		 }
	
	}
	
}
