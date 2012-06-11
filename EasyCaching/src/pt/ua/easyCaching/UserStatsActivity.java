package pt.ua.easyCaching;

import java.util.ArrayList;
import java.util.List;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;
import webService_driver.getCacheFound;
import webService_driver.getCacheHidden;
import Entities.Cache;
import Entities.CacheFound;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class UserStatsActivity extends MapActivity{

	static MapView view;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.statistics);
		
		TextView h_text = (TextView) findViewById(R.id.t_hidden1);
		TextView hidden = (TextView) findViewById(R.id.t_hidden2);
		TextView found = (TextView) findViewById(R.id.t_found2);
		view = (MapView) findViewById(R.id.map);
		view.setBuiltInZoomControls(true);
		
		int userID = getIntent().getExtras().getInt("userID");
		int competitionID = getIntent().getExtras().getInt("competitionID");
		
		Log.d("user", ""+userID);
		Log.d("competitionID", ""+competitionID);
		
		found.setText(""+getCacheFound.getNCacheFoundByUserOnCompetition(userID, competitionID));
		if(competitionID != 1)
		{
			h_text.setVisibility(View.INVISIBLE);
			hidden.setVisibility(View.INVISIBLE);
		}
		else
		{
			
			hidden.setText(""+getCacheHidden.getNCacheHiddenByUserOnCompetition(userID));
			h_text.setVisibility(View.VISIBLE);
			hidden.setVisibility(View.VISIBLE);
		}
		
		final List<Overlay> mapOverlays = view.getOverlays();
		GeoPoint p;
		OverlayItem overlayItem;
		
		if(competitionID == 1)
		{
			ArrayList<Cache> hiddenList = getCacheHidden.getCacheHiddenByUserOnWorld(userID);
			
			Overlays cachesHidden = new Overlays(this.getResources().getDrawable(R.drawable.map_pin),this);
			Log.d("listsize", ""+hiddenList.size());
			for(int i=0;i<hiddenList.size();i++)
			{
				p = new GeoPoint((int) (hiddenList.get(i).getLatitude()* 1E6),(int) (hiddenList.get(i).getLongitude()* 1E6));
				overlayItem = new OverlayItem(p,""+hiddenList.get(i).getId(),"cache");
				cachesHidden.addOverlay(overlayItem);
			}
			mapOverlays.add(cachesHidden);
		}
		
		final Overlays cachesFound = new Overlays(this.getResources().getDrawable(R.drawable.treasure_map),this);
		final ArrayList<CacheFound> foundList = getCacheFound.getCacheFoundByUserOnCompetition(userID, competitionID);
	
		
		for(int i=0;i<foundList.size();i++)
		{
			p = new GeoPoint((int) (foundList.get(i).getLatitude()* 1E6),(int) (foundList.get(i).getLongitude()* 1E6));
			overlayItem = new OverlayItem(p,""+foundList.get(i).getId(),"cache");
			cachesFound.addOverlay(overlayItem);
		}
		mapOverlays.add(cachesFound);
	
		view.postInvalidate();
		
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflate = getMenuInflater();
    	inflate.inflate(R.menu.menu_map, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		if(item.getItemId() == R.id.sat)
		{
			view.setTraffic(false);
			view.setSatellite(true);	
		}
			
		else if(item.getItemId() == R.id.traffic)
		{
			view.setSatellite(false);
			view.setTraffic(true);
		}
		return super.onOptionsItemSelected(item);
	}
	
	
}
