package com.itica.android;

import android.app.Activity;

public class IticaManagerActivity extends Activity{
	
	protected IticaManagerApplication getIticaManagerApplication(){
		
		IticaManagerApplication ima = (IticaManagerApplication)getApplication();
		return ima;
	}

}
