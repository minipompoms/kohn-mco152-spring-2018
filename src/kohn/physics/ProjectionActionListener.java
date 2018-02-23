package kohn.physics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class ProjectionActionListener implements ActionListener {

	private JTextField textField;
	
	public ProjectionActionListener(JTextField textField) {
		this.textField = textField;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		textField.setText("Action Performed");
	}

}
