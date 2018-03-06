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
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class VendingMachineGui extends JFrame implements ActionListener {

	private double price;
	private double paid;

	private double quarters;
	private double dimes;
	private double nickels;
	private double pennies;

	private JButton changeButton;

	private JFormattedTextField priceField;
	private JFormattedTextField paidField;
	private JFormattedTextField quartersField;
	private JFormattedTextField dimesField;
	private JFormattedTextField nickelsField;
	private JFormattedTextField penniesField;

	Change change;

	public VendingMachineGui() {

		Change change = new Change(price, paid);
		change.receiveChange();
		
		JLabel priceLabel = new JLabel("Price:");
		JLabel paidLabel = new JLabel("Amt Paid:");
		JLabel getQuarters = new JLabel("Quarters:");
		JLabel getDimes = new JLabel("Dimes:");
		JLabel getNickels = new JLabel("Nickels:");
		JLabel getPennies = new JLabel("Pennies");

		String getChange = "RETURN CHANGE";
		changeButton = new JButton();
		changeButton.setText(getChange);
		changeButton.addActionListener(this);

		priceField = new JFormattedTextField(price);
		priceField.setColumns(5);
		priceField.setValue(price);
		priceField.isFocusable();

		paidField = new JFormattedTextField(paid);
		paidField.setColumns(5);
		paidField.setValue(paid);

		quartersField = new JFormattedTextField(quarters);
		quartersField.setColumns(5);
		quartersField.setValue(change.getQuarters());

		dimesField = new JFormattedTextField(dimes);
		dimesField.setColumns(5);
		dimesField.setValue(change.getDimes());

		nickelsField = new JFormattedTextField(nickels);
		nickelsField.setColumns(5);
		nickelsField.setValue(change.getNickels());

		penniesField = new JFormattedTextField(pennies);
		penniesField.setColumns(5);
		penniesField.setValue(change.getPennies());
		

		priceLabel.setLabelFor(priceField);
		paidLabel.setLabelFor(paidField);
		getQuarters.setLabelFor(quartersField);
		getDimes.setLabelFor(dimesField);
		getNickels.setLabelFor(nickelsField);
		getPennies.setLabelFor(penniesField);

		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new GridLayout(0, 1));
		labelPanel.add(priceLabel);
		labelPanel.add(paidLabel);
		labelPanel.add(changeButton);
		labelPanel.add(getQuarters);
		labelPanel.add(getDimes);
		labelPanel.add(getNickels);
		labelPanel.add(getPennies);

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
		
		double updatePrice = (double) priceField.getValue();
		double updatePaid = (double) paidField.getValue();
		Change receiveChange = new Change(updatePrice, updatePaid);
		receiveChange.receiveChange();
		double updateQ = receiveChange.getQuarters();
		quartersField.setValue(new Double(updateQ));
		double updateD = receiveChange.getDimes();
		dimesField.setValue(new Double(updateD));
		double updateN = receiveChange.getNickels();
		nickelsField.setValue(new Double(updateN));
		double updateP = receiveChange.getPennies();
		penniesField.setValue(new Double(updateP));

	}

	public static void main(String[] args) {

		VendingMachineGui display = new VendingMachineGui();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				display.displayGUI();
			}
		});
	}

}
