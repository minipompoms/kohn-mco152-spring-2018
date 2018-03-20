package kohn.encryption;

import java.io.File;
import java.util.Scanner;

public class EncryptionApp {

	public static void main(String [] args) {
		String inputFile = "src/doc.txt";
		String encryptedFile = "docEncrypt.txt";
		Encryption e = new Encryption(inputFile, encryptedFile);
		
		String decryptedFile = "docDecrypt.txt";
		String key = "shoeboxInspected";
	
	
		e.encryption(inputFile, encryptedFile);
		e.decryption(encryptedFile, decryptedFile);
	}
}
