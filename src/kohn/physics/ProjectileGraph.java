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
		g.translate(50, 450);
		Projectile p2 = new Projectile(40, 132);
						
		for(int ix = 0; ix < 5; ix++) {
			
			p2.setTime(ix-.5);
			int x = (int)p2.getX();
			int y = (int)p2.getY();
			
			p2.setTime(ix+.5);
			int xx = (int)p2.getX();
			int yy = (int)p2.getY();
			g.setColor(Color.green);
			g.drawOval(x, -y, 10, 10);
			g.fillOval(x, -y, 10, 10);
			g.setColor(Color.DARK_GRAY);
			g.drawLine(x, -y, xx, -yy );
			g.setColor(Color.GRAY);
			g.drawLine(x+2, -375, x+2, 50);
			
			p2.setTime(ix);
			x = (int)p2.getX();
			y = (int)p2.getY();
			p2.setTime(ix+.5);
			xx = (int)p2.getX();
			yy = (int)p2.getY();
			g.setColor(Color.green);
			g.drawOval(x, -y, 10, 10);
			g.fillOval(x, -y, 10, 10);
			g.setColor(Color.DARK_GRAY);
			g.drawLine(x, -y, xx, -yy );
			g.setColor(Color.GRAY);
			g.drawLine(x+2, -375, x+2, 50);
			
			
			
		}
		
		
		
		
	
		 }
	
	public void actionPerformed(ActionEvent e) {
		
	}
}
