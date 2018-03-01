package kohn.vendingMachine;

import java.awt.Button;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VendingMachineGui extends JFrame{

	
	private JLabel price;
	private JLabel paid;
	private JLabel quarters;
	private JLabel dimes;
	private JLabel nickels;
	private JLabel pennies;
	
	private JButton getChange;
	
	private JFormattedTextField priceField;
	private JFormattedTextField paidField;
	private JFormattedTextField quartersField;
	private JFormattedTextField dimesField;
	private JFormattedTextField nickelsField;
	private JFormattedTextField penniesField;
	
	
	public VendingMachineGui() {
		//Change change = new Change();
		setTitle("Vending Machine");
		setSize(800, 800);
		setLayout(new GridLayout(2, 7));
		
		

		
	}
	
	public static void displayGui() {
		JFrame frame = (new VendingMachineGui());
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		displayGui();
	}
}
