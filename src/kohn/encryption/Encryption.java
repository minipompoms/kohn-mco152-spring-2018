package kohn.encryption;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Encryption {

	private String password;
	private File file;
	private String extension;

	public Encryption(String inputFile, String password) {

		if (setPassword(password))
			this.password = password;
		if (file.exists()) {
			this.file = new File(inputFile);
		}
	}

	public void encryption(String inputFile, String outputFile) {

		try {
			encrypt(new FileInputStream(inputFile), new FileOutputStream(outputFile));
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
	}

	public void decryption(String inputFile, String outputFile) {

		try {
			decrypt(new FileInputStream(inputFile), new FileOutputStream(outputFile));
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
	}

	private void encrypt(InputStream input, OutputStream output) {
		
		try {
			input = new FileInputStream(file);
			String fileName = file.getAbsolutePath() + extension;
			file = getOutputFile(fileName);
			output = new FileOutputStream(file);
			byte[] setKey = password.getBytes();
			SecretKey secretKey = new SecretKeySpec(setKey, "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(cipher.getIV()));
			output = new CipherOutputStream(output, cipher);

			int read = 0;
			byte[] write = new byte[1024];
			input.read(write);
			while ((read = input.read(write)) >= 0) {
				output.write(write, 0, read);
			}
			input.close();
			output.close();
		} catch (IOException | InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException
				| NoSuchPaddingException e) {
			e.getMessage();
		}

	}

	private void decrypt(InputStream input, OutputStream output) {
		
		try {
			input = new FileInputStream(file);
			String filePath = file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf('.'));
			file = getOutputFile(filePath);
			byte setKey[] = password.getBytes();
			SecretKey secretKey = new SecretKeySpec(setKey, "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(cipher.getIV()));
			output = new CipherOutputStream(output, cipher);
			
			int read = 0;
			byte[] write = new byte[1024];
			while ((read = input.read(write)) >= 0) {
				output.write(write, 0, read);
			}
			input.close();
			output.close();

		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException
				| InvalidAlgorithmParameterException | IOException e) {
			e.getMessage();
		}

	}

	public boolean setPassword(String validate) {
		
		this.password = validate;
		if (!validate.contains(String.valueOf(' ')) || validate.length() <= 16) {
			return false;
		}
		return setPassword(validate);
	}

	private File getOutputFile(String outputFile) {
		File temp = new File(outputFile);
		int counter = 1;
		while (temp.exists()) {
			temp = new File(rename(counter));
			counter++;
		}
		return temp;
	}

	private String rename(int counter) {
		
		StringBuilder sb = new StringBuilder();
		sb.append(file.getName()).append(counter + ".").append(extension);
		return sb.toString();
	}

}
