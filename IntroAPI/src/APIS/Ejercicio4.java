package APIS;



import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Provider.Service;
import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.junit.Test;

/*
Ejercicio 4
Desarrollar un programa que consuma servicios de SOAP del siguiente endpoint:
http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso
que informe lo siguiente CountryName, CountryCurrency, FullCountryInfo, LanguageName
de los paises de los siguientes codigos:
- AR
- ES 
- CU
- BR

ENTREGABLES:
- Codigo del proyecto.
(referencia de codigo de paises: https://www.datosmundial.com/codigos-de-pais.php)
*/


public class Ejercicio4 
{
	
	
	// Creamos una función privada para crear el mensaje SOAP
    private static SOAPMessage createSOAPMessage(String endpoint, String type, String childElement, String countryCode) throws SOAPException {
        SOAPMessage soapMessage = MessageFactory.newInstance().createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();
        SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
        SOAPBody soapBody = soapEnvelope.getBody();

        SOAPElement operationElement = soapBody.addChildElement(type, "", "http://www.oorsprong.org/websamples.countryinfo");
        SOAPElement countryElement = operationElement.addChildElement(childElement);
        countryElement.addTextNode(countryCode);
   

        soapMessage.saveChanges();

        return soapMessage;
    }
    
    // Creamos una función privada para obtener la respuesta SOAP
    private static String getSOAPResponse(SOAPMessage soapResponse, String responseElementName) throws SOAPException {
        SOAPBody responseBody = soapResponse.getSOAPBody();
        SOAPElement responseElement = (SOAPElement) responseBody.getElementsByTagName(responseElementName).item(0);
        
        return (responseElement == null) ? responseBody.getTextContent() : responseElement.getTextContent();
    }
    
