package pt.ua.easyCaching;

import webService_driver.getCaches;
import Entities.Cache;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;



public class ViewCacheActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.view_cache);
		
		TextView vc_name = (TextView) findViewById(R.id.vc_name2);
		TextView vc_terrain = (TextView) findViewById(R.id.vc_terrain2);
		TextView vc_difficulty = (TextView) findViewById(R.id.vc_difficulty2);
		TextView vc_size = (TextView) findViewById(R.id.vc_size2);
		TextView vc_hint = (TextView) findViewById(R.id.vc_hint2);
		TextView vc_description = (TextView) findViewById(R.id.vc_description2);
		
		int cacheID = getIntent().getExtras().getInt("cacheID");
		Log.d("test", "cacheID");
		Log.d("cacheID", ""+cacheID);
		Cache cache = getCaches.getCacheById(cacheID);
		
		vc_name.setText(cache.getName()); 
		vc_terrain.setText(""+cache.getTerrain());
		vc_difficulty.setText(""+cache.getDiff());
		vc_size.setText(""+cache.getSize());
		vc_hint.setText(""+cache.getHint());
		vc_description.setText(""+cache.getDesc());
		
		vc_name.setVisibility(View.VISIBLE);
		vc_terrain.setVisibility(View.VISIBLE);
		vc_difficulty.setVisibility(View.VISIBLE);
		vc_size.setVisibility(View.VISIBLE);
		vc_hint.setVisibility(View.VISIBLE);
		vc_description.setVisibility(View.VISIBLE);
	}
	
}
