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

	public Encryption(String filePath, String password) {
		setPassword(password);
		this.password = password;
		this.file = new File(filePath);
	
	}

	public void startEncryption() {
		encrypt();

		
	}

	public void startDecryption() {
		decrypt();
}

	private void encrypt() {
		getExtension(file);


		try {
			FileInputStream fis = new FileInputStream(file);
			String fileName = file.getAbsolutePath();
			file = checkFileExists(fileName);
			FileOutputStream fos = new FileOutputStream(file);
			
			byte[] setKey = password.getBytes();
			SecretKey secretKey = new SecretKeySpec(setKey, "AES");
			
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(iVector.getBytes()));
			CipherOutputStream cstr = new CipherOutputStream(fos, cipher);
			
			byte[] write = new byte[1024];
			int read ;
			while ((read = fis.read(write)) != -1) {
				cstr.write(write, 0, read);
			}
			fis.close();
			cstr.flush();
			cstr.close();
		} catch (IOException | InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException
				| NoSuchPaddingException e) {
			e.getMessage();
		}

	}

	private void decrypt() {
		getExtension(file);

		try {
			FileInputStream fis = new FileInputStream(file);
			String fileName = file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf('.'));
			file = checkFileExists(fileName+extension);

			//file = new File(file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf('.')));
	        FileOutputStream fos = new FileOutputStream(file);

			byte keyPassword[] = password.getBytes();
			SecretKeySpec secretKey = new SecretKeySpec(keyPassword, "AES");
			Cipher decrypt = Cipher.getInstance("AES/CBC/PKCS5Padding");
			decrypt.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(iVector.getBytes()));
            CipherInputStream cin = new CipherInputStream(fis, decrypt);
            byte[] buffer = new byte[1024];  
		     int read = 0;
		     while((read = cin.read(buffer)) != -1)  {
		        fos.write(buffer,0,read);  
		     }
           
		    cin.close();
			fos.flush();
			fos.close();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	
	
	private String getExtension(File file) {
		
		String x = file.getAbsolutePath();
		x = x.substring((x.lastIndexOf('/') + 1));
		this.extension = x.substring(x.indexOf("."));
		return this.extension;
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
