package pt.ua.easyCaching;

import webService_driver.insert;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		
		final EditText newUser = (EditText) findViewById(R.id.editText1R);
		final EditText newPass = (EditText) findViewById(R.id.editText2R);
		Button b = (Button) findViewById(R.id.buttonR);
		
		b.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				
				String u = newUser.getText().toString();
				String p = newPass.getText().toString();
				Toast toast;
				SQLiteDatabase db = openOrCreateDatabase("MyDB", MODE_PRIVATE, null);
				
				Cursor c = db.rawQuery("SELECT * FROM User WHERE Nome='"+u+"'", null);
				
				
				if(c.getCount() >0)
				{
					
					toast = Toast.makeText(RegisterActivity.this, "Username already taken!", 3000);
					toast.setGravity(Gravity.BOTTOM, 0, 0);
					toast.show();
					
					newUser.setText("");
				}
				else
				{
					
					c = db.rawQuery("SELECT IDUser FROM User ORDER BY IDUser DESC LIMIT 1", null);
					
					int id;
					
					if(c.getCount() >0)
					{
						c.moveToFirst();
						id =1+ c.getInt(c.getColumnIndex("IDUser"));
						
					}
					else
						id=1;
					
					insert.insertUser(u);
					db.execSQL("INSERT INTO User VALUES ("+id+",'"+u+"','"+p+"');");
					
					toast = Toast.makeText(RegisterActivity.this, "Registado com sucesso!", 3000);
					toast.setGravity(Gravity.CENTER, 0, 0);
					toast.show();
					
				}
				c.close();
				db.close();
				
				
				startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
			}
		});
	}

}
