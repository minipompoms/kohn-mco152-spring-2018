package kohn.vendingMachine;


public class Change {
	private int quarters;
	private int dimes;
	private int nickels;
	private int pennies;
	private double change;
	
	public Change(double price, double payment) { 
		this.change = payment - price;
					
	}

	public void receiveChange() {
		int xChange = (int)Math.round(change*100);
		quarters = (xChange / 25);		
		dimes = ((xChange % 25) / 10);	
		nickels = ((xChange % 25 % 10) / 5);		
		pennies = (xChange % 5);	
	
	}
	public int getQuarters() {		
		return quarters;
	}

	public int getDimes() {
		return dimes;
	}

	public int getNickels() {
		return nickels;
	}

	public int getPennies() {
		return pennies;
	}
	
	

}
