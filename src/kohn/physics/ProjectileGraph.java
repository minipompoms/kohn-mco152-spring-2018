package kohn.physics;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class ProjectileGraph extends JComponent {
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Projectile projectile = new Projectile(42, 99);					
		Font subScript = new Font("Courier", Font.PLAIN, 9);
		g.setFont(subScript);
		
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
			g.drawString("("+x+", "+y+")", x, -y); 
			g.setColor(Color.RED);
			g.fillOval(x, -y, 10, 10);
			if(ix < 9) {
				g.setColor(Color.GRAY);
				g.drawLine(x, -y, xx, -yy );
			}
		}
	
		g.translate(50, 300);
		
		projectile.setAngle(40);
		projectile.setVelocity(88);						
		for(int ix = 0; ix < 5; ix++) {
			
			projectile.setTime(ix-.5);
			int x = (int)projectile.getX();
			int y = (int)projectile.getY();
			
			projectile.setTime(ix+.5);
			int xx = (int)projectile.getX();
			int yy = (int)projectile.getY();
			g.setColor(Color.black);
			g.drawString("("+x+", "+y+")", x, -y);
			g.setColor(Color.green);
			g.fillOval(x, -y, 7, 7);
			g.setColor(Color.lightGray);
			g.drawLine(x, -y, xx, -yy );
			g.setColor(Color.GRAY);
			g.drawLine(x+2, -200, x+2, 50);
			 

			projectile.setTime(ix);
			x = (int)projectile.getX();
			y = (int)projectile.getY();
			projectile.setTime(ix+.5);
			xx = (int)projectile.getX();
			yy = (int)projectile.getY();
			g.setColor(Color.black);		
			g.drawString("("+x+", "+y+")", x, -y); 
			g.setColor(Color.green);
			g.fillOval(x, -y, 7, 7);
			g.setColor(Color.LIGHT_GRAY);
			g.drawLine(x, -y, xx, -yy );
			g.setColor(Color.GRAY);
			g.drawLine(x+2, -200, x+2, 50);	
			
		}
		
		g.translate(170, -30);
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(230, -250, 580, 495);
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
			g.fillOval(x, -y, 8, 8);
			if (ix < 14) {
				g.setColor(Color.RED);
				g.drawLine(x, -y, xx, -yy);
			}			
			g.setColor(Color.DARK_GRAY);
			g.drawLine(x+2, -250, x+2, 243);	
			g.drawString("("+x+", "+y+")", x, -y); 

		}
		
	
		 }
	
}
