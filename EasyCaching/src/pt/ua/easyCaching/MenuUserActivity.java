package pt.ua.easyCaching;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MenuUserActivity extends Activity implements OnClickListener {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_user);
		
		Button mapButton = (Button) findViewById(R.id.map_button);
		Button cacheButton = (Button) findViewById(R.id.cache_button);
		Button statisticsButton = (Button) findViewById(R.id.statistics_button);
		
		mapButton.setOnClickListener(this);
		cacheButton.setOnClickListener(this);
		statisticsButton.setOnClickListener(this);
	}

	public void onClick(View v) {
		
		if(v.getId() == R.id.map_button)
			startActivity(new Intent(MenuUserActivity.this, Map.class));
		
		else if(v.getId() == R.id.cache_button)
			startActivity(new Intent(MenuUserActivity.this, HideCacheActivity.class));
		
		else if(v.getId() == R.id.statistics_button)
			startActivity(new Intent(MenuUserActivity.this, StatisticsActivity.class));
		
	}

}
