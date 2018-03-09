package kohn.physics;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ProjectileGraphGui extends JFrame{

	public ProjectileGraphGui(){
		
		setTitle("Projectile Viewer");
		setSize(800, 600);
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
