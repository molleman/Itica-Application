package com.itica.android;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class ChipperInfoActivity extends MapActivity {

	MapView mapView;
	
	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.chipper_info);
	    setUpViews();	
	   
	   
	
	}
	
	public void setUpViews(){
		IticaManagerApplication ima = (IticaManagerApplication)getApplication();
		final Chipper chipper = ima.getCurrentChipper();
		
		TextView nameText = (TextView)findViewById(R.id.name_textview);
		nameText.setText(chipper.getName());
		
		TextView addressText = (TextView)findViewById(R.id.address_textview);
		addressText.setText(chipper.getAddress());
		
		TextView countyText = (TextView)findViewById(R.id.county_textview);
		countyText.setText(chipper.getCounty());
		
		 Button button = (Button)findViewById(R.id.infoActivityButton);
		 mapView = (MapView) findViewById(R.id.mapview);
		 mapView.setBuiltInZoomControls(true);
		 
		 button.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View arg0) {
				//ReverseGeocode rgc = new ReverseGeocode();
				
				
			    //Geocoder gc = new Geocoder(ChipperInfoActivity.this);
			    
			    //List<Address> foundAdresses = gc.getFromLocationName("ballymun road, dublin, ireland",1);
				double lat;
				double lng;
				if(chipper.getMapAddress() == null){
					List<Address> foundAdresses = ReverseGeocode.getFromLocation(chipper.getAddress(),chipper.getCounty(),2);
					chipper.setMapAddress(foundAdresses.get(0));
					lat = chipper.getMapAddress().getLatitude();
					lng = chipper.getMapAddress().getLongitude();
				}else{
					lat = chipper.getMapAddress().getLatitude();
					lng = chipper.getMapAddress().getLongitude();
				}
				
				GeoPoint p = new GeoPoint((int) lat, (int) lng);
				
				MapController mc = mapView.getController();
				mc.animateTo(p);
				
				Uri uri = Uri.parse("geo:"+lat+","+lng+"?z=14&q="+lat+","+lng); 
				Intent intent = new Intent(Intent.ACTION_VIEW, uri); 
				startActivity(intent); 
				 
				int zoomlevel = mapView.getMaxZoomLevel();
				mc.setZoom(zoomlevel - 2);
				mapView.setSatellite(false);
				
			}
		});
		
	}
	
 
}
