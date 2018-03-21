package kohn.encryption;



public class EncryptionApp {

	public static void main(String [] args) {
		String inputFile = "doc.txt";
		String encryptedFile = "doc1.txt";
		String key = "shoeboxInspected";

		Encryption e = new Encryption(inputFile);
		
	
		e.setPassword(key);
		e.encryption(inputFile, encryptedFile);
		//e.decryption(encryptedFile);
	}
}
