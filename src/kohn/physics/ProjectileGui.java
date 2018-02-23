package kohn.physics;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ProjectileGui extends JFrame{
	
	private JTextField textField;
	public ProjectileGui() {
		
		setTitle("Projectile Viewer");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//component is superclass of all UI elements
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

		JPanel northPanel = new JPanel();
		northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
		northPanel.add(new JLabel ("Hello World\n"));
		northPanel.add(new JLabel ("GoodBye World"));
		panel.add(northPanel, BorderLayout.NORTH);

		textField = new JTextField("Text Field");
		panel.add(textField, BorderLayout.WEST);

		
		JButton button = new JButton("Button");
		button.addActionListener(this::changeTextField);
		
		
			
		panel.add(button, BorderLayout.CENTER);
		panel.add(new JLabel("Can we take a break?"), BorderLayout.SOUTH);
		
		add(panel);
	}
	
	
	public void changeTextField(ActionEvent event) {
		textField.setText("Action Performed");
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
