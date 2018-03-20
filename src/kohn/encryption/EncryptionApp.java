package kohn.encryption;

import java.io.File;
import java.util.Scanner;

public class EncryptionApp {

	public static void main(String [] args) {
		Encryption e = new Encryption();
		String inputFile = "src/doc.txt";
		String encryptedFile = "docEncrypt.txt";
		String decryptedFile = "docDecrypt.txt";
		String key = "shoeboxInspected";
	
	
		try {
			e.encryption(inputFile, encryptedFile, key);
			e.decryption(encryptedFile, decryptedFile, key);
			
		} catch (EncryptionException exc) {
			exc.printStackTrace();
		}
	}
}
