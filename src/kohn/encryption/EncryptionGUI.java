package kohn.encryption;


import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class EncryptionGUI extends JFrame implements ActionListener, ChangeListener {
	
	private JTextField password;
	private JTextField inputFile;
	private JTextField outputFile;
	
	private JButton inputButton;
	private JButton passwordButton;
	private JButton outputButton;
	private JButton exitButton;
	private JButton startButton;
	
	private String mode;
	private static JProgressBar progressBar;
	
	private String fileName = "doc1.txt";
	private String pass = "shoeboxInspected";

	
	private File fileIn;
	
	Encryption encryption = new Encryption(fileName, pass);
	
	
	public EncryptionGUI() {
		
		encryption.decryption(fileName);
		inputFile = new JTextField();
		inputButton = new JButton();
		JLabel inputLabel = new JLabel("Select file:");
		inputFile.setColumns(25);
		
		
		outputFile = new JTextField();		
		outputButton = new JButton();
		JLabel outputLabel = new JLabel("Select file:");
		outputFile.setColumns(25);
		
		password = new JPasswordField();
		passwordButton = new JButton("Enter file password");
		
		
		try {
			Image searchImage = ImageIO.read(new File("src/kohn/encryption/file_icon.png"));
			inputButton.setIcon(new ImageIcon(searchImage));
			outputButton.setIcon(new ImageIcon(searchImage));
		}catch(IOException e2) {
			e2.printStackTrace();
		}
	
//		inputButton.addActionListener(new ActionListener() {
//		      public void actionPerformed(ActionEvent e) {
//		        JFileChooser fc = new JFileChooser("src/");
//		        fc.isFileSelectionEnabled();
//		        
//		        int returnValue = fc.showOpenDialog(null);
//		        if (returnValue == JFileChooser.APPROVE_OPTION) {
//		          fileIn = fc.getSelectedFile();
//		          
//		          inputFile.setText(fileIn.getName());
//		          encryption = new Encryption(fileIn.getName(), password.getText());
//
//
//		        }
//		      }
//		    });
//		
		
	
        
        outputButton.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        		JFileChooser fc = new JFileChooser("src/");
        		System.out.println(mode);
 		        fc.isFileSelectionEnabled();
 		        
		        int returnValue = fc.showOpenDialog(null);
		        if (returnValue == JFileChooser.APPROVE_OPTION) {
			          fileIn = fc.getSelectedFile();			          
			          outputFile.setText(fileName);			   
			        }
			      }        	
        });
       
    	
        passwordButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		 JOptionPane.showConfirmDialog(null, password, "Enter Your Password:", 
        				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        		 password.setText(pass);
        	}
        	
        });
      
        ChangeListener changeListener = new ChangeListener() {
        	public void stateChanged(ChangeEvent event) {
                JTabbedPane source = (JTabbedPane) event.getSource();
                int index = source.getSelectedIndex();
                 mode = source.getTitleAt(index);
         	
                
        	}
        	
        };

		startButton = new JButton("Start");
		
		startButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			encryption.decryption(fileName);
		

			}
			
		});		
		

		exitButton = new JButton("Exit");
		exitButton.setSize(10,5);
        exitButton.addActionListener(new ActionListener() {
        
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        

		progressBar = new JProgressBar();
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);
		
		//progressBar.addPropertyChangeListener(listener);
		
		JTabbedPane tabbedPane = new JTabbedPane();
	    tabbedPane.addChangeListener(changeListener);
		JPanel eTab = new JPanel();
		JPanel dTab = new JPanel();
 		
		eTab.add(inputLabel);
		eTab.add(inputFile);	
 		eTab.add(inputButton);
 		
 		dTab.add(outputLabel);
		dTab.add(outputFile);		
		dTab.add(outputButton);
						
		tabbedPane.add("encrypt",eTab);
		tabbedPane.add("decrypt",dTab);
		tabbedPane.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
		//JPanel statusBar = new JPanel();
		//statusBar.add(progressBar);
		//statusBar.add(status);
		
		JPanel mainPanel = new JPanel();
 		mainPanel.add(exitButton);
 		mainPanel.add(passwordButton);
 		mainPanel.add(startButton);
		
	    Box box = new Box(BoxLayout.Y_AXIS);		
	    tabbedPane.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));
	    
	    box.add(tabbedPane);	    
	    box.add(mainPanel);
				
		
		Border border = BorderFactory.createEmptyBorder(20,10,20,10);
		setTitle("File Encryption App");
		add(box);
		
		this.getRootPane().setBorder(border);
		
		pack();
		setLocation(540, 320);
		getPreferredSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
        
	
	}
	
	
	
	
	 public void updateBar(int newValue) {
		
		 progressBar.setValue(newValue);
		//status = new JLabel("working...");
			
			for (int i = 0; i <= 100; i++) {
			      try {
			        SwingUtilities.invokeLater(new Runnable() {
			          public void run() {
			          progressBar.updateUI();
			          }
			        });
			        java.lang.Thread.sleep(100);
			      } catch (InterruptedException e) {
			        ;
			      }
			    }
		      
	 }
	       

	@Override
	public void stateChanged(ChangeEvent e) {
		
	}
	
	
	
	public static void main(String []args) {
		
		new EncryptionGUI().setVisible(true);
		
		
	
	
	}
}
