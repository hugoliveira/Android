package pt.ua.easyCaching;

import webService_driver.insert;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class CreateCompetitionActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);	
		setContentView(R.layout.create_competition);
		
		final EditText name = (EditText) findViewById(R.id.e_cname);
		final EditText place = (EditText) findViewById(R.id.e_cplace);
		final DatePicker d = (DatePicker) findViewById(R.id.datePicker1);
		
		Button b = (Button) findViewById(R.id.b_create_competition);
		
		b.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				String date = d.getYear()+"-"+d.getMonth()+"-"+d.getDayOfMonth();
				insert.createComp(name.getText().toString(),date , place.getText().toString());
				
				Toast toast = Toast.makeText(CreateCompetitionActivity.this, "Competição registada com sucesso!", 3000);
				toast.setGravity(Gravity.CENTER, 0, 0);
				toast.show();
				
				startActivity(new Intent(CreateCompetitionActivity.this, MenuAdminActivity.class));
			}
		});
	}

}
