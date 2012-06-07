package pt.ua.easyCaching;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class ViewCachesActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		
		String[] caches;
		final float[] lat;
		final float[] lon;

		SharedPreferences settings = getSharedPreferences("MYPREFS", 0);
		//String type = settings.getString("type", 0);
		int userID = settings.getInt("userID", 0);
		
		SQLiteDatabase db = openOrCreateDatabase("MyDB", MODE_PRIVATE, null);
		
		Cursor c = db.rawQuery("SELECT * FROM  WHERE RefIDUser = "+userID, null);
		caches = new String[c.getCount()];
		lat = new float[c.getCount()];
		lon = new float[c.getCount()];
		c.moveToFirst();
		int j=1;
		while(j<=c.getCount())
		{
			caches[j-1] = c.getString(c.getColumnIndex("Name"));
			lat[j-1] = c.getFloat(c.getColumnIndex("Lat"));
			lon[j-1] = c.getFloat(c.getColumnIndex("Lon"));
		}
		this.setListAdapter(new ArrayAdapter<String>(this, R.layout.menu_user_competition,caches ));

		  ListView lv = this.getListView();
		  lv.setTextFilterEnabled(true);

		  lv.setOnItemClickListener(new OnItemClickListener() {
			  
		    public void onItemClick(AdapterView<?> parent, View view,
		        int position, long id) {
		     
		    	Toast toast = Toast.makeText(ViewCachesActivity.this, "Lat: "+lat[(int) id]+"\nLon: "+lon, 3000);
				toast.setGravity(Gravity.BOTTOM, 0, 0);
				toast.show();
		    }

			
		  });

	}
	
}
