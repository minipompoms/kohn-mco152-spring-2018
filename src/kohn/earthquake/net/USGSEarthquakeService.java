package kohn.earthquake.net;


import kohn.earthquake.EarthquakeFeed;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface USGSEarthquakeService {
	
	
	@GET("/earthquakes/feed/v1.0/summary/{range}")
	Call<EarthquakeFeed> getData(@Path("range") String month);
	
	
	

	
	
}
