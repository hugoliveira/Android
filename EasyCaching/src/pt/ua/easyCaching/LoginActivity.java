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
        Button adminButton = (Button) findViewById(R.id.admin_button);
        
        username = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.pass);
        
        registerButton.setOnClickListener(this);
        userButton.setOnClickListener(this);
        juriButton.setOnClickListener(this);
        adminButton.setOnClickListener(this);
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
    		//db.execSQL("CREATE TABLE IF NOT EXISTS CacheHidden (IDCacheHidden int PRIMARY KEY,Name nvarchar(200),Lat float,Lon float,RefIDUser int NOT NULL,Terrain float,Difficulty float,CacheSize float,Hint nvarchar(100),Descricao nvarchar(200),FOREIGN KEY (RefIDUser) REFERENCES User(IDUser));");
    		//db.execSQL("CREATE TABLE IF NOT EXISTS CacheFound (IDCacheFound int PRIMARY KEY,Name nvarchar(200),Lat float,Lon float,RefIDUser int NOT NULL,Terrain float,Difficulty float,CacheSize float,Hint nvarchar(100),Descricao nvarchar(200),FOREIGN KEY (RefIDUser) REFERENCES User(IDUser));");
    				
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
    		toast = Toast.makeText(LoginActivity.this, "Welcome "+username.getEditableText().toString()+"!", 3000);
    		toast.setGravity(Gravity.CENTER, 0, 0);
    		toast.show();
    		editor.putInt("userID", userID);
    		editor.commit();
    		startActivity(new Intent(LoginActivity.this, MenuUserActivity.class));
    	}
    	else if(v.getId() == R.id.login_user && !valid)
    	{
    		toast = Toast.makeText(LoginActivity.this, "Username or Password incorrect!", 3000);
    		toast.setGravity(Gravity.BOTTOM, 0, 0);
    		toast.show();
    	}
    	else if(v.getId() == R.id.login_juri)
    	{
    		toast = Toast.makeText(LoginActivity.this, "Welcome juri!", 3000);
    		toast.setGravity(Gravity.CENTER, 0, 0);
    		toast.show();
    		Intent intent = new Intent(LoginActivity.this,ViewCompetitionsActivity.class);
    		intent.putExtra("previous", "juri");
    		startActivity(intent);
    	}
    	else if(v.getId() == R.id.admin_button)
    	{
    		toast = Toast.makeText(LoginActivity.this, "Welcome admin!", 3000);
    		toast.setGravity(Gravity.CENTER, 0, 0);
    		toast.show();
    		startActivity(new Intent(LoginActivity.this, MenuAdminActivity.class));
    	}

    	db.close();
    }
    
}