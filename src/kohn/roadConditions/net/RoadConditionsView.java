package kohn.roadConditions.net;

import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

public class RoadConditionsView {

	private JTextField highLatLng;
	private JTextField lowLatLng;
	
	private JTextField roadConditions;
	
	public RoadConditionsView() {
		
	}
	
	public String getHighLatLng() {
		return highLatLng.getText();
	}
	
	public String getLowLatLng() {
		return lowLatLng.getText();
	}
	
	public JTextComponent getRoadConditions() {
		return roadConditions;
	}
}
