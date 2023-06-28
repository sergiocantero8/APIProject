package Test;

import static org.junit.Assert.assertEquals;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;
import org.junit.Test;

import APIS.REST;

/*
En base a lo aprendido a lo largo del curso, debe generar un programa que se conecte a la siguiente API mediante el uso de REST. https://www.boredapi.com/api/activity
Y se deben generar (y almacenar) 10 actividades para realizar, las mismas se deben almacenar en un fichero de salida llamado “recomendación_hoy”
Agregarle también una prueba unitaría que valide si se conecto bien o no la api.
Entregables:
-	Codigo del proyecto
-	Fichero de salida
*/


public class Test1
{
	
	@Test
	public void doTest() throws IOException{
		try {
			
			// Guardamos la URL 
			URL url  = new URL("https://www.boredapi.com/api/activity");
			
			//Declarar la ruta y el nombre de archivo con la extension del mismo
			String ruta = "C:\\Users\\Sergio.AZANON-CANTER\\git\\recomendacion_hoy.txt";
			
			// Abrimos la conexión con la API, establecemos el método GET para la petición y nos conectamos
			HttpURLConnection conn= (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			
			// Obtenemos el código de respuesta
			int responseCode = conn.getResponseCode();
			
			// Si el código de respuesta es válido 
			if(responseCode !=200) {
				throw new RuntimeException("HTTPSResponseCode:" + responseCode);
			}else
			{
				// Creamos la variable para almacenar la información
				StringBuilder informacion = new StringBuilder();
				Scanner sc = new Scanner(url.openStream());
				
				// Creamos el objeto para crear el archivo
				File archivo = new File(ruta);
				
				// Creamos el archivo si no existe
				if(!archivo.exists()){
					//Metodo createNewFile() para crear el archivo.
					archivo.createNewFile(); 
				}
				
				// Encargado de la lectura
				FileWriter fw = new FileWriter(archivo); //El FileWriter es el encargado de 
				
				// Encargado de la escritura
				BufferedWriter bw = new BufferedWriter(fw); //BufferedWritter es el encargado de realizar la acción de escritura.

				
				
				// Creamos el bucle para que itere 10 veces para cada una de las actividades
				for(int i=1; i<=10; i++) {
					while (sc.hasNext())
					{
						informacion.append(sc.nextLine());
					}
					
					// Lo convertimos a JSON y extraemos la actividad
					JSONObject infoJSON = new JSONObject(informacion.toString());
					String actividad= infoJSON.getString("activity");
					
					// Escribimos en el archivo
					bw.write("Actividad " + i + ":");
					bw.write(actividad);
					bw.write("\n");
					
					// Realizamos otra petición GET a la misma URL
					sc = new Scanner(url.openStream());
					
					// Borramos la información que se hubiera almacenado
					informacion.setLength(0);
					
					
				}
				
				// Cerramos la escritura
				bw.close();

				
				// Cerramos la escritura
				sc.close();		
				
			}
			
			// Para validar que el tiempo de respuesta sea 200
			assertEquals(200, responseCode);

			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	 
	// Función main
	public static void main (String [] args)
	{
	     Test1 test = new Test1();
	        try {
	        	test.doTest();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
		
}