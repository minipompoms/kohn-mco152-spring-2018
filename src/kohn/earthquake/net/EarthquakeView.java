package kohn.earthquake.net;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@SuppressWarnings("serial")
public class EarthquakeView extends JFrame implements ActionListener {
	//rename GUI to EarthquakeView
	//Create class EarthquakeControler
	
	private JFormattedTextField hourlyMag;
	private JFormattedTextField monthlyMag;
	private JFormattedTextField weeklyMag;
	private JFormattedTextField dailyMag;

	private JFormattedTextField monthlyLoc;
	private JFormattedTextField weeklyLoc;

	String month = "all_month.geojson";
	String day = "all_day.geojson";
	String week = "all_week.geojson";
	String hour = "all_hour.geojson";

	
	public EarthquakeView() {


		JPanel labelPane = new JPanel(new GridLayout(0, 1));
		labelPane.add(new JLabel("Last Hour:"));
		labelPane.add(new JLabel("Last 24 Hours:"));
		labelPane.add(new JLabel("Last Week:"));
		labelPane.add(new JLabel("Last Month:"));

		JPanel magPane = new JPanel(new GridLayout(0, 1));
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
		Retrofit retrofit = new Retrofit.Builder().baseUrl("https://earthquake.usgs.gov")
				.addConverterFactory(GsonConverterFactory.create()).build();

		USGSEarthquakeService service = retrofit.create(USGSEarthquakeService.class);
		EarthquakeController controller = new EarthquakeController(this, service);

		controller.refreshData();


	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
	
	public JTextComponent getWeekMagTextField() {
		return weeklyMag;
	}

	public JTextComponent getWeekLocTextField() {
		return weeklyLoc;
	}
	public JTextComponent getMonthMagTextField() {
		return monthlyMag;
	}

	public JTextComponent getMonthLocTextField() {
		return monthlyLoc;
	}

	public static void main(String args[]) {

		new EarthquakeView().setVisible(true);

	}

	
}
