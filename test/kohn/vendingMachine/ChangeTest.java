package kohn.vendingMachine;

import static org.junit.Assert.*;


import org.junit.Test;

public class ChangeTest {


	@Test
	public void testChange() { 
		Change change = new Change(2.00, 1.50);
		
		assertEquals(3, change.getQuarters());
		assertEquals(2, change.getDimes());
		assertEquals(0, change.getNickels());
		assertEquals(4, change.getPennies());
	}

}
