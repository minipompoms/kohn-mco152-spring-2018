package kohn.dictionary;


public class DictionaryApp {

	public static void main (String [] args){
		

				
		String fileName = "src/dictionary.txt";
		Dictionary dictionary = new Dictionary(fileName);
	
		 for (int ix = 0; ix < 88; ix++) {
			 System.out.println(": " + dictionary.getWords().get(ix) + " :");
		
		 }
	
	}
	
}
