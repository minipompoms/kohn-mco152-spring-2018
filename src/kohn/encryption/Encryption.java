package kohn.encryption;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Encryption {

	private Cipher cipher;

	public void encryption(String inputFile, String outputFile, String key) {

		try {

			SecretKey secretKey = new SecretKeySpec(key.getBytes(), "AES");
			cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			encrypt(new FileInputStream(inputFile), new FileOutputStream(outputFile), cipher);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void decryption(String inputFile, String key) {
		String outputFile = "File: " + inputFile + " decrypted";
		Cipher cipher;
		SecretKey secretKey = new SecretKeySpec(key.getBytes(), "AES");
		try {
			cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			decrypt(new FileInputStream(inputFile), new FileOutputStream(outputFile), cipher);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	private void encrypt(InputStream input, OutputStream output, Cipher c) {
		output = new CipherOutputStream(output, c);
		writeBytes(input, output);
	}

	private void decrypt(InputStream input, OutputStream output, Cipher c) {
		input = new CipherInputStream(input, c);
		writeBytes(input, output);
	}

	private void writeBytes(InputStream input, OutputStream output) {
		byte[] writeBytes = new byte[1024];
		int readBytes = 0;
		try {
			input.read(writeBytes);

			while ((readBytes = input.read(writeBytes)) >= 0) {
				output.write(writeBytes, 0, readBytes);
			}
			output.close();
			input.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
