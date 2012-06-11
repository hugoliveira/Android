package webService_driver;

import java.util.ArrayList;

import Entities.Cache;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class getCacheHidden {
	private static final String URL = URLs.URL + "returnCache";
	private static final String NAMESPACE = "http://select/";

	public static ArrayList<Cache> getCacheHiddenByUserOnWorld(
			int idUser) {

		final String METHOD_NAME = "getCachesOwnedOnWorld ";

		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

		request.addProperty("idUser", idUser);
		
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);

		envelope.setOutputSoapObject(request);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			androidHttpTransport.call(URLs.SOAP_ACTION, envelope);
			SoapObject resultsRequestSOAP = (SoapObject) envelope.bodyIn;
		
			ArrayList<Cache> cs=new ArrayList<Cache>();
					
			
			for(int i=0; i<resultsRequestSOAP.getPropertyCount();i++){
				SoapObject object=(SoapObject) resultsRequestSOAP.getProperty(i);
				Cache ca=new Cache();
				ca.setDesc(object.getProperty("desc").toString());
				ca.setDiff(Float.parseFloat(object.getProperty("diff").toString()));
				ca.setHint(object.getProperty("hint").toString());
				ca.setId(Integer.parseInt(object.getProperty("id").toString()));
				ca.setLatitude(Float.parseFloat(object.getProperty("latitude").toString()));
				ca.setLongitude(Float.parseFloat(object.getProperty("longitude").toString()));
				ca.setName(object.getProperty("name").toString());
				ca.setOwner(object.getProperty("owner").toString());
				ca.setSize(Float.parseFloat(object.getProperty("size").toString()));
				ca.setTerrain(Float.parseFloat(object.getProperty("terrain").toString()));
				cs.add(ca);
				}
			
				if(cs.size()>0)
					return cs;
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	
	}



	public static int getNCacheHiddenByUserOnCompetition(
			int idUser) {

		final String METHOD_NAME = "getNCachesOwned ";

		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

		request.addProperty("idUser", idUser);
		

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);

		envelope.setOutputSoapObject(request);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			androidHttpTransport.call(URLs.SOAP_ACTION, envelope);
			SoapObject resultsRequestSOAP = (SoapObject) envelope.bodyIn;
			
		
			if(resultsRequestSOAP.getPropertyCount()>0)	
				return Integer.parseInt(resultsRequestSOAP.getProperty(0).toString());
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}


}
