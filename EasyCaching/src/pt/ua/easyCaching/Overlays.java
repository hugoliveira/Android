package pt.ua.easyCaching;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.sax.StartElementListener;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class Overlays extends ItemizedOverlay {

	private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();
	private Context mContext;
	
	public Overlays(Drawable defaultMarker) {
		super(boundCenterBottom(defaultMarker));
		// TODO Auto-generated constructor stub
	}
	
	public Overlays(Drawable defaultMarker, Context context) {
		  super(boundCenterBottom(defaultMarker));
		  mContext = context;
		}

	@Override
	protected OverlayItem createItem(int i) {
	  return mOverlays.get(i);
	}
	
	public void addOverlay(OverlayItem overlay) {
	    
		mOverlays.add(overlay);
	    populate();
	}
	
public void removeUserOverlay() {
	    
		mOverlays.remove(0);
	    populate();
	}

public void removeAllOverlays()
{
	for(int i=mOverlays.size()-1;i>=0;i-- )
	{
		mOverlays.remove(i);
		populate();
	}
}

	@Override
	public int size() {
	  return mOverlays.size();
	}
	
	@Override
	protected boolean onTap(int index) {
	  OverlayItem item = mOverlays.get(index);
	  Intent i = null;
	  SharedPreferences settings = mContext.getSharedPreferences("MYPREFS", 0);
	  int competitionID = settings.getInt("competitionID", 1);
	  
	  if(item.getSnippet().equals("user"))
	  {
		  i = new Intent(mContext,UserStatsActivity.class);
		  i.putExtra("userID", Integer.parseInt(item.getTitle()));
		  i.putExtra("competitionID", competitionID);
	  }
	  else if(item.getSnippet().equals("cache"))
	  {
		  i = new Intent(mContext,ViewCacheActivity.class);
		  i.putExtra("cacheID", Integer.parseInt(item.getTitle()));
	  }
	  
	  mContext.startActivity(i);
	  
	  
	  
	  return true;
	}
	
	

}
