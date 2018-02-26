package kohn.physics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;


public class ProjectileGui extends JFrame{
	
	private JTextField textField;
	public ProjectileGui() {
		
	
		
		
		JPanel pane = new JPanel();	
	
		
		
		
		
		//button.addActionListener(this::changeTextField);		
		//component is superclass of all UI elements
		//panel.setLayout(new GridLayout());
		//panel.setLayout(new BorderLayout());
		//JPanel panel = new JPanel();
		//JButton button = new JButton("Calculate:"); //supposed to do on auto
		//panel.add(button, BorderLayout.CENTER);
		//panel.add(new JLabel (" Angle "));
		//panel.add(pane, BorderLayout.NORTH);
		//panel.add(new JLabel("Can we take a break?"), BorderLayout.SOUTH);
		
		addComponentsToPane(pane);
	}
	 public void addComponentsToPane(Container pane) {
		 
		setTitle("Projectile Viewer");
		setSize(200, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pane.setLayout(new GridLayout(6, 6));
		pane.setBackground(Color.BLACK);
		pane.setBounds(6, 8, 2, 2);
		//pane.setLayout(new BoxLayout(pane, BoxLayout.X_AXIS));
		String a = "25";
		String v = "30";
		String t = "1:00";
		String x = "";
		String y = "";
		addAButton(" Angle ", pane);
		addAField(a, pane);
		addAButton(" Velocity ", pane);		
		addAField(v, pane);
		addAButton(" Time ", pane);
		addAField(t, pane);
		addAField("Coordinates", pane);
		addAField("", pane);

		addAButton("  X  ", pane);
		addAField(x, pane);
		addAButton("  Y  ", pane);
		addAField(y, pane);
        
		add(pane);
	
			
	 }
	
	private static void addAField(String value, Container pane) {
		
        JTextField numberField = new JTextField(value);		
        //numberField.setAlignmentY( Component.RIGHT_ALIGNMENT);
        pane.add(numberField);
    }
	
	private static void addAButton(String text, Container container) {
        JButton button = new JButton(text);
        Dimension buttonSize = button.getPreferredSize();
       
        container.add(button);
    }
	
	public void changeTextField(ActionEvent event) {
		textField.setText("Action Performed");
	}
	
	public static void main (String args[]) {
		new ProjectileGui().setVisible(true);
	}
	
	/*private void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("BoxLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Set up the content pane.
        addComponentsToPane(frame.getContentPane());
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }*/

	
	
	
	
}
