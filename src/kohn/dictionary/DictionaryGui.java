package kohn.dictionary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;


@SuppressWarnings("serial")
public class DictionaryGui extends JFrame implements ActionListener{
	
	
	private JFormattedTextField wordField;
	private JTextArea definitionArea;
	
	private JButton definitionButton;
	
	Dictionary dictionary;
	
	public DictionaryGui(String fileName) {
		
		dictionary = new Dictionary("src/dictionary.txt");
		definitionButton = new JButton();

		try {
			Image searchImage = ImageIO.read(new File("src/search.png"));
			definitionButton.setIcon(new ImageIcon(searchImage));
		}catch(IOException e2) {
			e2.printStackTrace();
		}
		definitionButton.setAlignmentX(RIGHT_ALIGNMENT);;
		definitionButton.addActionListener(this);
		
		wordField = new JFormattedTextField();
		wordField.setColumns(38);
		wordField.setAlignmentX(LEFT_ALIGNMENT);
		wordField.isFocusable();	
		
		definitionArea = new JTextArea(20, 28);	
		definitionArea.setLineWrap(true);
		definitionArea.setWrapStyleWord(true);
		
		JPanel panel = new JPanel(new BorderLayout(5,7));
		Border border = BorderFactory.createEtchedBorder();
		
		panel.setBorder(border);
		panel.add(wordField, BorderLayout.BEFORE_LINE_BEGINS);
		panel.add(definitionButton, BorderLayout.EAST);
		panel.add(definitionArea, BorderLayout.PAGE_END);
		
		add(panel);
		pack();
		setLocation(540, 320);
		setSize(540, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String updateWord = (String)wordField.getText();
		dictionary.setWord(updateWord);		
		String updateDefin = dictionary.getDefinition(updateWord);
		definitionArea.setText(updateDefin);
	}

	
	public static void main(String[]args) {
		
		String fileName = "src/dictionary.txt";
		new DictionaryGui(fileName).setVisible(true);;		
	}
	
}
