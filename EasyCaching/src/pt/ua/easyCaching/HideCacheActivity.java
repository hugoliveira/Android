package pt.ua.easyCaching;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class HideCacheActivity extends Activity {

	static Location loc;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hide_cache);
		
		Button b = (Button) findViewById(R.id.button1);
		final EditText e1 = (EditText) findViewById(R.id.editText1);
		final EditText e2 = (EditText) findViewById(R.id.editText2);
		final EditText e3 = (EditText) findViewById(R.id.editText3);
		final EditText e4 = (EditText) findViewById(R.id.editText4);
		final EditText e5 = (EditText) findViewById(R.id.editText5);
		final EditText e6 = (EditText) findViewById(R.id.editText6);
		final Spinner t1 = (Spinner) findViewById(R.id.tipos_cache);
		final Spinner t2 = (Spinner) findViewById(R.id.tipos_status);
		
		
		LocationManager m = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		
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
				// TODO Auto-generated method stub
				loc =arg0;
			}
		};
		m.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listener);
		
	
		b.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
			
			
				String name,hint,description;
				double terrain,difficulty,size,lat,lon;
				int cache_type,status_type;
				
				name = e1.getEditableText().toString();
				hint = e2.getEditableText().toString();
				description = e3.getEditableText().toString();
				terrain = Double.parseDouble(e4.getEditableText().toString());
				difficulty = Double.parseDouble(e5.getEditableText().toString());
				size = Double.parseDouble(e6.getEditableText().toString());
				cache_type = 1+ t1.getSelectedItemPosition();
				status_type = 1+ t2.getSelectedItemPosition();
				lat = loc.getLatitude();
				lon = loc.getLongitude();
				
				  
				SQLiteDatabase db = openOrCreateDatabase("MyDB", MODE_PRIVATE, null);
				 
				Cursor c = db.rawQuery("SELECT IDCacheHidden FROM CacheHidden ORDER BY IDCacheHidden DESC LIMIT 1", null);
				int cacheID,userID;
				SharedPreferences settings = getSharedPreferences("MYPREFS", 0);
				userID = settings.getInt("userID", 0);
				
				if(c.getCount() >0)
				{
					c.moveToFirst();
					cacheID =1+ c.getInt(c.getColumnIndex("IDCacheHidden"));
				}
				else
					cacheID=1;
					
				db.execSQL("INSERT INTO CacheHidden VALUES ("+cacheID+",'"+name+"',"+lat+","+lon+","+userID+","+cache_type+","+status_type+","+terrain+","+difficulty+","+size+",'"+hint+"','"+description+"');");
				c.close();
				db.close();
			}
		});
		
	}
}
