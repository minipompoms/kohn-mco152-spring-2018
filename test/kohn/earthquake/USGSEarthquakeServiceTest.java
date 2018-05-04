package kohn.earthquake;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import kohn.earthquake.net.EarthquakeController;
import kohn.earthquake.net.USGSEarthquakeService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class USGSEarthquakeServiceTest {

	@Test
	public void testGetAllMonth() throws IOException {
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://earthquake.usgs.gov")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		
		USGSEarthquakeService service = retrofit.create(USGSEarthquakeService.class);
		Call<EarthquakeFeedModel>call = service.getData("month");
		
		Response <EarthquakeFeedModel>response = call.execute();
		assertNotNull(response.body());

		List<Earthquake> features = response.body().getFeatures();
		assertTrue(features.size() >0);

		EarthquakeProperties properties = features.get(0).getProperties();
		assertNotNull(properties.getPlace());
		
	}

}
