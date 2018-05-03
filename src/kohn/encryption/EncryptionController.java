package kohn.encryption;

import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

public class EncryptionController {

	private EncryptionGUI view;
	private Encryption encryption;

	public EncryptionController(EncryptionGUI view, Encryption encryption) {
		this.view = view;
		this.encryption = encryption;
	}
	
	

	public void requestAction(JTextComponent file, JTextComponent pass) {

		encryption = new Encryption(file.getText(), pass.getText());
		
		if (encryption.validate(pass.getText())) {
			if (view.getMode()== "encrypt") {
				encryption.startEncryption();
			}
			if (view.getMode() == "decrypt") {
				encryption.startDecryption();
			}
		} else if (!encryption.validate(pass.getText())) {
			JOptionPane.showMessageDialog(view, "Invalid Password\n\nPassword requirements:\nMinimum of 16 Characters");
			pass.setText("");
			
		}
	}
}
