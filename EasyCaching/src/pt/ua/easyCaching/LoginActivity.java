package pt.ua.easyCaching;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
	static EditText username;
	static EditText password;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
        Button userButton = (Button) findViewById(R.id.login_user);
        Button juriButton = (Button) findViewById(R.id.login_juri);
        Button registerButton = (Button) findViewById(R.id.register_button);
        
        username = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.pass);
        
        registerButton.setOnClickListener(this);
        userButton.setOnClickListener(this);
        juriButton.setOnClickListener(this);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	MenuInflater inflate = getMenuInflater();
    	inflate.inflate(R.menu.menu, menu);
    	return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	
    	if(item.getItemId() == R.id.db)
    	{
    		SQLiteDatabase db = openOrCreateDatabase("MyDB", MODE_PRIVATE, null);
    		
    		db.execSQL("PRAGMA foreign_keys = ON;");
    		db.execSQL("CREATE TABLE IF NOT EXISTS User (IDUser int PRIMARY KEY, Nome nvarchar(50),Password nvarchar(10));");
    		db.execSQL("CREATE TABLE IF NOT EXISTS CacheHidden (IDCacheHidden int PRIMARY KEY,Name nvarchar(200),Lat float,Lon float,RefIDUser int NOT NULL,Terrain float,Difficulty float,CacheSize float,Hint nvarchar(100),Descricao nvarchar(200),FOREIGN KEY (RefIDUser) REFERENCES User(IDUser));");
    		db.execSQL("CREATE TABLE IF NOT EXISTS CacheFound (IDCacheFound int PRIMARY KEY,Name nvarchar(200),Lat float,Lon float,RefIDUser int NOT NULL,Terrain float,Difficulty float,CacheSize float,Hint nvarchar(100),Descricao nvarchar(200),FOREIGN KEY (RefIDUser) REFERENCES User(IDUser));");
    				

    				
//    		Cursor c;
//    		c = db.rawQuery("SELECT * FROM CacheHidden", null);
//    		c.moveToFirst();
//    		int j=1;
//    		while(j<=c.getCount())
//    		{
//    			Log.d("ID", ""+c.getInt(c.getColumnIndex("IDCacheHidden")));
//    			Log.d("UserID", ""+c.getInt(c.getColumnIndex("RefIDUser")));
//    			Log.d("DB", c.getString(c.getColumnIndex("Name")));
//    			Log.d("DB", c.getString(c.getColumnIndex("Hint")));
//    			Log.d("DB", c.getString(c.getColumnIndex("Descricao")));
//    			Log.d("DB", ""+c.getFloat(c.getColumnIndex("Terrain")));
//    			Log.d("DB", ""+c.getFloat(c.getColumnIndex("Difficulty")));
//    			Log.d("DB", ""+c.getFloat(c.getColumnIndex("CacheSize")));
//    			Log.d("DB", ""+c.getFloat(c.getColumnIndex("Lat")));
//    			Log.d("DB", ""+c.getFloat(c.getColumnIndex("Lon")));
//    			
//    			j++;
//    			c.moveToNext();
//    		}
//    		
//    		c = db.rawQuery("SELECT * FROM User", null);
//    		c.moveToFirst();
//    		j=1;
//    		while(j<=c.getCount())
//    		{
//    			Log.d("ID", ""+c.getInt(c.getColumnIndex("IDUser")));
//    			Log.d("ID", c.getString(c.getColumnIndex("Nome")));
//    			Log.d("ID", c.getString(c.getColumnIndex("Password")));
//    			j++;
//    			c.moveToNext();
//    		}
//    		c.close();
//    		db.close();
    	}
    	return super.onOptionsItemSelected(item);
    }
    
    public void onClick(View v) {
    	
    	boolean valid=false;
    	SQLiteDatabase db = openOrCreateDatabase("MyDB", MODE_PRIVATE, null);
    	SharedPreferences settings = getSharedPreferences("MYPREFS", 0);
    	SharedPreferences.Editor editor = settings.edit();
    	Toast toast;
    	int userID=0;
    	if(v.getId() == R.id.register_button)
    		startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    	
    	Cursor c = db.rawQuery("SELECT IDUser FROM User WHERE Nome ='"+username.getEditableText().toString()+"' AND Password = '"+password.getEditableText().toString()+"'", null);
    	
    	if(c.getCount() >0)
    	{
    		valid = true;
        	c.moveToFirst();
        	userID = c.getInt(c.getColumnIndex("IDUser"));
        	c.close();
    	}
    	
    	
    	if(v.getId() == R.id.login_user && valid)
    	{
    		toast = Toast.makeText(LoginActivity.this, "Welcome "+username.getEditableText().toString()+"!", 2000);
    		toast.setGravity(Gravity.CENTER, 0, 0);
    		toast.show();
    		editor.putInt("userID", userID);
    		editor.commit();
    		startActivity(new Intent(LoginActivity.this, MenuUserActivity.class));
    	}
    	else if(v.getId() == R.id.login_user && !valid)
    	{
    		toast = Toast.makeText(LoginActivity.this, "Username or Password incorrect!", 2000);
    		toast.setGravity(Gravity.BOTTOM, 0, 0);
    		toast.show();
    	}
    	else
    	{
    		toast = Toast.makeText(LoginActivity.this, "Welcome juri!", 2000);
    		toast.setGravity(Gravity.CENTER, 0, 0);
    		toast.show();
    		startActivity(new Intent(LoginActivity.this, MenuJuriActivity.class));
    	}
    	
    	
    	
    	db.close();
    }
    
}