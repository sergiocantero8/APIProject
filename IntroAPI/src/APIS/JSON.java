package APIS;
import org.json.*;

public class JSON 
{
	public static void main (String [] args)
	{
		JSONObject objeto = new JSONObject();
		JSONArray arrayJson = new JSONArray();
		objeto.put("nombre", "Gustavo");
		objeto.put("apellido", "Vargas");
		objeto.put("Edad", 31);
		objeto.put("Ciudad", "Barcelona");
		arrayJson.put(objeto);
		String stringJson = objeto.toString();
		System.out.println(objeto);
		System.out.println(arrayJson);
		System.out.println(stringJson);
		System.out.println("------------------------- SALTO DE LINEA -------------------------");
		String cadenaDeCaracteres = "{\"nombre\":\"Gustavo\", \"apellido\":\"Vargas\",\"edad\":30}";
		System.out.println(cadenaDeCaracteres);
		JSONObject json_objecto = new JSONObject(cadenaDeCaracteres);
		System.out.println(json_objecto);
		String nombre = json_objecto.getString("nombre");
		String apellido = json_objecto.getString("apellido");
		int edad = json_objecto.getInt("edad");
		System.out.println(nombre);
		System.out.println(apellido);
		System.out.println(edad);
		System.out.println("El nombre del usuario es: " + nombre + " " + "y el apellido es: " + apellido + " " + "y la edad es: "+ edad);
	}
}