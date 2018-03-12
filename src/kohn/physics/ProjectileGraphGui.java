package kohn.physics;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ProjectileGraphGui extends JFrame{

	public ProjectileGraphGui(){
		//hw 2: draw the coordinates(string)
		
		//hw 5: projectile image
		//hw 6: multiple projectiles, 3 with different color lines, different numbers
		setTitle("Projectile Viewer");
		setSize(1000, 1500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		
		panel.add(new ProjectileGraph(), BorderLayout.CENTER);
		
		setContentPane(panel);
	}
	
	public static void main(String args[]) {
		new ProjectileGraphGui().setVisible(true);
	}
}
