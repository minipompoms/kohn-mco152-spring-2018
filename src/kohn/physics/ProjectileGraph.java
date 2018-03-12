package kohn.physics;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;


import javax.swing.JComponent;

@SuppressWarnings("serial")
public class ProjectileGraph extends JComponent {
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Projectile projectile = new Projectile(42, 99);
				
		g.translate(50, 300);
		for(int ix = 0; ix < 10; ++ix) {
			projectile.setTime(ix);
			int x = (int)projectile.getX();
			int y = (int)projectile.getY();
			projectile.setTime(ix+1);
			int xx = (int)projectile.getX();
			int yy = (int)projectile.getY();
			g.setColor(Color.lightGray);
			g.drawLine(x+2, -600, x+2, 0);
			g.setColor(Color.RED);
			g.drawOval(x, -y, 10, 10);
			g.fillOval(x, -y, 10, 10);
			g.setColor(Color.GRAY);
			g.drawLine(x, -y, xx, -yy );
			
		
		}
		g.translate(50, 400);
		projectile.setAngle(40);
		projectile.setVelocity(88);						
		for(int ix = 0; ix < 5; ix++) {
			
			projectile.setTime(ix-.5);
			int x = (int)projectile.getX();
			int y = (int)projectile.getY();
			
			projectile.setTime(ix+.5);
			int xx = (int)projectile.getX();
			int yy = (int)projectile.getY();
			g.setColor(Color.green);
			g.drawOval(x, -y, 10, 10);
			g.fillOval(x, -y, 10, 10);
			g.setColor(Color.DARK_GRAY);
			g.drawLine(x, -y, xx, -yy );
			g.setColor(Color.GRAY);
			g.drawLine(x+2, -200, x+2, 50);
			
			projectile.setTime(ix);
			x = (int)projectile.getX();
			y = (int)projectile.getY();
			projectile.setTime(ix+.5);
			xx = (int)projectile.getX();
			yy = (int)projectile.getY();
			g.setColor(Color.green);
			g.drawOval(x, -y, 10, 10);
			g.fillOval(x, -y, 10, 10);
			g.setColor(Color.DARK_GRAY);
			g.drawLine(x, -y, xx, -yy );
			g.setColor(Color.GRAY);
			g.drawLine(x+2, -200, x+2, 50);		
		}
		
		g.translate(170, -75);
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(220, -250, 570, 420);
		projectile.setAngle(44);
		projectile.setVelocity(75);
		for(int ix = 5; ix < 15; ++ix) {
			projectile.setTime(ix+1);
			int xx = (int)projectile.getX();
			int yy = (int)projectile.getY();
			projectile.setTime(ix);
			int x = (int)projectile.getX();
			int y = (int)projectile.getY();
			g.setColor(Color.black);
			g.drawOval(x, -y, 10, 10);
			g.fillOval(x, -y, 10, 10);
			if (ix < 13) {
				g.setColor(Color.RED);
				g.drawLine(x, -y, xx, -yy);
			}			
			g.setColor(Color.DARK_GRAY);
			g.drawLine(x+2, -250, x+2, 170);	
			
			
			
		}
		
	
		 }
	
	public void actionPerformed(ActionEvent e) {
		
	}
}
