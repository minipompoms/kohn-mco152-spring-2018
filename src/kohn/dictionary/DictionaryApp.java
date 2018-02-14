package kohn.dictionary;



public class DictionaryApp {

	public static void main (String [] args){
		
		Dictionary dictionary = new Dictionary("src/dictionary.txt");
 
	
		 for (int ix = 0; ix < 88; ix++) {
			 System.out.println(": " + dictionary.getWords().get(ix) + " :");
		
		 }
	
	}
	
}
