package pt.ua.easyCaching;

import java.util.ArrayList;
import java.util.List;

import webService_driver.getCaches;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

import com.google.android.maps.MapView;

import Entities.Cache;

public class Map extends MapActivity {

	static OverlayItem overlayItem;
	static MapView view;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map);
		
		view = (MapView) findViewById(R.id.map);
		view.setBuiltInZoomControls(true);
		
		final List<Overlay> mapOverlays = view.getOverlays();
		final Overlays user = new Overlays(this.getResources().getDrawable(R.drawable.games), this);
		final Overlays caches = new Overlays(this.getResources().getDrawable(R.drawable.map_pin),this);
		
		LocationManager m = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		final MapController controller = view.getController();
		
		
		GeoPoint p;

		ArrayList<Cache> list = getCaches.getCache(1);
		
		for(int i=0;i<list.size();i++)
		{
			p = new GeoPoint((int) (list.get(i).getLatitude()* 1E6),(int) (list.get(i).getLongitude()* 1E6));
			overlayItem = new OverlayItem(p,"","");
			caches.addOverlay(overlayItem);
		}
		mapOverlays.add(caches);
		LocationListener listener = new LocationListener() {
			
			public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
				// TODO Auto-generated method stub
				
			}
			
			public void onProviderEnabled(String arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void onProviderDisabled(String arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void onLocationChanged(Location arg0) {
				
				
				int lat = (int) ( arg0.getLatitude() * 1E6);
				int lon = (int) ( arg0.getLongitude() * 1E6);
				GeoPoint center = new GeoPoint(lat, lon);
				controller.setCenter(center);
				controller.setZoom(7);
				overlayItem = new OverlayItem(center, "", "");
				
				if(user.size() !=0)	
					user.removeUserOverlay();
					
				user.addOverlay(overlayItem);
				mapOverlays.add(user);
			}
		};



		
		m.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);
		
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
