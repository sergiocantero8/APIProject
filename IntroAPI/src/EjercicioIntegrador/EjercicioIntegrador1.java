package EjercicioIntegrador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
EJERCICIO INTEGRADOR 1:
Nos contrataron de la empresa aeronáutica Iberia para poder estandarizar y sistematizar la información que tienen hoy en día en un TXT
-	Nombre del vuelo
-	Cantidad de pasajeros
-	Tipo de pasaje
-	Valor unitario del pasaje

Generar una salida que calcule lo siguiente:
ValorFinalPorVuelo = ValorUnitario * Cant Pasajeros
Segmentación ->
Si Tipo_pasaje = Económico && ValorFinalPorVuelo > 100 Entonces es Rentable
Si Tipo_pasaje = Económico && ValorFinalPorVuelo < 100 Entonces es No Rentable
Si Tipo_pasaje = Premier && ValorFinalPorVuelo > 1500 Entonces es Rentable
Si Tipo_pasaje = Premier && ValorFinalPorVuelo < 1500 Entonces no es Rentable
Para los que no esten dentro de estas definiciones, el mensaje debe ser "A CONFIRMAR"
El programa debe implementar lo siguiente:
- Clases
(!) DEBE GENERAR UN FICHERO DE SALIDA CON LO PROVISTO EN EL TXT Y CON LO AGREGADO DENTRO DEL PROGRAMA (!)

ENTREGABLES:
- Codigo del proyecto.
 * 
 * 
 */
public class EjercicioIntegrador1 {

	public static void main(String[] args) {
		try {
			// Ruta del txt de entrada
			File documento = new File("C:\\\\Users\\\\Sergio.AZANON-CANTER\\\\git\\\\INFO_VUELOS.txt");
			BufferedReader leer_fichero = new BufferedReader(new FileReader(documento));
			String linea = "";
			boolean primeraLinea = true;
			
			
			//Ruta del txt de salida
			String ruta_salida = "C:\\Users\\Sergio.AZANON-CANTER\\git\\INFO_VUELO_EXTRA.txt";
			
			// Creamos el objeto para crear el archivo
			File archivo = new File(ruta_salida);
			
			// Creamos el archivo si no existe
			if(!archivo.exists()){
				//Metodo createNewFile() para crear el archivo.
				archivo.createNewFile(); 
			}
			
			// Encargado de la escritura
			BufferedWriter bw = new BufferedWriter(new FileWriter(archivo)); 
			
			// Bucle donde leeremos del fichero txt
			while ((linea = leer_fichero.readLine()) != null) {

				// Omitir el procesamiento de la primera línea
				if (primeraLinea) {
					primeraLinea = false;
					bw.write(linea);
					bw.write("\n");
					continue;
				}

				// Eliminar espacios en blanco al final de la línea
				linea = linea.trim();

				// Omitir líneas vacías
				if (linea.isEmpty()) {
					continue;
				}

				// El delimitador es una tabulación (\t)
				String[] valores = linea.split("\t");

				// Leer cada valor por separado
				String nombreVuelo = valores[0];

				// Valor predeterminado en caso de cadena vacía o inválida
				int cantPasajeros = 0;

				// Si no está vacío parseamos ya que si no saltaría una excepción
				if (!valores[1].isEmpty()) {
					cantPasajeros = Integer.parseInt(valores[1]);
				}

				String tipoPasaje = valores[2];

				int valorUnitario = Integer.parseInt(valores[3]);

				// Se crea el objeto vuelo con todos los datos obtenidos del txt
				Vuelo vuelo = new Vuelo(nombreVuelo, cantPasajeros, tipoPasaje, valorUnitario);

				// Obtenemos el valor final por vuelo
				int valorFinalPorVuelo = vuelo.getValorFinalPorVuelo();

				// Con las casuhísticas del enunciado verificamos que valor tiene la segmentacion
				String segmentacion = "A CONFIRMAR";
				
				if (tipoPasaje == "ECONOMICO" && valorFinalPorVuelo > 100)
					segmentacion = "RENTABLE";
				else if (tipoPasaje == "ECONOMICO" && valorFinalPorVuelo < 100)
					segmentacion = "NO RENTABLE";
				else if (tipoPasaje == "PREMIER" && valorFinalPorVuelo > 1500)
					segmentacion = "RENTABLE";
				else if (tipoPasaje == "PREMIER" && valorFinalPorVuelo < 1500)
					segmentacion = "NO RENTABLE";

				DatosExtraVuelo datosExtraVuelo = new DatosExtraVuelo(nombreVuelo, cantPasajeros, tipoPasaje, valorUnitario, valorFinalPorVuelo, segmentacion);

				// Mostramos la información por consola
				System.out.println(datosExtraVuelo.toString());
				
				// Escribimos la informacion del vuelo		
				bw.write(datosExtraVuelo.toString());
				bw.write("\n");

				
			}
			// Cerramos la escritura
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
