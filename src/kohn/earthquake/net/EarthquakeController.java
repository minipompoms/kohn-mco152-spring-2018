package kohn.earthquake.net;

import java.util.Comparator;
import java.util.Optional;

import javax.swing.text.JTextComponent;

import kohn.earthquake.Earthquake;
import kohn.earthquake.EarthquakeFeed;
import kohn.earthquake.EarthquakeProperties;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EarthquakeController {
	private EarthquakeView view;
	private USGSEarthquakeService service;
	
	
	String month = "all_month.geojson";
	String day = "all_day.geojson";
	String week = "all_week.geojson";
	String hour = "all_hour.geojson";

	public EarthquakeController(EarthquakeView view, USGSEarthquakeService service) {
		this.view = view;
		this.service = service;
	}


	public void refreshData() {
		requestHour();	
		requestDay();
		requestWeek();
		requestMonth();
	}


	private void requestEarthquakeFeed(Call<EarthquakeFeed>call,
			JTextComponent largestField) {	
		
		call.enqueue(new Callback<EarthquakeFeed>() {

			@Override
			public void onResponse(Call<EarthquakeFeed> call, Response<EarthquakeFeed> response) {
				EarthquakeFeed feed = response.body();
				Optional<Earthquake> largest = feed.getFeatures()
						.stream() //put this in earthquakefeed
						.max(Comparator.comparing(e -> e.getProperties().getMag()));
				
				EarthquakeProperties properties = largest.get().getProperties();
				
				String largestEQ = String.valueOf(properties.getMag()+" "+properties.getPlace());
				largestField.setText(largestEQ);				
			}

			@Override
			public void onFailure(Call<EarthquakeFeed> call, Throwable t) {
				t.printStackTrace();
			}
		});
	}
	public void requestHour()
	{
		requestEarthquakeFeed(service.getData(hour),
				view.getLastHourTextField());
	}
	public void requestDay()
	{
		requestEarthquakeFeed(service.getData(day),
				view.getLastDayTextField());
	}
	
	public void requestWeek()
	{
		requestEarthquakeFeed(service.getData(week),
				view.getLastWeekTextField());
	}
	public void requestMonth()
	{
		requestEarthquakeFeed(service.getData(month),
				view.getLastMonthTextField());
	}
	
}
