package kohn.encryption;

import java.io.File;


public class EncryptionApp {

	public static void main(String [] args) {
		String inputFile = "doc.txt";
		String encryptedFile = "doc1.txt";
		String key = "shoeboxInspected";
		Encryption en = new Encryption();
		//en.decrypt(encryptedFile);
		en.encryption(inputFile);
		//en.decryption(encryptedFile);
		
	}
}
