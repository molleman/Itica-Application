package com.itica.android;

import com.google.android.maps.MapActivity;

import android.app.Activity;
import android.os.Bundle;

public class DirectMeActivity extends MapActivity {
	
	/*
	 * 53.383738 lat
	 * -6.264954 long (some area in dublin)
	 * (non-Javadoc)
	 * @see com.google.android.maps.MapActivity#isRouteDisplayed()
	 */
	
	
	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.direct_me);
        setUpViews();
    }

	private void setUpViews() {
		// TODO Auto-generated method stub
		
	}

}
