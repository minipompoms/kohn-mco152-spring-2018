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
	
	Call<EarthquakeFeed> call = service.getData(hour);

	public EarthquakeController(EarthquakeView view, USGSEarthquakeService service) {
		this.view = view;
		this.service = service;
	}
	
	public void refreshData() {
		requestEarthquakeFeed(service.getData(month), 
				view.getMonthMagTextField(), 
				view.getMonthLocTextField());
	}

	private void requestEarthquakeFeed(Call<EarthquakeFeed>call,
			JTextComponent magnitudeField,
			JTextComponent locationField) {		
		call.enqueue(new Callback<EarthquakeFeed>() {

			@Override
			public void onResponse(Call<EarthquakeFeed> call, Response<EarthquakeFeed> response) {
				EarthquakeFeed feed = response.body();
				Optional<Earthquake> largest = feed.getFeatures()
						.stream() //put this in earthquakefeed
						.max(Comparator.comparing(e -> e.getProperties().getMag()));
				EarthquakeProperties properties = largest.get().getProperties();
				
				String magnitude = String.valueOf(properties.getMag());
				view.getMonthMagTextField().setText(magnitude);
				String location = String.valueOf(properties.getPlace());
				view.getMonthLocTextField().setText(location);

			}

			@Override
			public void onFailure(Call<EarthquakeFeed> call, Throwable t) {
				t.printStackTrace();
			}
		});
	}
}
