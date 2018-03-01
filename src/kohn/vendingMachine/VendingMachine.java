package kohn.vendingMachine;

import java.text.DecimalFormat;
import java.util.Scanner;

public class VendingMachine {
 
	public static void main (String [] args)
	{
		double price = 2.25;
		double payment = 3.00;
		pay(price, payment);
		
		
	}
	
	public static void pay(double price, double payment) {
		DecimalFormat df = new DecimalFormat("##.##");
			double change = payment-price;
			Change balance = new Change(price, payment);
			balance.receiveChange();
			System.out.println("\n\tprice   " + df.format(price) + "\n\tpayment " 
					+ payment + "  -"+"\n\t \t"+df.format(change) +" ="
					+ "\n\n***** CHANGE RETURNED *****"
					+ "\n\tquarters "+ balance.getQuarters() 
					+ "\n\tdimes    "+ balance.getDimes()
					+ "\n\tnickels  "+ balance.getNickels()
					+ "\n\tpennies  "+ balance.getPennies());
		}
		
		
}


