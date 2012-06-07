package pt.ua.easyCaching;

import java.sql.Date;
import java.util.ArrayList;

//import my.Entities.Competition;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class ConnectWebService {

	final static String ip = "192.168.1.10:8080";
	public static float[] getCoordinatesFromUser(int uId) {

		final String NAMESPACE = "http://get.easyCaching/";
		
		final String URL = "http://"+ip+"/OpenCaching/Coordenadas";
		final String SOAP_ACTION = "";
		final String METHOD_NAME = "getCoordenatesUserById";

		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
		request.addProperty("IdUser", uId);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);

		envelope.setOutputSoapObject(request);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			androidHttpTransport.call(SOAP_ACTION, envelope);

			SoapObject resultsRequestSOAP = (SoapObject) envelope.bodyIn;
			String latitude = resultsRequestSOAP.getProperty(0).toString();
			String longitude = resultsRequestSOAP.getProperty(1).toString();

			float[] coord = new float[2];
			coord[0] = Float.parseFloat(latitude);
			coord[1] = Float.parseFloat(longitude);

			return coord;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void  createComp(String name, String date, String local) {
		{
			final String NAMESPACE = "http://put.easyCaching/";
			final String URL = "http://"+ip+"/OpenCaching/NewCompetition";
			final String SOAP_ACTION = "";
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
				androidHttpTransport.call(SOAP_ACTION, envelope);
				//SoapObject resultsRequestSOAP = (SoapObject) envelope.bodyIn;
				//String id = resultsRequestSOAP.getProperty(1).toString();
				

				//return Integer.parseInt(id);

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
			final String NAMESPACE = "http://put.easyCaching/";
			final String URL = "http://"+ip+"/OpenCaching/NewCache";
			final String SOAP_ACTION = "";
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
				androidHttpTransport.call(SOAP_ACTION, envelope);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public static void insertUserCompetition(int IDUser, int IDCompetition) {

		final String NAMESPACE = "http://put.easyCaching/";
		final String URL = "http://"+ip+"/OpenCaching/NewCompetition";
		final String SOAP_ACTION = "";
		final String METHOD_NAME = "putUserCompetition";

		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

		request.addProperty("IDUser", IDUser);
		request.addProperty("IDCompetition", IDCompetition);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);

		envelope.setOutputSoapObject(request);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			androidHttpTransport.call(SOAP_ACTION, envelope);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void insertCacheFound(int IdUser, int idCache) {

		final String NAMESPACE = "http://put.easyCaching/";
		final String URL = "http://"+ip+"/OpenCaching/cacheFound";
		final String SOAP_ACTION = "";
		final String METHOD_NAME = "putFoundCache";

		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

		request.addProperty("IdUser", IdUser);
		request.addProperty("idCache", idCache);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);

		envelope.setOutputSoapObject(request);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			androidHttpTransport.call(SOAP_ACTION, envelope);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void updateCoordenadaByUserID(int idUser, double d, double f) {

		final String NAMESPACE = "http://put.easyCaching/";
		final String URL = "http://"+ip+"/OpenCaching/NewCoordenadas";
		final String SOAP_ACTION = "";
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
			androidHttpTransport.call(SOAP_ACTION, envelope);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void insertUser(String username) {

		final String NAMESPACE = "http://put.easyCaching/";
		final String URL = "http://"+ip+"/OpenCaching/NewUser";
		final String SOAP_ACTION = "";
		final String METHOD_NAME = "putUser";

		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

		request.addProperty("username", username);
		
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);

		envelope.setOutputSoapObject(request);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			androidHttpTransport.call(SOAP_ACTION, envelope);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Competition> getCompetition() {

		final String NAMESPACE = "http://get.easyCaching/";
		final String URL = "http://"+ip+"/OpenCaching/Competicao";
		final String SOAP_ACTION = "";
		final String METHOD_NAME = "getFutureCompetions";

		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

		//request.addProperty("username", username);
		
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);

		envelope.setOutputSoapObject(request);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			androidHttpTransport.call(SOAP_ACTION, envelope);
			SoapObject resultsRequestSOAP = (SoapObject) envelope.bodyIn;
			ArrayList<Competition> comps=new ArrayList();
			
			
			
			for(int i=0; i<resultsRequestSOAP.getPropertyCount();i++){
				SoapObject object=(SoapObject) resultsRequestSOAP.getProperty(i);
				Competition co=new Competition();
				co.setDatainicio(object.getProperty(0).toString());
				co.setIdcompeticao(Integer.parseInt(object.getProperty(1).toString()));
				co.setLocalprova(object.getProperty(2).toString());
				co.setNome(object.getProperty(3).toString());
				comps.add(co);
				}
			
				
			return comps;
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<Cache> getCache(int idCompeticao) {

		final String NAMESPACE = "http://get.easyCaching/";
		final String URL = "http://"+ip+"/OpenCaching/caches";
		final String SOAP_ACTION = "";
		final String METHOD_NAME = "getAllCachesForCompetition";

		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

		request.addProperty("competitionId", idCompeticao);
		
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);

		envelope.setOutputSoapObject(request);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			androidHttpTransport.call(SOAP_ACTION, envelope);
			SoapObject resultsRequestSOAP = (SoapObject) envelope.bodyIn;
//			resultsRequestSOAP=(SoapObject) resultsRequestSOAP.getProperty(0);/*caches*/
//			resultsRequestSOAP=(SoapObject) resultsRequestSOAP.getProperty(0);/*cache*/
//			resultsRequestSOAP=(SoapObject) resultsRequestSOAP.getProperty(0);/*ok*/
			
			ArrayList<Cache> comps=new ArrayList();
			
			
			
			for(int i=0; i<resultsRequestSOAP.getPropertyCount();i++){
				SoapObject object=(SoapObject) resultsRequestSOAP.getProperty(i);
				Cache ca=new Cache();
				ca.setDescricao(object.getProperty(0).toString());
				ca.setDifficulty(Float.parseFloat(object.getProperty(1).toString()));
				ca.setHint(object.getProperty(2).toString());
				ca.setIdCache(Integer.parseInt(object.getProperty(3).toString()));
				ca.setLatitude(Float.parseFloat(object.getProperty(4).toString()));
				ca.setLongitude(Float.parseFloat(object.getProperty(5).toString()));
				ca.setNome(object.getProperty(6).toString());
				ca.setOwner(object.getProperty(7).toString());
				ca.setSize(Float.parseFloat(object.getProperty(8).toString()));
				ca.setTerrain(Float.parseFloat(object.getProperty(9).toString()));
				
				comps.add(ca);
				}
			
				
			return comps;
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<User> getUserbyComp(int idCompeticao) {

		final String NAMESPACE = "http://get.easyCaching/";
		final String URL = "http://"+ip+"/OpenCaching/User";
		final String SOAP_ACTION = "";
		final String METHOD_NAME = "getUserByComp";

		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

		request.addProperty("compId", idCompeticao);
		
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);

		envelope.setOutputSoapObject(request);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			androidHttpTransport.call(SOAP_ACTION, envelope);
			SoapObject resultsRequestSOAP = (SoapObject) envelope.bodyIn;
//			resultsRequestSOAP=(SoapObject) resultsRequestSOAP.getProperty(0);/*caches*/
//			resultsRequestSOAP=(SoapObject) resultsRequestSOAP.getProperty(0);/*cache*/
//			resultsRequestSOAP=(SoapObject) resultsRequestSOAP.getProperty(0);/*ok*/
			
			ArrayList<User> comps=new ArrayList();
			
			
			
			for(int i=0; i<resultsRequestSOAP.getPropertyCount();i++){
				SoapObject object=(SoapObject) resultsRequestSOAP.getProperty(i);
				User ca=new User();
				ca.setUserId(Integer.parseInt(object.getProperty(0).toString()));
				ca.setLatitude(Float.parseFloat(object.getProperty(1).toString()));
				ca.setLongitude(Float.parseFloat(object.getProperty(2).toString()));
				ca.setUsername(object.getProperty(3).toString());
				
				
				comps.add(ca);
				}
			
				
			return comps;
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}