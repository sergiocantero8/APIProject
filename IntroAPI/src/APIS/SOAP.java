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
SOAP: Simple Object Access Protocol o "Protocolo simple de acceso"
es un protocolo de comunicación utilizado para intercambiar datos estructurados
en servicios web. SOAP define una forma estandar de codificar mensajes XML
que se envian y reciben en aplicaciones distribuidas. 

Se define una serie de reglas y estandares para construir mensajes SOAP,
como la estructura XML del mensaje, el formato de la solicitud y la respuesta,
y como se manejan los errores. 

EJERCICIO 3:
Desarrollar una aplicación que consulte a la API de REST http://dneonline.com/calculator.asmx
y realizar los 4 calculos que propone segun su documentación, ademas de esto, agregar 2 pruebas unitarias.
assertEquals
assertFalse / assertTrue

ENTREGABLES:
- Codigo del proyecto.
*/


public class SOAP 
{

	
	// Creamos una función privada para crear el mensaje SOAP
    private static SOAPMessage createSOAPMessage(String endpoint, String operation, int num1, int num2) throws SOAPException {
        SOAPMessage soapMessage = MessageFactory.newInstance().createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();
        SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
        SOAPBody soapBody = soapEnvelope.getBody();

        SOAPElement operationElement = soapBody.addChildElement(operation, "", "http://tempuri.org/");
        SOAPElement intAElement = operationElement.addChildElement("intA");
        intAElement.addTextNode(String.valueOf(num1));
        SOAPElement intBElement = operationElement.addChildElement("intB");
        intBElement.addTextNode(String.valueOf(num2));

        soapMessage.saveChanges();

        return soapMessage;
    }
    
    // Creamos una función privada para obtener la respuesta SOAP
    private static int getSOAPResponse(SOAPMessage soapResponse, String responseElementName) throws SOAPException {
        SOAPBody responseBody = soapResponse.getSOAPBody();
        SOAPElement responseElement = (SOAPElement) responseBody.getElementsByTagName(responseElementName).item(0);
        return Integer.parseInt(responseElement.getTextContent());
    }
    
    @Test
    public void doExercise3() throws IOException{
    	try {
			String endpoint = "http://dneonline.com/calculator.asmx";
			
			//Creamos la conexion
			SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
			SOAPConnection soapConnection = soapConnectionFactory.createConnection();
			
			//Creamos el mensaje SOAP
			MessageFactory messageFactory = MessageFactory.newInstance();
			SOAPMessage soapMessage = messageFactory.createMessage();
			
			
			// Realizar las operaciones
            int num1 = 10;
            int num2 = 5;

            
            // En cada operación crea un mensaje SOAP, realiza la llamada y obtiene la respuesta 
            // Suma (10 + 5)
            SOAPMessage sumMessage = createSOAPMessage(endpoint, "Add", num1, num2);
            SOAPMessage sumResponse = soapConnection.call(sumMessage, endpoint);
            int sumResult = getSOAPResponse(sumResponse, "AddResponse");
            System.out.println("Suma: " + sumResult);
            
           
            // Resta (10 - 5)
            SOAPMessage subMessage = createSOAPMessage(endpoint, "Subtract", num1, num2);
            SOAPMessage subResponse = soapConnection.call(subMessage, endpoint);
            int subResult = getSOAPResponse(subResponse, "SubtractResponse");
            System.out.println("Resta: " + subResult);
            
             // División (10/5)
            SOAPMessage divMessage = createSOAPMessage(endpoint, "Divide", num1, num2);
            SOAPMessage divResponse = soapConnection.call(divMessage, endpoint);
            int divResult = getSOAPResponse(divResponse, "DivideResponse");
            System.out.println("División: " + divResult);
            
            // Multiplicación (10*5)
            SOAPMessage mulMessage = createSOAPMessage(endpoint, "Multiply", num1, num2);
            SOAPMessage mulResponse = soapConnection.call(mulMessage, endpoint);
            int mulResult = getSOAPResponse(mulResponse, "MultiplyResponse");
            System.out.println("Multiplicación: " + mulResult);

			
	
            // Validamos la suma, resta, división y multiplicación
    		assertEquals(15, sumResult);
    		assertEquals(5, subResult);
    		assertEquals(2, divResult);
    		assertEquals(50, mulResult);
            

			soapConnection.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
    }
    
    // Main de la aplicación
	public static void main (String [] args){

		SOAP ejercicio3 = new SOAP();
        try {
            ejercicio3.doExercise3();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
    
}