    @Test
    public void doExercise4() throws IOException{
    	try {
			String endpoint = "http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso";
			
			//Creamos la conexion
			SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
			SOAPConnection soapConnection = soapConnectionFactory.createConnection();
					

            
            // En cada operación crea un mensaje SOAP, realiza la llamada y obtiene la respuesta 
			
            // CÓDIGO DE ESPAÑA (ES)
			
			// CountryName
			
            SOAPMessage cNameMessage = createSOAPMessage(endpoint, "CountryName", "sCountryISOCode", "ES");
            SOAPMessage cNameResponse = soapConnection.call(cNameMessage, endpoint);
            String cNameResult = getSOAPResponse(cNameResponse, "CountryNameResponse");
            System.out.println("Nombre del país: " + cNameResult);
            
            // CountryCurrency
            SOAPMessage cCurrMessage = createSOAPMessage(endpoint, "CountryCurrency", "sCountryISOCode", "ES");
            SOAPMessage cCurrResponse = soapConnection.call(cCurrMessage, endpoint);
            String cCurrResult = getSOAPResponse(cCurrResponse, "CountryCurrencyResponse");
            System.out.println("Moneda del país: " + cCurrResult);
            
            
            // FullCountryInfo
            SOAPMessage cInfoMessage = createSOAPMessage(endpoint, "FullCountryInfo", "sCountryISOCode", "ES");
            SOAPMessage cInfoResponse = soapConnection.call(cInfoMessage, endpoint);
            String cInfoResult = getSOAPResponse(cInfoResponse, "CountryCurrencyResponse");
            System.out.println("Información del país: " + cInfoResult);
            
            
            // LanguageName
            SOAPMessage cLanMessage = createSOAPMessage(endpoint, "LanguageName", "sISOCode", "ES");
            SOAPMessage cLanResponse = soapConnection.call(cLanMessage, endpoint);
            String cLanResult = getSOAPResponse(cLanResponse, "LanguageNameResponse");
            System.out.println("Idioma del país: " + cLanResult);
            
            
            // CÓDIGO DE ARGENTINA (AR)
			
			// CountryName
			
            SOAPMessage cNameMessage2 = createSOAPMessage(endpoint, "CountryName", "sCountryISOCode", "AR");
            SOAPMessage cNameResponse2 = soapConnection.call(cNameMessage2, endpoint);
            String cNameResult2 = getSOAPResponse(cNameResponse2, "CountryNameResponse");
            System.out.println("Nombre del país: " + cNameResult2);
            
            // CountryCurrency
            SOAPMessage cCurrMessage2 = createSOAPMessage(endpoint, "CountryCurrency", "sCountryISOCode", "AR");
            SOAPMessage cCurrResponse2 = soapConnection.call(cCurrMessage2, endpoint);
            String cCurrResult2 = getSOAPResponse(cCurrResponse2, "CountryCurrencyResponse");
            System.out.println("Moneda del país: " + cCurrResult2);
            
            
            // FullCountryInfo
            SOAPMessage cInfoMessage2 = createSOAPMessage(endpoint, "FullCountryInfo", "sCountryISOCode", "AR");
            SOAPMessage cInfoResponse2 = soapConnection.call(cInfoMessage2, endpoint);
            String cInfoResult2 = getSOAPResponse(cInfoResponse2, "CountryCurrencyResponse");
            System.out.println("Información del país: " + cInfoResult2);
            
            
            // LanguageName
            SOAPMessage cLanMessage2 = createSOAPMessage(endpoint, "LanguageName", "sISOCode", "AR");
            SOAPMessage cLanResponse2 = soapConnection.call(cLanMessage2, endpoint);
            String cLanResult2 = getSOAPResponse(cLanResponse2, "LanguageNameResponse");
            System.out.println("Idioma del país: " + cLanResult2);
            
            
            // CÓDIGO DE CUBA (CU)
			
			// CountryName
			
            SOAPMessage cNameMessage3 = createSOAPMessage(endpoint, "CountryName", "sCountryISOCode", "CU");
            SOAPMessage cNameResponse3 = soapConnection.call(cNameMessage3, endpoint);
            String cNameResult3 = getSOAPResponse(cNameResponse3, "CountryNameResponse");
            System.out.println("Nombre del país: " + cNameResult3);
            
            // CountryCurrency
            SOAPMessage cCurrMessage3 = createSOAPMessage(endpoint, "CountryCurrency", "sCountryISOCode", "CU");
            SOAPMessage cCurrResponse3 = soapConnection.call(cCurrMessage3, endpoint);
            String cCurrResult3 = getSOAPResponse(cCurrResponse3, "CountryCurrencyResponse");
            System.out.println("Moneda del país: " + cCurrResult3);
            
            
            // FullCountryInfo
            SOAPMessage cInfoMessage3 = createSOAPMessage(endpoint, "FullCountryInfo", "sCountryISOCode", "CU");
            SOAPMessage cInfoResponse3 = soapConnection.call(cInfoMessage3, endpoint);
            String cInfoResult3 = getSOAPResponse(cInfoResponse3, "CountryCurrencyResponse");
            System.out.println("Información del país: " + cInfoResult3);
            
            
            // LanguageName
            SOAPMessage cLanMessage3 = createSOAPMessage(endpoint, "LanguageName", "sISOCode", "CU");
            SOAPMessage cLanResponse3 = soapConnection.call(cLanMessage3, endpoint);
            String cLanResult3 = getSOAPResponse(cLanResponse3, "LanguageNameResponse");
            System.out.println("Idioma del país: " + cLanResult3);
            
            
            
            // CÓDIGO DE BRASIL (BR)
			
			// CountryName
			
            SOAPMessage cNameMessage4 = createSOAPMessage(endpoint, "CountryName", "sCountryISOCode", "BR");
            SOAPMessage cNameResponse4 = soapConnection.call(cNameMessage3, endpoint);
            String cNameResult4 = getSOAPResponse(cNameResponse4, "CountryNameResponse");
            System.out.println("Nombre del país: " + cNameResult4);
            
            // CountryCurrency
            SOAPMessage cCurrMessage4 = createSOAPMessage(endpoint, "CountryCurrency", "sCountryISOCode", "BR");
            SOAPMessage cCurrResponse4 = soapConnection.call(cCurrMessage4, endpoint);
            String cCurrResult4 = getSOAPResponse(cCurrResponse4, "CountryCurrencyResponse");
            System.out.println("Moneda del país: " + cCurrResult4);
            
            
            // FullCountryInfo
            SOAPMessage cInfoMessage4 = createSOAPMessage(endpoint, "FullCountryInfo", "sCountryISOCode", "BR");
            SOAPMessage cInfoResponse4 = soapConnection.call(cInfoMessage4, endpoint);
            String cInfoResult4 = getSOAPResponse(cInfoResponse4, "CountryCurrencyResponse");
            System.out.println("Información del país: " + cInfoResult4);
            
            
            // LanguageName
            SOAPMessage cLanMessage4 = createSOAPMessage(endpoint, "LanguageName", "sISOCode", "BR");
            SOAPMessage cLanResponse4 = soapConnection.call(cLanMessage4, endpoint);
            String cLanResult4 = getSOAPResponse(cLanResponse4, "LanguageNameResponse");
            System.out.println("Idioma del país: " + cLanResult4);
            
            

			soapConnection.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
    }
    
    // Main de la aplicación
	public static void main (String [] args){

		Ejercicio4 ejercicio4 = new Ejercicio4();
        try {
            ejercicio4.doExercise4();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
    
}
