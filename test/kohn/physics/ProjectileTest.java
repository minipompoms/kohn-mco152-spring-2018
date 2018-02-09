package kohn.physics;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProjectileTest {

	@Test
	public void testGetX() {
		//given
		Projectile p = new Projectile(23,72);
		double x = p.getX();
		assertEquals(71.0739, x, 0.1);
		//last position is delta means approx
	}

}
