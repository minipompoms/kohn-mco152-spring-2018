package kohn.roadConditions.net;

import kohn.roadConditions.RoadConditionsFeed;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface MogolRoadConditionsService {
	
	@Headers({
		 "x-api-key", "{rsSl0syd6E5vhOHSEnCDc2Wt4sXCUtHT39IAXCAb}"
	})
	
	@GET("/conditions/region/{highLatLng}/{lowLatLng}\" -H \"x-api-key: {api key}")
	Call<RoadConditionsFeed>getData(@Path("highLatLng")String highLatLng, @Path("lowLatLng") String lowLatLng);
}

	
	

