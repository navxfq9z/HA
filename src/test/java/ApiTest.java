import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.HttpUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by navaneeth.basavaraj on 7/9/2016.
 */
public class ApiTest extends HttpUtil {

	static final String GET_NASA_EARTH_IMAGERY = "https://api.nasa.gov/planetary/earth/imagery";
	static final String GET_FUEL_STATIONS = "https://developer.nrel.gov/api/alt-fuel-stations/v1/nearest";
	static final String GET_FUEL_STATION_BY_ID = "https://developer.nrel.gov/api/alt-fuel-stations/v1/STATION_ID";

	@Test
	public void getEarthImagery() throws Exception{
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("format","json"));
		params.add(new BasicNameValuePair("location","Austin,%20Texas"));
		params.add(new BasicNameValuePair("ev_network","ChargePoint%20Network"));
		params.add(new BasicNameValuePair("api_key","hE4Q9F4DB0GncEvafOF4kr4EZ3m778SNscDoa4nb"));

		String uri = createRequest(params, GET_FUEL_STATIONS);
		System.out.println(uri);

		String response = get(uri);

		JSONObject object = new JSONObject(response);
		JSONArray stations = object.getJSONArray("fuel_stations");

		String stationID = null;
		for(int i=0; i < stations.length(); i++){
			JSONObject station = stations.getJSONObject(i);
			if(station.get("station_name").equals("HYATT AUSTIN")){
				stationID = station.get("id").toString();
				System.out.println("HYATT AUSTIN Station Id:" + stationID);
			}
		}

		params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("api_key","hE4Q9F4DB0GncEvafOF4kr4EZ3m778SNscDoa4nb"));
		//params.add(new BasicNameValuePair("id",stationID));
		params.add(new BasicNameValuePair("format","json"));

		uri = createRequest(params, GET_FUEL_STATION_BY_ID.replace("STATION_ID", stationID));
		System.out.println(uri);
		response = get(uri);
		System.out.println(response);
		object = new JSONObject(response).getJSONObject("alt_fuel_station");
		Assert.assertEquals(object.getString("street_address") + ", "
				+ object.get("city").toString() + ", "
				+ object.get("state").toString() + ", "
				+ object.get("zip").toString(), "208 Barton Springs Rd, Austin, TX, 78704", "Address mismatch!");


	}

}
