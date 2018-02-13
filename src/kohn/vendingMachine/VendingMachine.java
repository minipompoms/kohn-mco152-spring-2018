package kohn.vendingMachine;

import java.text.DecimalFormat;
import java.util.Scanner;

public class VendingMachine {
 
	public static void main (String [] args)
	{
		//stop print lines?? replace with what
		Scanner input = new Scanner(System.in);
		double price, payment;
		System.out.println("Enter the price amount:");
		price = input.nextDouble();
		System.out.println("Enter the payment amount:");
		payment = input.nextDouble();
		pay(price,payment);
		
	}
	
	public static void pay(double price, double payment) {
		DecimalFormat df = new DecimalFormat("##.##");
		double change = payment - price;
		if (change == 0)
		{
			System.out.println("  price " + price + "\npayment " 
					+ payment + "-\n= \t" + change);
		}
		
		else {
			Change balance = new Change(change);
			System.out.println("\tprice   " + df.format(price) + "\n\tpayment " 
					+ payment + "  -"+"\n\t \t" + df.format(change) +" ="
					+ "\n\n***** CHANGE RETURNED *****"
					+ "\n\tquarters "+ balance.getQuarters() 
					+ "\n\tdimes    "+ balance.getDimes()
					+ "\n\tnickels  "+ balance.getNickels()
					+ "\n\tpennies  "+ balance.getPennies());
		}
		
		
	}

}
