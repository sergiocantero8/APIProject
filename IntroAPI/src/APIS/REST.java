package APIS;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import org.junit.Test;
import org.json.JSONArray;
import org.json.JSONObject;

/*
EJERCICIO 2:
Desarrollar un programa en Java que se conecte con la siguiente API: https://pokeapi.co/
el programa debe pasar un pokemon por parametro y mostrar la siguiente información del mismo por consola:
- Nombre
- Order
- Especie

Ademas de eso, se deben realizar las siguientes pruebas unitarias:
- assertEquals para validar que el valor sea "nombreDelPokemon"
- assertTrue para validar que el tiempo de respuesta sea mayor a 0
- assertEquals para validar que el tiempo de respuesta sea 200.
ENTREGABLES
- Codigo del proyecto enviado por correo.
*/

public class REST {
	
	@Test
	public void doExercise2() throws IOException {
		
		String pokemon;
	    //Creación de objeto para pedir entrada de usuario
	    Scanner entrada = new Scanner (System.in); 
	    
	     
	    System.out.println ("Introduzca el nombre de Pokemon:");
	    pokemon = entrada.next();  
	      
		try {
			URL url  = new URL("https://pokeapi.co/api/v2/pokemon/" + pokemon);
			HttpURLConnection conn= (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int responseCode = conn.getResponseCode();
			
			if(responseCode !=200) {
				throw new RuntimeException("HTTPSResponseCode:" + responseCode);
			}else
			{
				StringBuilder informacion = new StringBuilder();
				Scanner sc = new Scanner(url.openStream());
				while (sc.hasNext())
				{
					informacion.append(sc.nextLine());
				}
				JSONObject info_pokemon = new JSONObject(informacion.toString());
				//BigDecimal latitude= info.getBigDecimal("longitude");
				String nombrePokemon= info_pokemon.getString("name");
				Integer order= info_pokemon.getInt("order");
				String especie= info_pokemon.getJSONObject("species").getString("name");
				
				System.out.println("Nombre de Pokemon: "  + nombrePokemon + "\nOrden: " + order + "\nEspecie: " + especie );
				sc.close();
				
				// TEST UNITARIOS
				
				// Para validar que el valor introducido por teclado es el mismo que se recibe de la API
				assertEquals(pokemon, nombrePokemon);

				// Para validar que el tiempo de respuesta sea 200
				assertEquals(200, responseCode);
				

				// Para validar que la respuesta es mayor que 0
				assertTrue(info_pokemon.length() > 0);
				
			}
		}catch(MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
	     REST ejercicio2 = new REST();
	        try {
	            ejercicio2.doExercise2();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}

}


/*JUnit es un framework de pruebas unitarias para Java. Proporciona un conjunto
de bibliotecas y anotaciones que facilitan la escritura, ejecución y verificación
de pruebas automatizadas a nivel unitario.	
Las pruebas unitarias son pequeñas pruebas AUTOMATIZADAS que verifican el comportamiento
de una unidad de codigo (como por ejemplo, un metodo, una clase) de forma aislada,
sin depender de otros componentes o sistemas externos. 
Estas pruebas se centran en probar unidades especificas de codigo de manera exhaustiva,
buscando errores y asegurando que el codigo cumpla con los requisitos.
Aserciones:
Las aserciones son expresiones que se utilizan para verificar si un resultado esperado
es verdadero o falso. Tambien se lo conoce como una afirmación o afirmación de prueba.
En el contexto de JUnit, las aserciones son metodos estaticos proporcionados por la biblioteca
que te permitiran comparar valores y evaluar condiciones dentro de tus pruebas. 
Ejemplos de aserciones:
assertEquals(expected, actual): Compara dos valores para verifiar si son iguales o no.
Si son iguales, la prueba no falla, si no son iguales, la prueba falla.
assertTrue(Condicion): Verifica si una condicion es verdadera. Si la condición no es verdadera, la prueba falla
assertFalse(Condicion): Verifica si una condicion es falsa. Si la condicion es verdadera, la prueba falla.
assertNull(object): Verifica si un objeto es nulo. Si el objeto no es nulo, la prueba falla.
assertNotNull(object): Verifica si un objecto no es nulo. Si el objeto es nulo, la prueba falla.

*/
