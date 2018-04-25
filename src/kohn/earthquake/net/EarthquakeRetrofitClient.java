package kohn.earthquake.net;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

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

		Call<EarthquakeFeed> call = service.getData(month);
	
		call.enqueue(new Callback<EarthquakeFeed>() {

			@Override
			public void onResponse(Call<EarthquakeFeed> call, Response<EarthquakeFeed> response) {
				EarthquakeFeed feed = response.body();
				int maxIndex = getMax(call, response);

				double magnitude = feed.getFeatures().get(maxIndex).getProperties().getMag();
				String place = feed.getFeatures().get(maxIndex).getProperties().getPlace();
				System.out.println('\n'+"MAG: "+magnitude+'\t'+place );
			}
	

			@Override
			public void onFailure(Call<EarthquakeFeed> call, Throwable t) {
				t.getMessage();

			}

		});
		
		call = service.getData(week);
		call.enqueue(new Callback<EarthquakeFeed>() {
		@Override
		public void onResponse(Call<EarthquakeFeed> call, Response<EarthquakeFeed> response) {
			EarthquakeFeed feed = response.body();
			int maxIndex = getMax(call, response);

			double magnitude = feed.getFeatures().get(maxIndex).getProperties().getMag();
			String place = feed.getFeatures().get(maxIndex).getProperties().getPlace();
			System.out.println('\n'+"MAG: "+magnitude+'\t'+place );
		}


		@Override
		public void onFailure(Call<EarthquakeFeed> call, Throwable t) {
			t.getMessage();

		}

	});
		call = service.getData(day);
		call.enqueue(new Callback<EarthquakeFeed>() {
		@Override
		public void onResponse(Call<EarthquakeFeed> call, Response<EarthquakeFeed> response) {
			EarthquakeFeed feed = response.body();
			int maxIndex = getMax(call, response);

			double magnitude = feed.getFeatures().get(maxIndex).getProperties().getMag();
			String place = feed.getFeatures().get(maxIndex).getProperties().getPlace();
			System.out.println('\n'+"MAG: "+magnitude+'\t'+place );
		}


		@Override
		public void onFailure(Call<EarthquakeFeed> call, Throwable t) {
			t.getMessage();

		}

	});
		
		call = service.getData(hour);
		call.enqueue(new Callback<EarthquakeFeed>() {
		@Override
		public void onResponse(Call<EarthquakeFeed> call, Response<EarthquakeFeed> response) {
			EarthquakeFeed feed = response.body();
			int maxIndex = getMax(call, response);

			double magnitude = feed.getFeatures().get(maxIndex).getProperties().getMag();
			String place = feed.getFeatures().get(maxIndex).getProperties().getPlace();
			System.out.println('\n'+"MAG: "+magnitude+'\t'+place );
		}


		@Override
		public void onFailure(Call<EarthquakeFeed> call, Throwable t) {
			t.getMessage();

		}

	});

		/*callM.enqueue(new Callback<EarthquakeFeed>() {

			@Override
			public void onResponse(Call<EarthquakeFeed> call, Response<EarthquakeFeed> response) {

				EarthquakeFeed feed = response.body();
				// System.out.println(feed.getFeatures().stream().filter(e ->
				// e.getProperties().getMag() >= 5).count());

				// do not add in GUI
			}

			@Override
			public void onFailure(Call<EarthquakeFeed> call, Throwable t) {
				t.printStackTrace();
			}

		});*/

	}
	
	
	
	public static int getMax(Call<EarthquakeFeed> call, Response<EarthquakeFeed> response) {
		EarthquakeFeed feed = response.body();
		int index = 0;
		int maxIndex = 0;
		double max = 0;
		while (index < feed.getFeatures().size()) {
			if (feed.getFeatures().get(index).getProperties().getMag() > max) {
				max = feed.getFeatures().get(index).getProperties().getMag();
				maxIndex = index;
			}
			index++;
		}
		return maxIndex;
	}
}
