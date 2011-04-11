package com.itica.android;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class NewsActivity extends Activity {
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news);
        setUpViews();
    }

	private void setUpViews() {
		WebView webview = (WebView)findViewById(R.id.webView1);
		webview.getSettings().setJavaScriptEnabled(true);
		webview.loadUrl("http://itica.ie/news");
		
	}

}
