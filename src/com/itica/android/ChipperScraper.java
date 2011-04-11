package com.itica.android;



import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;


public class ChipperScraper {
	
	private List<Chipper> chippers = null;
	
	public ChipperScraper(){
		chippers = new ArrayList<Chipper>();
	}
	
	public List<Chipper> getChippers() {
		return chippers;
	}


	public void setChippers(List<Chipper> chippers) {
		this.chippers = chippers;
	}
	
	public void run() throws IOException{
		
		String text;
        Document doc = null;

        
		String sUrl = "http://itica.ie/chipper_directory";
        URL url2 = new URL(sUrl);
        doc = Jsoup.parse(url2, 10000);
        text = doc.body().text();
        //System.out.println(text);
        
        Elements chippersHtml = doc.select("tr[class]");
			int counter = 0;
        for(Element e :chippersHtml){
        	if(e.className().equals("odd")){
        		
        		//System.out.println(e.childNodes().get(1).toString()); 
        		List<Node> nodes = e.childNodes();
        		
        		Node node1 = nodes.get(1);
        		String chipperName = node1.childNodes().get(0).attr("title");
        		String chipperLink = node1.childNodes().get(0).attr("href");
        		
        		String chipperAddress = nodes.get(3).childNodes().get(0).toString();
        		String chipperCounty = nodes.get(5).childNodes().get(0).toString();

        		String chipperPhoneNo = "";
        		if(!nodes.get(7).childNodes().isEmpty()){
        			chipperPhoneNo = nodes.get(7).childNodes().get(0).toString();
            		
        		}
        		
        		Chipper chipper = new Chipper(chipperName,chipperAddress,chipperCounty,chipperPhoneNo);
        		
        		chippers.add(chipper);
        	}

        }
	}
	 

}
