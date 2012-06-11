package webService_driver;

import java.util.ArrayList;

import Entities.CacheFound;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class getCacheFound {
	private static final String URL = URLs.URL + "returnCacheFound";
	private static final String NAMESPACE = "http://select/";

	public static ArrayList<CacheFound> getCacheFoundByUserOnCompetition(
			int idUser, int idCompeticao) {

		final String METHOD_NAME = "getCacheFoundByUserOnCompetition ";

		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

		request.addProperty("idUser", idUser);
		request.addProperty("idCompetition", idCompeticao);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);

		envelope.setOutputSoapObject(request);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			androidHttpTransport.call(URLs.SOAP_ACTION, envelope);
			SoapObject resultsRequestSOAP = (SoapObject) envelope.bodyIn;
			// resultsRequestSOAP=(SoapObject)
			// resultsRequestSOAP.getProperty(0);/*caches*/
			// resultsRequestSOAP=(SoapObject)
			// resultsRequestSOAP.getProperty(0);/*cache*/
			// resultsRequestSOAP=(SoapObject)
			// resultsRequestSOAP.getProperty(0);/*ok*/

			ArrayList<CacheFound> cs = new ArrayList<CacheFound>();

			for (int i = 0; i < resultsRequestSOAP.getPropertyCount(); i++) {
				SoapObject object = (SoapObject) resultsRequestSOAP
						.getProperty(i);
				CacheFound ca = new CacheFound();
				ca.setDesc(object.getProperty("desc").toString());
				ca.setDiff(Float.parseFloat(object.getProperty("diff")
						.toString()));
				ca.setHint(object.getProperty("hint").toString());
				ca.setId(Integer.parseInt(object.getProperty("id").toString()));
				ca.setLatitude(Float.parseFloat(object.getProperty("latitude")
						.toString()));
				ca.setLongitude(Float.parseFloat(object
						.getProperty("longitude").toString()));
				ca.setName(object.getProperty("name").toString());
				ca.setOwner(object.getProperty("owner").toString());
				ca.setSize(Float.parseFloat(object.getProperty("size")
						.toString()));
				ca.setTerrain(Float.parseFloat(object.getProperty("terrain")
						.toString()));
				ca.setDateFound(object.getProperty("dateFound").toString());
				cs.add(ca);
			}

			if (cs.size() > 0)
				return cs;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}



	public static int getNCacheFoundByUserOnCompetition(
			int idUser, int idCompeticao) {

		final String METHOD_NAME = "getNCacheFoundByUserOnCompetition ";

		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

		request.addProperty("idUser", idUser);
		request.addProperty("idCompetition", idCompeticao);

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

