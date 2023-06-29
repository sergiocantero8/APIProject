package PruebasJunit;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
* Pruebas de integración (Integration Testing):
 * Las pruebas de integración se realizan para verificar que los diferentes componentes
 * o modulos de una aplicación funcionen correctamente juntos. Se pueden
 * utilizar frameworks como JUnit o herramientas como Mockito para simular o emular dependencias
 * y realizar pruebas de integración
*/
public class PruebasIntegracion 
{
	@Test
	//Ejemplo 1: Conexion a una base de datos
	public void testConexionBaseDeDatos()
	{
		try 
		{
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/master", "gustavo", "gustavo");
			//Verifico que la conexion sea exitosa. 
			assertFalse(connection.isClosed());
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	//Ejemplo 2: Pruebas de consumo orientado a un servicio web (RESTful, SOAP) 
	@Test
	public void testServicioWeb()
	{
		try {
			URL url = new URL("https://api.open-meteo.com/v1/forecast?latitude=40.42&longitude=-3.70&hourly=temperature_2m");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder respuesta = new StringBuilder();
			String lineas;
			while ((lineas = reader.readLine()) != null)
			{
				respuesta.append(lineas);
			}
			reader.close();
			assertTrue(respuesta.toString().contains("Clima"));
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	//Ejemplo 3: Servicio externo: Los servicios externos son todos
	//aquellos servicios/microservicios ajenos al codigo en si.
	// Por ejemplo. Servicios WEB, Bases de datos externas, Sistemas de colas de mensajes, Servicios de almacenamientos en la nube
	public void testServicioExterno()
	{
		ExternalService  externalService = new ExternalService ();
		String respuesta = externalService.callExternalService();
		assertNotNull(respuesta);
	}
	
	//Ejemplo 4: Colas de mensajes: 
	
	Las colas de mensajes son una comunicación asincronica entre componentes
	de un sistema distribuido. 
	En una cola de mensajes, los componentes pueden enviar mensajes
	a la cola sin esperar una respuesta inmediata. Estos mensajes
	se almacenan en la cola en el orden que se reciben y se mantienen
	alli hasta que son consumidos por los componentes que los reciben.

	
	private MessageProducer messageProducer;
	private MessageConsumer messageConsumer;
	
	@Test
	public void testMensajesEnCola() throws InterruptedException
	{
		//Envia un mensaje a la cola de mensajes
		messageProducer.sendMessage("Hola hola");
		//Seteamos el tiempo para que el consumidor procese el mensaje.
		Thread.sleep(2000);
		//Verificamos que el consumidor haya recibido y procesado el mensaje.
		assertTrue(messageConsumer.isMessageReceived());
	}
	*/
}
