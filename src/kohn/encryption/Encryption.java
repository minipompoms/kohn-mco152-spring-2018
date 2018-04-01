package kohn.encryption;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Encryption {

	private String password;
	private File file;
	private String extension;
	private String iVector = "=mqz*fT^%Po!!j.?";

	public Encryption() {
	
	}

	public void encryption(String inputFile) {
		try {
			encrypt(new FileInputStream(inputFile));
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
	}

	public void decryption(String inputFile) {
		
		File iFile = new File(inputFile);
		setExtension(iFile);
		decrypt(iFile);
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

	private void decrypt(File inputFile) {
		this.file = inputFile;
		FileInputStream fis = null;
        FileOutputStream fos = null;
		File dFile = null;
		try {

			byte keyPassword[] = password.getBytes();
			SecretKeySpec secretKey = new SecretKeySpec(keyPassword, "AES");
			Cipher decrypt = Cipher.getInstance("AES/CBC/PKCS5Padding");
			decrypt.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(iVector.getBytes()));
			String fileName = file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf('.'));
			file = checkFileExists(fileName+extension);

            fis = new FileInputStream(fileName);
            CipherInputStream cin = new CipherInputStream(fis, decrypt);
			fos = new FileOutputStream(dFile);
			copy(cin,fos);
            
           

			fos.flush();
			
		} catch (Exception e) {
			e.getMessage();
		}


	}
	
	
	  private void copy(InputStream is,OutputStream os) throws Exception{
		  byte[] buffer = new byte[1024];  
		     int read = 0;
		     while((read = is.read(buffer)) != -1)  //reading
		        os.write(buffer,0,read);  //writing
		  }
	
	private void setExtension(File file) {
		
		String x = file.getAbsolutePath();
		x = x.substring((x.lastIndexOf('/') + 1));
		this.extension = x.substring(x.indexOf("."));
	}

	public boolean setPassword(String validate) {
		this.password = validate;
		if (!validate.contains(String.valueOf(' ')) || validate.length() <= 16) {
			return false;
		}
		
		return setPassword(password);
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
