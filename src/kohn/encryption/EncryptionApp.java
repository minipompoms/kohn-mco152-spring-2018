package kohn.encryption;



public class EncryptionApp {

	public static void main(String [] args) {
		String inputFile = "a_test.txt";
		String encryptedFile = "a_test1.txt";
		String key = "shoeboxInspected";
		Encryption en = new Encryption(inputFile, key);
		if(en.validate(key)) {
			System.out.println("valid");
		}
		else {
			System.out.println("invalid");
		}
		Encryption de = new Encryption(encryptedFile, key);
		en.startEncryption();
		de.startDecryption();
		
	}
}
