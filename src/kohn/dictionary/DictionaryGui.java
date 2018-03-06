package kohn.dictionary;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
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
public class DictionaryGui extends JPanel implements ActionListener{
	
	
	private JFormattedTextField wordField;
	private JTextArea definitionArea;
	
	private JButton definitionButton;
	
	private String word;
	private String definition;
	
	Dictionary dictionary;
	
	public DictionaryGui(String fileName) {
			
		Dictionary dictionary = new Dictionary(fileName);
		
		
		wordField = new JFormattedTextField(word);
		wordField.setColumns(18);
		dictionary.setWord(" ");
		wordField.setValue(dictionary.getWord());
		wordField.isFocusable();
		
		
		String getDefinition = "<- Define";
		definitionButton = new JButton();
		definitionButton.setText(getDefinition);
		definitionButton.addActionListener(this);
		
		definitionArea = new JTextArea(12, 28);	
		definition = dictionary.getDefinition(word);
		definitionArea.setText(definition);
		definitionArea.setLineWrap(true);
		definitionArea.setWrapStyleWord(true);
		
		JPanel panel = new JPanel(new BorderLayout(10,12));
		Border border = BorderFactory.createEtchedBorder();
		panel.setBackground(Color.lightGray);
		panel.setBorder(border);
		panel.add(wordField, BorderLayout.LINE_START);
		panel.add(definitionButton, BorderLayout.LINE_END);
		panel.add(definitionArea, BorderLayout.PAGE_END);
		
		
		add(panel);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Dictionary dict = new Dictionary("src/dictionary.txt");
		String updateWord = (String)wordField.getValue();
		dict.setWord(updateWord);		
		String updateDefin = dict.getDefinition(updateWord);
		definitionArea.setText(updateDefin);
	}

	
	public static void main(String[]args) {
		
		String fileName = "src/dictionary.txt";

		JFrame frame = new JFrame("Dictionary");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new DictionaryGui(fileName));
		
		frame.pack();
		frame.setLocation(540, 320);
		frame.setSize(400, 280);
		frame.setVisible(true);
		
	}
	
	public static void displayGUI()
	{
		
	}
}
