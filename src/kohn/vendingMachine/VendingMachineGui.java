package kohn.vendingMachine;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class VendingMachineGui extends JFrame implements ActionListener {

	private JButton changeButton;

	private JTextField priceField;
	private JTextField paidField;
	private JTextField quartersField;
	private JTextField dimesField;
	private JTextField nickelsField;
	private JTextField penniesField;

	public VendingMachineGui() {

		String getChange = "RETURN CHANGE";
		changeButton = new JButton();
		changeButton.setText(getChange);
		changeButton.addActionListener(this);

		priceField = new JTextField();
		paidField = new JTextField();
		quartersField = new JTextField();
		dimesField = new JTextField();
		nickelsField = new JTextField();
		penniesField = new JFormattedTextField();
		penniesField.setColumns(5);

		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new GridLayout(0, 1));
		labelPanel.add(new JLabel("Price:"));
		labelPanel.add(new JLabel("Amt Paid:"));
		labelPanel.add(changeButton);
		labelPanel.add(new JLabel("Quarters:"));
		labelPanel.add(new JLabel("Dimes:"));
		labelPanel.add(new JLabel("Nickels:"));
		labelPanel.add(new JLabel("Pennies"));

		JPanel fieldPanel = new JPanel();
		fieldPanel.setLayout(new GridLayout(0, 1));
		fieldPanel.add(priceField);
		fieldPanel.add(paidField);
		fieldPanel.add(new JLabel(""));
		fieldPanel.add(quartersField);
		fieldPanel.add(dimesField);
		fieldPanel.add(nickelsField);
		fieldPanel.add(penniesField);

		Border border = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		setName("Vending Machine");
		add(fieldPanel, BorderLayout.EAST);
		fieldPanel.setBorder(border);
		add(labelPanel, BorderLayout.CENTER);
		labelPanel.setBorder(border);

	}

	public void displayGUI() {
		JFrame frame = (new VendingMachineGui());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame.setLocation(500, 320);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		double updatePrice = Double.parseDouble(priceField.getText());
		double updatePaid = Double.parseDouble(paidField.getText());
		
		Change receiveChange = new Change(updatePrice, updatePaid);
		receiveChange.receiveChange();

		quartersField.setText(Integer.toString(receiveChange.getQuarters()));
		dimesField.setText(Integer.toString(receiveChange.getDimes()));
		nickelsField.setText(Integer.toString(receiveChange.getNickels()));
		penniesField.setText(Integer.toString(receiveChange.getPennies()));
	}

	public static void main(String[] args) {

		VendingMachineGui display = new VendingMachineGui();

		display.displayGUI();

	}

}
