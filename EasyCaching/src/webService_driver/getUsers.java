package webService_driver;
import java.util.ArrayList;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import Entities.User;

public class getUsers {
	private static final String NAMESPACE = "http://select/";
	private static final String URL = URLs.URL+"returnUser";
	public static ArrayList<User> getUserbyComp(int idCompeticao) {
		
		
		//
				final String METHOD_NAME = "getUsersByComp";
		
				SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
		
				request.addProperty("idCompetition", idCompeticao);
				
				SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
						SoapEnvelope.VER11);
		
				envelope.setOutputSoapObject(request);
				HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
		
				try {
					androidHttpTransport.call(URLs.SOAP_ACTION, envelope);
					SoapObject resultsRequestSOAP = (SoapObject) envelope.bodyIn;
					
					ArrayList<User> comps=new ArrayList<User>();
					
//					
//					
					for(int i=0; i<resultsRequestSOAP.getPropertyCount();i++){
						SoapObject object=(SoapObject) resultsRequestSOAP.getProperty(i);
						User ca=new User();
						ca.setIdUser(Integer.parseInt(object.getProperty("idUser").toString()));
						ca.setLatitude(Float.parseFloat(object.getProperty("latitude").toString()));
						ca.setLongitude(Float.parseFloat(object.getProperty("longitude").toString()));
						ca.setUserName(object.getProperty("userName").toString());
						
						
						comps.add(ca);
						}
//					
						if(comps.size()>0)
							return comps;
						
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}
}
