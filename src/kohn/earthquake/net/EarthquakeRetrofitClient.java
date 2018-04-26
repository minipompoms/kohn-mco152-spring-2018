package kohn.earthquake.net;

import java.io.IOException;

import java.util.Comparator;
import java.util.Optional;

import kohn.earthquake.Earthquake;
import kohn.earthquake.EarthquakeFeed;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EarthquakeRetrofitClient {
	


	public static void main(String[] args) throws IOException {
		String month = "all_month.geojson";
		String day = "all_day.geojson";
		String week = "all_week.geojson";
		String hour = "all_hour.geojson";


		Retrofit retrofit = new Retrofit.Builder().baseUrl("https://earthquake.usgs.gov")
				.addConverterFactory(GsonConverterFactory.create()).build();

		USGSEarthquakeService service = retrofit.create(USGSEarthquakeService.class);
		
		Call<EarthquakeFeed> call = service.getData(hour);
		call.enqueue(new Callback<EarthquakeFeed>() {

            @Override
            public void onResponse(Call<EarthquakeFeed> call, Response<EarthquakeFeed> response) {
                    EarthquakeFeed feed = response.body();
                    Optional<Earthquake> maxHour = feed.getFeatures()
                    		.stream()
                    		.max(Comparator.comparing(e -> e.getProperties().getMag()));
					System.out.print(maxHour.get().getProperties().getMag()+"\t");		
					System.out.println(maxHour.get().getProperties().getPlace());		
            }           
            @Override
            public void onFailure(Call<EarthquakeFeed> call, Throwable t) {
                    t.printStackTrace();
            }
    });

		call = service.getData(month);
		call.enqueue(new Callback<EarthquakeFeed>() {

            @Override
            public void onResponse(Call<EarthquakeFeed> call, Response<EarthquakeFeed> response) {
                    EarthquakeFeed feed = response.body();
                    Optional<Earthquake> maxMonth = feed.getFeatures()
                    		.stream()
                    		.max(Comparator.comparing(e -> e.getProperties().getMag()));
					System.out.print(maxMonth.get().getProperties().getMag()+"\t");		
					System.out.println(maxMonth.get().getProperties().getPlace());		
            }           
            @Override
            public void onFailure(Call<EarthquakeFeed> call, Throwable t) {
                    t.printStackTrace();
            }
    });
		
		call = service.getData(week);
		call.enqueue(new Callback<EarthquakeFeed>() {

            @Override
            public void onResponse(Call<EarthquakeFeed> call, Response<EarthquakeFeed> response) {
                    EarthquakeFeed feed = response.body();
                    Optional<Earthquake> maxWeek = feed.getFeatures()
                    		.stream()
                    		.max(Comparator.comparing(e -> e.getProperties().getMag()));
					System.out.print(maxWeek.get().getProperties().getMag()+"\t");		
					System.out.println(maxWeek.get().getProperties().getPlace());		
            }           
            @Override
            public void onFailure(Call<EarthquakeFeed> call, Throwable t) {
                    t.printStackTrace();
            }
    });
		
		
		call = service.getData(day);
		call.enqueue(new Callback<EarthquakeFeed>() {

            @Override
            public void onResponse(Call<EarthquakeFeed> call, Response<EarthquakeFeed> response) {
                    EarthquakeFeed feed = response.body();
                    Optional<Earthquake> maxDay = feed.getFeatures()
                    		.stream()
                    		.max(Comparator.comparing(e -> e.getProperties().getMag()));
					System.out.print(maxDay.get().getProperties().getMag()+"\t");		
					System.out.println(maxDay.get().getProperties().getPlace());		
            }           
            @Override
            public void onFailure(Call<EarthquakeFeed> call, Throwable t) {
                    t.printStackTrace();
            }
    });
		
	}

}
