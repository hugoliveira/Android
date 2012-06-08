package webService_driver;

import java.util.ArrayList;

import Entities.Coordinates;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.util.Log;

public class getCoordinates {
	private static final String NAMESPACE = "http://select/";
	private static final String URL = URLs.URL+"returnCoordinates";
	
	public static Coordinates getCoordinatesFromUser(int uId) {
		final String METHOD_NAME = "getCoordenatesUserById";

		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
		request.addProperty("IdUser", uId);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);

		envelope.setOutputSoapObject(request);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			androidHttpTransport.call(URLs.SOAP_ACTION, envelope);

			SoapObject resultsRequestSOAP = (SoapObject) envelope.bodyIn;
			if(resultsRequestSOAP.getPropertyCount()>0){
				Log.d("ENtrei", "akl");
				SoapObject object=(SoapObject) resultsRequestSOAP.getProperty(0);
				Coordinates coord=new Coordinates();
				coord.setLatitude((Float.parseFloat(object.getProperty("latitude").toString())));
				coord.setLongitude((Float.parseFloat(object.getProperty("longitude").toString())));
				coord.setUserId((Integer.parseInt(object.getProperty("userId").toString())));
				return coord;
			}
				

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<Coordinates> getCoordenatesAllUsersfromCompetition(int idComp) {
			final String METHOD_NAME = "getCoordenatesAllUsersfromCompetition";

		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
		request.addProperty("idCompetition", idComp);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);

		envelope.setOutputSoapObject(request);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
		ArrayList<Coordinates> coords=new ArrayList<Coordinates>();
		try {
			androidHttpTransport.call(URLs.SOAP_ACTION, envelope);

			SoapObject resultsRequestSOAP = (SoapObject) envelope.bodyIn;


			for(int i=0; i<resultsRequestSOAP.getPropertyCount();i++){
				
				Log.d("ENtrei", "akl");
				SoapObject object=(SoapObject) resultsRequestSOAP.getProperty(i);
				Coordinates coord=new Coordinates();
				coord.setLatitude((Float.parseFloat(object.getProperty("latitude").toString())));
				coord.setLongitude((Float.parseFloat(object.getProperty("longitude").toString())));
				coord.setUserId((Integer.parseInt(object.getProperty("userId").toString())));
				coords.add(coord);
			}
				if(coords.size()>0)
					return coords;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
