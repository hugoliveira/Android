package pt.ua.easyCaching;


//import java.util.List;

//import android.graphics.drawable.Drawable;
import android.os.Bundle;

//import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
//import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
//import com.google.android.maps.Overlay;
//import com.google.android.maps.OverlayItem;

public class Map extends MapActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map);
		
		MapView view = (MapView) findViewById(R.id.map);
		view.setBuiltInZoomControls(true);
		//GeoPoint point = new GeoPoint(19240000,-99120000);
		//MapController controller = mapView.getController();
		//controller.setCenter(point);
		/*
		List<Overlay> mapOverlays = mapView.getOverlays();
		Drawable drawable = this.getResources().getDrawable(R.drawable.androidmarker);
		Overlays overlay = new Overlays(drawable, this);
		
		GeoPoint point = new GeoPoint(19240000,-99120000);
		OverlayItem overlayitem = new OverlayItem(point, "Hola, Mundo!", "I'm in Mexico City!");
		
		GeoPoint point2 = new GeoPoint(35410000, 139460000);
		OverlayItem overlayitem2 = new OverlayItem(point2, "Sekai, konichiwa!", "I'm in Japan!");
		overlay.addOverlay(overlayitem);
		mapOverlays.add(overlay);*/
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

}
