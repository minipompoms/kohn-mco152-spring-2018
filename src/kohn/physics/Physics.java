package kohn.physics;


public class Physics {

	public static void main(String[] args) {

		int time;
		Projectile x = new Projectile(72, 23);

		for (time = 0; time <= 10; time++) {
			x.setTime(time);

			System.out.println(time + " " + x.getX() + "\t " + x.getY());

		}

	}

}
