package kohn.dictionary;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;


@SuppressWarnings("serial")
public class DictionaryGui extends JPanel implements ActionListener{
	
	
	private JFormattedTextField wordField;
	private JTextArea definitionArea;
	
	private JButton definitionButton;
	
	private String word;
	private String definition;
	
	
	public DictionaryGui() {
		
		
		
		Dictionary dictionary = new Dictionary("src/dictionary.txt");
		
		
		wordField = new JFormattedTextField(word);
		wordField.setColumns(15);
		wordField.setValue(word);
		wordField.addActionListener(this);
		wordField.isFocusable();

		String getDefinition = "<- Define";
		definitionButton = new JButton();
		definitionButton.setText(getDefinition);
		
		definitionArea = new JTextArea(definition);
		definitionArea.setSize(600, 800);
		
		definitionArea.setText(dictionary.getDefinition(word));
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(wordField, BorderLayout.LINE_START);
		panel.add(definitionButton, BorderLayout.LINE_END);
		panel.add(definitionArea, BorderLayout.AFTER_LAST_LINE);
		
		
		add(panel);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	
	public static void main(String[]args) {
		
		displayGUI();
		
	}
	
	public static void displayGUI()
	{
		JFrame frame = new JFrame("Dictionary");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new DictionaryGui());
		frame.pack();
		frame.setLocation(500, 320);
		frame.setSize(400, 420);
		frame.setVisible(true);
	}
}
