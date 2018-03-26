package kohn.encryption;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class EncryptionGUI extends JFrame implements ActionListener {
	
	private JTextField password;
	private JTextField inputFile;
	private JTextField outputFile;
	
	private JButton inputButton;
	private JButton passwordButton;
	private JButton outputButton;
	
	private JLabel status;
	
	Encryption encryption;
	
	public EncryptionGUI() {
		inputFile = new JTextField();
		//inputFile.setSize(400, 2);
		inputButton = new JButton();
		inputButton.addActionListener(this);
		inputButton.setText("Enter");
		inputFile.setColumns(28);
		
		password = new JTextField();
		passwordButton = new JButton();
		passwordButton.setText("Password");
		outputFile = new JTextField();
		outputButton = new JButton();
		
		status = new JLabel();
		
		
		try {
			Image searchImage = ImageIO.read(new File("src/kohn/encryption/loading.gif"));
			status.setIcon(new ImageIcon(searchImage));
		}catch(IOException e2) {
			e2.printStackTrace();
		}
		
		//inputFile.setSize(400, 5);
		//password.setSize(400, 5);
		//String fileName = (String)inputFile.getText();
		//encryption = new Encryption(fileName);
		
		JPanel inputs = new JPanel(new GridLayout(0, 1));
		JPanel buttons = new JPanel(new GridLayout(0,1));
		JPanel icon = new JPanel(new GridLayout(0,1));
		JPanel outputs = new JPanel(new GridLayout(0,1));
		inputs.add(inputFile);	
		inputs.add(password);
		inputs.add(outputFile);
		buttons.add(inputButton);
		buttons.add(passwordButton);
		
		icon.add(status);
		
			
		
		buttons.add(outputButton);
		
		setTitle("Encryption Application");
		add(inputs,BorderLayout.CENTER);
		add(buttons, BorderLayout.EAST);
		
		//add(outputs, BorderLayout.SOUTH);
		//add(icon, BorderLayout.CENTER);
		Border border = BorderFactory.createEmptyBorder(20,20,30,20);
		this.getRootPane().setBorder(border);
		pack();
		setLocation(540, 320);
		getPreferredSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	public static void main(String []args) {
		
		new EncryptionGUI().setVisible(true);
	}
	
	
}
