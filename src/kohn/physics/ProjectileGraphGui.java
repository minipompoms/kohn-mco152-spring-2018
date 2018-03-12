package kohn.physics;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ProjectileGraphGui extends JFrame{

	public ProjectileGraphGui(){
		//hw 2: draw the coordinates(string)
		
		//hw 5: projectile image
		
		setTitle("Projectile Viewer");
		setSize(1350, 1000);
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
