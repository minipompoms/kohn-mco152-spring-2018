package kohn.earthquake.net;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class EarthquakeGUI extends JFrame implements ActionListener{
	
	private JFormattedTextField  hourlyMag;
	private JFormattedTextField monthlyMag;
	private JFormattedTextField  weeklyMag;
	private JFormattedTextField  dailyMag;
	
	String month = "all_month.geojson";
	String day = "all_day.geojson";
	String week = "all_week.geojson";
	String hour = "all_hour.geojson";
	
	
	EarthquakeRetrofitClient earthquakeClient;
	
	
	public EarthquakeGUI(){

		JPanel labelPane = new JPanel(new GridLayout(0, 1));
		labelPane.add(new JButton("Last Hour:"));
		labelPane.add(new JButton("Last 24 Hours:"));
		labelPane.add(new JButton("Last Week:"));
		labelPane.add(new JButton("Last Month:"));
	
		
		
		
		JPanel magPane = new JPanel(new GridLayout(0,1));
		magPane.add(new JFormattedTextField(hourlyMag));
		magPane.add(new JFormattedTextField(dailyMag));
		magPane.add(new JFormattedTextField(weeklyMag));
		monthlyMag = new JFormattedTextField();
		monthlyMag.setColumns(12);
		magPane.add(monthlyMag);

		
		Border border = BorderFactory.createEmptyBorder(20, 20, 20, 20);
		setTitle("Earthquake Feed");
		labelPane.setBorder(border);
		magPane.setBorder(border);
		
		add(labelPane, BorderLayout.LINE_START);
		
		add(magPane, BorderLayout.LINE_END);
		setLocation(540, 320);
		setSize(540, 200);


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		EarthquakeRetrofitClient eq = new EarthquakeRetrofitClient();
		
		
	}
	public static void main(String args[]) {

		new EarthquakeGUI().setVisible(true);;

		
	}
}
