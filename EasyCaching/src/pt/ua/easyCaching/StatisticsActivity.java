package pt.ua.easyCaching;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class StatisticsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.statistics);
		
		SQLiteDatabase db = openOrCreateDatabase("MyDB", MODE_PRIVATE, null);
	
		db.execSQL("PRAGMA foreign_keys = ON;");
		db.execSQL("CREATE TABLE IF NOT EXISTS User (IDUser int PRIMARY KEY, Nome nvarchar(50),Password nvarchar(10));");
		
		db.execSQL("CREATE TABLE IF NOT EXISTS StatusCache (IDStatusCache int PRIMARY KEY, Descricao nvarchar(10))");
		db.execSQL("CREATE TABLE IF NOT EXISTS CacheHidden (IDCacheHidden int PRIMARY KEY,Name nvarchar(200),Lat float,Lon float,RefIDUser int NOT NULL,RefIDTipoCache int NOT NULL,RefIDStatusCache int NOT NULL,Terrain float,Difficulty float,CacheSize float,Hint nvarchar(100),Descricao nvarchar(200),FOREIGN KEY (RefIDTipoCache) REFERENCES TipoCache(IDTipoCache),FOREIGN KEY (RefIDStatusCache) REFERENCES StatusCache(IDStatusCache),FOREIGN KEY (RefIDUser) REFERENCES User(IDUser));");
		db.execSQL("CREATE TABLE IF NOT EXISTS CacheFound (IDCacheFound int PRIMARY KEY,Name nvarchar(200),Lat float,Lon float,RefIDUser int NOT NULL,RefIDTipoCache int NOT NULL, RefIDStatusCache int NOT NULL, Terrain float,Difficulty float,CacheSize float,Hint nvarchar(100),Descricao nvarchar(200),FOREIGN KEY (RefIDTipoCache) REFERENCES TipoCache(IDTipoCache),FOREIGN KEY (RefIDStatusCache) REFERENCES StatusCache(IDStatusCache),FOREIGN KEY (RefIDUser) REFERENCES User(IDUser));");
				
		db.execSQL("INSERT INTO TipoCache VALUES (1,'Traditional Cache')");
		db.execSQL("INSERT INTO TipoCache VALUES (2,'Multi-Cache')");
		db.execSQL("INSERT INTO TipoCache VALUES (3,'Unknown Cache')");
		db.execSQL("INSERT INTO TipoCache VALUES (4,'Virtual Cache')");
				
		db.execSQL("INSERT INTO StatusCache VALUES (1,'Active')");
		db.execSQL("INSERT INTO StatusCache VALUES (2,'Inactive')");
		db.execSQL("INSERT INTO StatusCache VALUES (3,'Archived')");
		db.close();
		/*
		c = db.rawQuery("SELECT * FROM CacheHidden", null);
		c.moveToFirst();
		int j=1;
		while(j<=c.getCount())
		{
			Log.d("ID", ""+c.getInt(c.getColumnIndex("IDCacheHidden")));
			Log.d("DB", c.getString(c.getColumnIndex("Name")));
			Log.d("DB", c.getString(c.getColumnIndex("Hint")));
			Log.d("DB", c.getString(c.getColumnIndex("Descricao")));
			Log.d("DB", ""+c.getFloat(c.getColumnIndex("Terrain")));
			Log.d("DB", ""+c.getFloat(c.getColumnIndex("Difficulty")));
			Log.d("DB", ""+c.getFloat(c.getColumnIndex("CacheSize")));
			Log.d("DB", ""+c.getInt(c.getColumnIndex("RefIDTipoCache")));
			Log.d("DB", ""+c.getInt(c.getColumnIndex("RefIDStatusCache")));
			Log.d("DB", ""+c.getFloat(c.getColumnIndex("Lat")));
			Log.d("DB", ""+c.getFloat(c.getColumnIndex("Lon")));
			j++;
			c.moveToNext();
		}
		c.close();
		db.close();
	}*/
	}
}
