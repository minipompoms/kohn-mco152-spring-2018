package kohn.earthquake;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import org.junit.Test;
import org.mockito.Mockito;

import kohn.earthquake.net.EarthquakeController;
import kohn.earthquake.net.EarthquakeView;
import kohn.earthquake.net.USGSEarthquakeService;
import retrofit2.Call;

public class EarthquakeControllerTest {
	//integrated test -
//tests your code integrated with something else
	//unit test -
//tests one class	
	@Test
	public void testRequestMonth() {
		//given
		EarthquakeView view = Mockito.mock(EarthquakeView.class);
		USGSEarthquakeService service = Mockito.mock(USGSEarthquakeService.class);
		EarthquakeController controller = new EarthquakeController(view, service);
		Call<EarthquakeFeedModel> call = Mockito.mock(Call.class);
		Mockito.when(service.getData("month")).thenReturn(call);
		JTextField field  = Mockito.mock(JTextField.class);
		Mockito.when(view.getLastMonthTextField()).thenReturn(field);
		//when
		controller.requestMonth();
		
		//then
		assertFalse(view.getLastWeekTextField().getText().equals(""));
	}
	
	@Test
	public void testShowLargestEarthquake() {
		EarthquakeView view = Mockito.mock(EarthquakeView.class);
		USGSEarthquakeService service = Mockito.mock(USGSEarthquakeService.class);
		EarthquakeController controller = new EarthquakeController(view, service);
		JTextField largestEQ = Mockito.mock(JTextField.class);
		List<Earthquake> list = new ArrayList<Earthquake>();
		list.add(new Earthquake(2.2, "Paia, Hawaii", 1));
		list.add(new Earthquake(5.1, "Death Valley, California", 2));
		list.add(new Earthquake(4.8, "Honolulu, Hawaii", 3));
		
		EarthquakeFeedModel model = new EarthquakeFeedModel(list, "");

		controller.showLargestEarthquake(largestEQ, model);
		
		Mockito.verify(largestEQ).setText("5.1 Death Valley, California");
	}

}
