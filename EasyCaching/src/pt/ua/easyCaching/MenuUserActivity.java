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
		Button competitionsButton = (Button) findViewById(R.id.competitions_button);
		Button twitterButton = (Button) findViewById(R.id.twitter_button);
		
		mapButton.setOnClickListener(this);
		cacheButton.setOnClickListener(this);
		statisticsButton.setOnClickListener(this);
		competitionsButton.setOnClickListener(this);
		twitterButton.setOnClickListener(this);
	}

	public void onClick(View v) {
		
		if(v.getId() == R.id.map_button)
			startActivity(new Intent(MenuUserActivity.this, Map.class));
		
		else if(v.getId() == R.id.twitter_button)
			startActivity(new Intent(MenuUserActivity.this, TwitterActivity.class));
		else if(v.getId() == R.id.cache_button)
		{
			Intent i = new Intent(MenuUserActivity.this, HideCacheActivity.class);
			i.putExtra("previous", "user");
			startActivity(i);
		}
		
		else if(v.getId() == R.id.statistics_button)
			startActivity(new Intent(MenuUserActivity.this, StatisticsActivity.class));
		
		else if(v.getId() == R.id.competitions_button)
		{
			Intent i = new Intent(MenuUserActivity.this, ViewCompetitionsActivity.class);
			i.putExtra("previous", "user");
			startActivity(i);
		}
		
	}

}
