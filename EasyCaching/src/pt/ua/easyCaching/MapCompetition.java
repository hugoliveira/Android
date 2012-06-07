package pt.ua.easyCaching;

import java.util.ArrayList;
import java.util.List;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MapCompetition extends MapActivity {

	
	static OverlayItem overlayItem;
	static MapView view;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map);
		
		view = (MapView) findViewById(R.id.map);
		view.setBuiltInZoomControls(true);
		
		int competitionID = getIntent().getExtras().getInt("idCompetition");
		String previous = getIntent().getExtras().getString("previous");
		
		SharedPreferences settings = getSharedPreferences("MYPREFS", 0);
		final int userID = settings.getInt("userID", 0);
		final List<Overlay> mapOverlays = view.getOverlays();
		final Overlays user = new Overlays(this.getResources().getDrawable(R.drawable.games), this);
		final Overlays userC = new Overlays(this.getResources().getDrawable(R.drawable.games), this);
		final Overlays caches = new Overlays(this.getResources().getDrawable(R.drawable.map_pin),this);
		GeoPoint p;
		ArrayList<Cache> list = ConnectWebService.getCache(competitionID);
		
		for(int i=0;i<list.size();i++)
		{
			p = new GeoPoint((int) (list.get(i).getLatitude()* 1E6),(int) (list.get(i).getLongitude()* 1E6));
			overlayItem = new OverlayItem(p,"","");
			caches.addOverlay(overlayItem);
		}
		mapOverlays.add(caches);
		
		
		if(previous.equals("user"))
		{
			LocationManager m = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
			final MapController controller = view.getController();
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
				
				
				int lat = (int) ( arg0.getLatitude());
				int lon = (int) ( arg0.getLongitude());
				GeoPoint center = new GeoPoint(lat, lon);
				controller.setCenter(center);
				controller.setZoom(7);
				overlayItem = new OverlayItem(center, "", "");
				
				if(user.size() !=0)	
					user.removeUserOverlay();
					
				user.addOverlay(overlayItem);
				mapOverlays.add(user);
				Log.d("coords", "1");
				ConnectWebService.updateCoordenadaByUserID(userID, arg0.getLatitude(), arg0.getLongitude());
				Log.d("coords", "2");
			}
		};
			m.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);
			
		}
		else if(previous.equals("juri"))
		{
			
				ArrayList<User> users = ConnectWebService.getUserbyComp(competitionID);
				Log.d("USERS", users.size()+" users");
				for(int i=0;i<users.size();i++)
				{
					
					p = new GeoPoint((int) (users.get(i).getLatitude()* 1E6),(int) (users.get(i).getLongitude()* 1E6));
					overlayItem = new OverlayItem(p,"","");
					userC.addOverlay(overlayItem);
					Log.d("USERS", users.size()+i+" x");
				}
				mapOverlays.add(userC);
				
				for(int j=0;j<users.size();j++)
				{
					for(int k=0;k<list.size();k++)
					{
						int latU = (int) (users.get(j).getLatitude() * 1E6);
						int lonU = (int) (users.get(j).getLongitude() * 1E6);
						int latC = (int) (list.get(k).getLatitude() * 1E6);
						int lonC = (int) (list.get(k).getLongitude() * 1E6);
						
						if(latU == latC && lonU == lonC)
						{
							Toast toast = Toast.makeText(MapCompetition.this, users.get(j).getUsername()+" has found a cache!", 2000);
				    		toast.setGravity(Gravity.CENTER, 0, 0);
				    		toast.show();
						}
					}
				
//				try {
//					
//					Thread.sleep(60000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}
			
			
		}
		
		
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
