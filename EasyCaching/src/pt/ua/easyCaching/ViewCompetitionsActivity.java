package pt.ua.easyCaching;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ViewCompetitionsActivity extends ListActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		ArrayList<Competition> list = ConnectWebService.getCompetition();
		final int[] competition_id= new int[list.size()];
	
		String[] competition_name = new String[list.size()];
		for(int i=0;i<list.size();i++)
		{
			competition_name[i] = list.get(i).getNome();
			competition_id[i] = list.get(i).getIdcompeticao();
		}
		final String previous = getIntent().getExtras().getString("previous");
		this.setListAdapter(new ArrayAdapter<String>(this, R.layout.menu_user_competition, competition_name));

		  ListView lv = this.getListView();
		  lv.setTextFilterEnabled(true);

		  lv.setOnItemClickListener(new OnItemClickListener() {
			  
		    public void onItemClick(AdapterView<?> parent, View view,
		        int position, long id) {
		     
		    	if(previous.equals("user"))
		    	{
			    	Intent i = new Intent(ViewCompetitionsActivity.this, MapCompetition.class);
					i.putExtra("previous", "user");
					i.putExtra("idCompetition", competition_id[(int) id]);
					startActivity(i);
		    	}
		    	else if(previous.equals("juri"))
		    	{
		    		Intent i = new Intent(ViewCompetitionsActivity.this, MapCompetition.class);
					i.putExtra("previous", "juri");
					i.putExtra("idCompetition", competition_id[(int) id]);
					startActivity(i);
		    	}
		    

		    }

			
		  });

	}
	
}
