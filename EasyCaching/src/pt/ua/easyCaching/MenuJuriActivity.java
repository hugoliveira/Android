package pt.ua.easyCaching;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MenuJuriActivity extends Activity implements OnClickListener {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_juri);
		
		Button createC = (Button) findViewById(R.id.create_competition);
		Button addC = (Button) findViewById(R.id.add_caches);
		Button viewC = (Button) findViewById(R.id.competition_view);
		
		createC.setOnClickListener(this);
		addC.setOnClickListener(this);
		viewC.setOnClickListener(this);
	}

	public void onClick(View arg0) {
		if(arg0.getId() == R.id.create_competition)
			startActivity(new Intent(MenuJuriActivity.this, CreateCompetitionActivity.class));
		else if(arg0.getId() == R.id.add_caches)
		{
			Intent i = new Intent(MenuJuriActivity.this, HideCacheActivity.class);
			i.putExtra("previous", "juri");
			startActivity(i);
		}
		else if(arg0.getId() == R.id.competition_view)
		{
			Intent i = new Intent(MenuJuriActivity.this, ViewCompetitionsActivity.class);
			i.putExtra("previous", "juri");
			startActivity(i);
		}
		
	}

}
