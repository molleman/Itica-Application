package com.itica.android;

/*
Apparently geocoder is not working with the Emulated android.  This is a workaround.

Here is how I implemented it:
 
try {
	possibleAddresses = g.getFromLocation(location.getLatitude(), location.getLongitude(), 3);
} catch (IOException e) {
	if("sdk".equals( Build.PRODUCT )) {
		Log.d(TAG, "Geocoder doesn't work under emulation.");
		possibleAddresses = ReverseGeocode.getFromLocation(location.getLatitude(), location.getLongitude(), 3);
	} else
		e.printStackTrace();
}

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.location.Address;
import android.util.Log;

public class ReverseGeocode {

    public static List<Address> getFromLocation(String address,String county, int maxResults) {
    	String modAddress= address.replace(" ", "%20");
    	String modCounty = county.replace(" ", "%20");
    	
    	String urlStr = "http://maps.google.com/maps/geo?q=" + modAddress + "," + modCounty + "&output=json&sensor=false";
		String response = "";
		List<Address> results = new ArrayList<Address>();
		HttpClient client = new DefaultHttpClient();
		
		
		Log.d("ReverseGeocode", urlStr);
		try {
			HttpResponse hr = client.execute(new HttpGet(urlStr));
			
			HttpEntity entity = hr.getEntity();

			BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent()));

			String buff = null;
			while ((buff = br.readLine()) != null)
				response += buff;
		} catch (IOException e) {
			e.printStackTrace();
		}

		JSONArray responseArray = null;
		try {
			JSONObject jsonObject = new JSONObject(response);
			responseArray = jsonObject.getJSONArray("Placemark");
		} catch (JSONException e) {
			return results;
		}

		Log.d("ReverseGeocode", "" + responseArray.length() + " result(s)");
		
		for(int i = 0; i < responseArray.length() && i < maxResults-1; i++) {
			Address addy = new Address(Locale.getDefault());

			
			try {
				JSONObject jsl = responseArray.getJSONObject(i);

				
				
				String addressLine = jsl.getString("address");

				if(addressLine.contains(","))
					addressLine = addressLine.split(",")[0];

				addy.setAddressLine(0, addressLine);

				JSONArray co = jsl.getJSONObject("Point").getJSONArray("coordinates");
				addy.setLatitude(co.getDouble(1));
				addy.setLongitude(co.getDouble(0));
				
				
				jsl = jsl.getJSONObject("AddressDetails").getJSONObject("Country");
				addy.setCountryName(jsl.getString("CountryName"));
				addy.setCountryCode(jsl.getString("CountryNameCode"));

				//jsl = jsl.getJSONObject("AdministrativeArea");
				//addy.setAdminArea(jsl.getString("AdministrativeAreaName"));

				jsl = jsl.getJSONObject("SubAdministrativeArea");
				addy.setSubAdminArea(jsl.getString("SubAdministrativeAreaName"));

				//jsl = jsl.getJSONObject("Locality");
				//addy.setLocality(jsl.getString("LocalityName"));

				//addy.setPostalCode(jsl.getJSONObject("PostalCode").getString("PostalCodeNumber"));
				//addy.setThoroughfare(jsl.getJSONObject("Thoroughfare").getString("ThoroughfareName"));

			} catch (JSONException e) {
				e.printStackTrace();
				continue;
			}
			Log.d("ReverseGeocode", "" + addy.getLocality());
			results.add(addy);
		}

		return results;
	}
}