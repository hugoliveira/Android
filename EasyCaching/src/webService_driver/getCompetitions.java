package webService_driver;

import java.util.ArrayList;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import Entities.Competition;

public class getCompetitions {
	private static final String NAMESPACE = "http://select/";
	private static final String URL = URLs.URL+"returnCompetition";
	
	public static ArrayList<Competition> getCompetition() {

		final String METHOD_NAME = "getAvailableCompetitions";

		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

		//request.addProperty("username", username);
		
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);

		envelope.setOutputSoapObject(request);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			androidHttpTransport.call(URLs.SOAP_ACTION, envelope);
			SoapObject resultsRequestSOAP = (SoapObject) envelope.bodyIn;
			ArrayList<Competition> comps=new ArrayList<Competition>();
			
			
			
			for(int i=0; i<resultsRequestSOAP.getPropertyCount();i++){
				SoapObject object=(SoapObject) resultsRequestSOAP.getProperty(i);
				Competition co=new Competition();
				co.setDate(object.getProperty("date").toString());
				co.setId(Integer.parseInt(object.getProperty("id").toString()));
				co.setLocal(object.getProperty("local").toString());
				co.setName(object.getProperty("name").toString());
				co.setNumCache(Integer.parseInt(object.getProperty("numCache").toString()));
				co.setNumUser(Integer.parseInt(object.getProperty("numUser").toString()));
				comps.add(co);
				}
			
				if(comps.size()>0)
					return comps;
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
