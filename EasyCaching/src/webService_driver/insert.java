package webService_driver;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class insert {
	private static final String NAMESPACE = "http://insert_update/"; 
	public static void  createComp(String name, String date, String local) {
		{
			final String URL = URLs.URL+"insertCompetition";
			final String METHOD_NAME = "putNewCompetition";

			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

			request.addProperty("name", name);
			request.addProperty("date", date);
			request.addProperty("local", local);
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
					SoapEnvelope.VER11);

			envelope.setOutputSoapObject(request);
			HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
			
			try {
				androidHttpTransport.call(URLs.SOAP_ACTION, envelope);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			//return -1;
		}

	}

	public static void createCache(String name, String description,
			String hint, double d, double f, double g, int IdCompeticao,
			int IDUser, double h, double i) {
		{
			final String URL = URLs.URL+"insertCache";
			final String METHOD_NAME = "putNewCacheTraditional";

			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

			request.addProperty("name", name);
			request.addProperty("description", description);
			request.addProperty("hint", hint);
			request.addProperty("terrain", Double.toString(d));
			request.addProperty("difficulty", Double.toString(f));
			request.addProperty("size", Double.toString(g));
			request.addProperty("IdCompeticao", IdCompeticao);
			request.addProperty("IDUser", IDUser);
			request.addProperty("latitude", Double.toString(h));
			request.addProperty("longitude", Double.toString(i));

			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
					SoapEnvelope.VER11);

			envelope.setOutputSoapObject(request);
			HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

			try {
				androidHttpTransport.call(URLs.SOAP_ACTION, envelope);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public static void insertUserCompetition(int IDUser, int IDCompetition) {

		final String URL = URLs.URL+"insertCompetition";
		final String METHOD_NAME = "putUserCompetition";

		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

		request.addProperty("IDUser", IDUser);
		request.addProperty("IDCompetition", IDCompetition);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);

		envelope.setOutputSoapObject(request);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			androidHttpTransport.call(URLs.SOAP_ACTION, envelope);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void insertCacheFound(int IdUser, int idCache) {

		final String URL = URLs.URL+"insertCacheFound";
		final String METHOD_NAME = "putFoundCache";

		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

		request.addProperty("IdUser", IdUser);
		request.addProperty("idCache", idCache);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);

		envelope.setOutputSoapObject(request);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			androidHttpTransport.call(URLs.SOAP_ACTION, envelope);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void updateCoordenadaByUserID(int idUser, double d, double f) {

	
		final String URL = URLs.URL+"insertCoordenate";
		final String METHOD_NAME = "updateCoordenadaByUserID";

		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

		request.addProperty("idUser", idUser);
		request.addProperty("longitude", Double.toString(d));
		request.addProperty("latitude", Double.toString(f));

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);

		envelope.setOutputSoapObject(request);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			androidHttpTransport.call(URLs.SOAP_ACTION, envelope);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void insertUser(String username) {

		final String URL = URLs.URL+"insertUser";
		final String METHOD_NAME = "putUser";

		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

		request.addProperty("username", username);
		
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);

		envelope.setOutputSoapObject(request);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			androidHttpTransport.call(URLs.SOAP_ACTION, envelope);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
