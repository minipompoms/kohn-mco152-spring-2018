package kohn.physics;

import java.awt.BorderLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ProjectileGraphGui extends JFrame{

	public ProjectileGraphGui(){
		
		
		setTitle("Projectile Viewer");
		setSize(800, 615);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(340,90);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		panel.add(new ProjectileGraph(), BorderLayout.CENTER);
		
		
		setContentPane(panel);
	}
	
	public static void main(String args[]) {
		new ProjectileGraphGui().setVisible(true);
	}
}
