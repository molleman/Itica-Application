package com.itica.android;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class ChipperAdapter extends ArrayAdapter<Chipper> {

	private List<Chipper> chippers;
	
	public ChipperAdapter(Context context,int textViewResourceId, List<Chipper> chippers) {
		super(context, textViewResourceId, chippers);
		this.chippers = chippers;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if(v==null){
			LayoutInflater vi = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.chipper_row, null);		
        }
		Chipper c = chippers.get(position);
		if(c != null){
			TextView tt = (TextView) v.findViewById(R.id.toptext);
			tt.setText(c.getName());
			
			TextView ta = (TextView) v.findViewById(R.id.address_text);
			ta.setText(c.getAddress());
			
		}
		
		return v;
		
	}
	
	
	
	

}
