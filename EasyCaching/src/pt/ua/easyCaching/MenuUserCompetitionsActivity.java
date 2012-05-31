package pt.ua.easyCaching;

import android.app.Activity;
import android.app.ListActivity;
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

public class MenuUserCompetitionsActivity extends ListActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		String[] competition_name= {"ola","ole"};
		int[] competition_id;
		
		this.setListAdapter(new ArrayAdapter<String>(this, R.layout.menu_user_competition, competition_name));

		  ListView lv = this.getListView();
		  lv.setTextFilterEnabled(true);

		  lv.setOnItemClickListener(new OnItemClickListener() {
			  
		    public void onItemClick(AdapterView<?> parent, View view,
		        int position, long id) {
		     
		    	
		    

		    }

			
		  });

	}
	
}
