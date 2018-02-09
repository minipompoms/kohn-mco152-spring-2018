package kohn.physics;

import java.util.Scanner;

public class Physics {

    private static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
	
		int time;
		Projectile x = new Projectile(23, 72);
		
	
		
		for (time = 0; time <= 10; time++)
		{
			x.setTime(time);
			
			System.out.println(time+" " +x.getX() +"\t " + x.getY());
			
		}
		

	}

}
