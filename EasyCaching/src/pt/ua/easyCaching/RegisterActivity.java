package pt.ua.easyCaching;

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
					
					toast = Toast.makeText(RegisterActivity.this, "Username already taken!", 2000);
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
					
					db.execSQL("INSERT INTO User VALUES ("+id+",'"+u+"','"+p+"');");
					
					toast = Toast.makeText(RegisterActivity.this, "Registado com sucesso!", 2000);
					toast.setGravity(Gravity.CENTER, 0, 0);
					toast.show();
					
					c = db.rawQuery("SELECT * FROM User", null);
					
					c.moveToFirst();
					int j=1;
					while(j<= c.getCount())
					{
						Log.d("ID", ""+c.getInt(c.getColumnIndex("IDUser")));
						Log.d("DB", c.getString(c.getColumnIndex("Nome")));
						Log.d("DB", c.getString(c.getColumnIndex("Password")));
						j++;
						c.moveToNext();
					}
					
					//ConnectWebService.insertUser(u);
				}
				c.close();
				db.close();
				
				
				startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
			}
		});
	}

}
