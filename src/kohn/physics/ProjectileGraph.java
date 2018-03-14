package kohn.physics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;


@SuppressWarnings("serial")
public class ProjectileGraph extends JComponent {
	
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Font subScript = new Font("Courier", Font.PLAIN, 9);
		g.setFont(subScript);
		g.translate(60, 500);
		
		int[]a = {36, 49, 42};
		int [] v = {77, 109, 86};				
		int x, y;
		int count= 0;
		BufferedImage ball = null;		
		try {
			 ball = ImageIO.read(new File("src/Tennis_Ball.png"));						
		}catch(IOException e2) {
			e2.printStackTrace();
		}
        Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.GREEN);
	    BasicStroke wideStroke = new BasicStroke(1.5f);
		g2.setStroke(wideStroke);

		g2.draw3DRect(-30, -500, 750, 550, false);
		
		while(count <3) {
			Projectile projectile = new Projectile(a[count], v[count]);	
			
			for(int ix = 0; ix < 10; ++ix) {
				
				projectile.setTime(ix);
				 x = (int)projectile.getX();
				 y = (int)projectile.getY();
				 if(projectile.getAngle()== a[1]) {
						g.setColor(Color.lightGray);				
						g.drawLine(x+2, -700, x+2, 50);
					} 
				
				g.drawImage(ball, x,-y, null);
				projectile.setTime(ix+1);
				int xx = (int)projectile.getX();
				int yy = (int)projectile.getY();
				g.setColor(Color.lightGray);				
				g.drawString("("+x+", "+y+")", x, -y); 
				
				if(ix < 9) {
					g.setColor(Color.GRAY);
					g.drawLine(x, -y, xx, -yy );
				}
			}
			
			count++;
			
		}
		
		 }
	
	
}

