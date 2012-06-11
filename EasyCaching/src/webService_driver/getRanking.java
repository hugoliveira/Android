package webService_driver;

import java.util.ArrayList;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import Entities.Ranking;

public class getRanking {
	
		private static final String URL=URLs.URL+"returnRanking";
		private static final String NAMESPACE = "http://select/";
			public static ArrayList<Ranking> getRanking(int idCompeticao) {

			final String METHOD_NAME = "getRankingByComp";

			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

			request.addProperty("idCompetition", idCompeticao);
			
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
					SoapEnvelope.VER11);

			envelope.setOutputSoapObject(request);
			HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

			try {
				androidHttpTransport.call(URLs.SOAP_ACTION, envelope);
				SoapObject resultsRequestSOAP = (SoapObject) envelope.bodyIn;
//				resultsRequestSOAP=(SoapObject) resultsRequestSOAP.getProperty(0);/*caches*/
//				resultsRequestSOAP=(SoapObject) resultsRequestSOAP.getProperty(0);/*cache*/
//				resultsRequestSOAP=(SoapObject) resultsRequestSOAP.getProperty(0);/*ok*/
				
				ArrayList<Ranking> cs=new ArrayList<Ranking>();
						
				
				for(int i=0; i<resultsRequestSOAP.getPropertyCount();i++){
					SoapObject object=(SoapObject) resultsRequestSOAP.getProperty(i);
					Ranking ca=new Ranking();
					ca.setnFound(Integer.parseInt(object.getProperty("nFound").toString()));
					ca.setnHiden(Integer.parseInt(object.getProperty("nHiden").toString()));
					ca.setUsername(object.getProperty("username").toString());
					cs.add(ca);
					}
				
					if(cs.size()>0)
						return cs;
				
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
	

}

