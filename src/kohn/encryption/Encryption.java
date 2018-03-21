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
	private String iVector = "=mqz*fT^%Po!!j.?";

	public Encryption(String inputFile) {

		if (new File(inputFile).exists()) {
			this.file = new File(inputFile);
		}

		String x = file.getAbsolutePath();
		x = x.substring((x.lastIndexOf('/') + 1));
		this.extension = x.substring(x.indexOf("."));
	}

	public void encryption(String inputFile, String outputFile) {
		try {
			encrypt(new FileInputStream(inputFile));
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
	}

	public void decryption(String inputFile) {
		try {
			decrypt(new FileInputStream(inputFile));
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
	}

	private void encrypt(InputStream input) {
		OutputStream output;

		try {
			input = new FileInputStream(file);
			String fileName = file.getAbsolutePath();
			file = checkFileExists(fileName);
			output = new FileOutputStream(file);
			byte[] setKey = password.getBytes();
			SecretKey secretKey = new SecretKeySpec(setKey, "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(iVector.getBytes()));
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

	private void decrypt(InputStream input) {
		CipherInputStream outputFile = null;

		try {
			input = new FileInputStream(file);
			String filePath = file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf('.'));
			file = checkFileExists(filePath + extension);
			OutputStream output = new FileOutputStream(file);

			byte setKey[] = password.getBytes();
			SecretKey secretKey = new SecretKeySpec(setKey, "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(iVector.getBytes()));
			outputFile = new CipherInputStream(input, cipher);

			int read;
			byte[] write = new byte[1024];
			while ((read = input.read(write)) > 0) {
				output.write(write, 0, read);

			}

			input.close();
			output.close();
			outputFile.close();
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException
				| InvalidAlgorithmParameterException | IOException e) {
			e.getMessage();
		}

	}

	public boolean setPassword(String validate) {

		if (!validate.contains(String.valueOf(' ')) || validate.length() <= 16) {
			return false;
		}
		this.password = validate;
		return setPassword(validate);
	}

	private File checkFileExists(String outputFile) {

		File renameFile = new File(outputFile);
		int counter = 1;
		while (renameFile.exists()) {
			renameFile = new File(rename(counter));
			counter++;
		}
		return renameFile;
	}

	private String rename(int counter) {

		StringBuilder sb = new StringBuilder();

		String name = file.getName();
		name = name.substring(name.lastIndexOf('/') + 1, name.lastIndexOf(name.substring(name.lastIndexOf('.'))));
		sb.append(name).append(counter).append(extension);
		return sb.toString();
	}

}
