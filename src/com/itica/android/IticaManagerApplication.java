package com.itica.android;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import android.app.Application;

public class IticaManagerApplication extends Application {

	private List<Chipper> chippers;
	
	private Chipper currentChipper;
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		if(null == chippers){
			ChipperScraper cs = new ChipperScraper();
			try {
				cs.run();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			chippers = cs.getChippers();
			Collections.sort(chippers);
		}
		
	}
	public List<Chipper> getChippers() {
		return chippers;
	}
	public void setChippers(List<Chipper> chippers) {
		this.chippers = chippers;
	}
	public Chipper getCurrentChipper() {
		return currentChipper;
	}
	public void setCurrentChipper(Chipper currentChipper) {
		this.currentChipper = currentChipper;
	}
	
	
}
