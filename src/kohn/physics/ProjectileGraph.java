package kohn.physics;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class ProjectileGraph extends JComponent {
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Projectile projectile = new Projectile(42, 99);
		g.setColor(Color.RED);
		g.translate(0, getHeight());
		for(int ix = 0; ix < 10; ++ix) {
			projectile.setTime(ix);
			int x = (int)projectile.getX();
			int y = (int)projectile.getY();
			g.drawOval(x,-y, 10, 10);
			

		}
		
	}
}
