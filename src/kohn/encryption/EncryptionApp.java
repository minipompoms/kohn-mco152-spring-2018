package kohn.encryption;



public class EncryptionApp {

	public static void main(String [] args) {
		String inputFile = "a_test.txt";
		String encryptedFile = "a_test1.txt";
		String key = "shoeboxInspectex";
		Encryption en = new Encryption(inputFile, key);
		
		Encryption de = new Encryption(encryptedFile, key);
		//en.startEncryption();
		de.startDecryption();
		
	}
}
