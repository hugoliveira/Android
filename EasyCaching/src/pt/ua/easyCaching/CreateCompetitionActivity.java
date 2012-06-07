package pt.ua.easyCaching;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class CreateCompetitionActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.create_competition);
		
		final EditText name = (EditText) findViewById(R.id.c_name);
		final EditText place = (EditText) findViewById(R.id.place);
		final DatePicker d = (DatePicker) findViewById(R.id.datePicker1);
		
		Button b = (Button) findViewById(R.id.register_competition_button);
		
		b.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				String date = d.getYear()+"-"+d.getMonth()+"-"+d.getDayOfMonth();
				ConnectWebService.createComp(name.getText().toString(),date , place.getText().toString());
				
				startActivity(new Intent(CreateCompetitionActivity.this, MenuJuriActivity.class));
			}
		});
	}

}
