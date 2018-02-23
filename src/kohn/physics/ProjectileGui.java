package kohn.physics;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ProjectileGui extends JFrame{
	
	public ProjectileGui() {
		
		setTitle("Projectile Viewer");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//component is superclass of all UI elements
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		JPanel northPanel = new JPanel();
		northPanel.add(new JLabel ("Hello World"));
		northPanel.add(new JLabel ("GoodBye World"));
		panel.add(northPanel, BorderLayout.NORTH);

		JTextField textField = new JTextField("Text Field");
		panel.add(textField, BorderLayout.WEST);

		
		JButton button = new JButton("Button");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textField.setText("Action Performed");
		}
		});
		
		panel.add(button, BorderLayout.CENTER);
		panel.add(new JLabel("Can we take a break?"), BorderLayout.SOUTH);
		
		add(panel);
	}
	
	public static void main (String args[]) {
		new ProjectileGui().setVisible(true);
	}
	
	//JFRAME
	//JLABEL
	//JTEXTFIELD
	//BUTTON
	
	
	//JPANEL - THIS can contain other components such as label and button & another jpanel
	//which can create more buttons etc
	
	//inheritence
	//polymorphism
	//abstraction
	//
}
