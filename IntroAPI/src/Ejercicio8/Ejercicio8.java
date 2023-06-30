package Ejercicio8;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * 
Ejercicio 8 - Maximum Integration between Java and Database: 
Programa:
Nos contrataron de la empresa Spotify para desarrollarles un programa nuevo que conecte con una base de datos.
En lo referido al programa, debe poder almacenar la siguiente información por consola:
- Nombre del artista
- Genero
- Cantidad de canciones
- Cantidad de reproducciones
- Cantidad de suscriptores

Se debe generar 1 función que calcule la ganancia total del artista, la misma se calcula de la siguiente manera: Ganancia total = cantidad de reproducciones * 0.02 
(!)  Generarlo para al menos 3 artistas (!)
La información se debe imprimir en un TXT de salida. 

Base de datos:
El programa tambien almacena la información de los usuarios que se registran en la plataforma, donde el
usuario al momento de registrarse almacena la siguiente información:
- Nombre
- Apellido
- Nombre del usuario
- Email
- ID Usuario
- Fecha de nacimiento 
(!) La tabla debe contener al menos 3 usuarios registrados (!)

ENTREGABLES:
- Script de SQL que genere la tabla y  los usuarios.
- Codigo del proyecto FUNCIONAL.
 */
public class Ejercicio8 {

	public static void main(String[] args) {

		try {

			// Creación de objeto para pedir entrada de usuario
			Scanner entrada = new Scanner(System.in);

			// Ruta del txt de salida
			String ruta_salida = "C:\\Users\\Sergio.AZANON-CANTER\\git\\info_artista.txt";

			// Creamos el objeto para crear el archivo
			File archivo = new File(ruta_salida);

			// Creamos el archivo si no existe
			if (!archivo.exists()) {
				// Metodo createNewFile() para crear el archivo.
				archivo.createNewFile();
			}

			// Encargado de la escritura
			BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));

			bw.write("Nombre\t" + "Genero\t" + "Numero reproducciones\t" + "Numero canciones\t"
					+ "Numero suscriptores\t" + "Ganancia total\n");

			// Crear 3 artistas
			for (int i = 1; i <=3; i++) {

				// Nombre del artista
				System.out.print("Nombre del artista: ");
				String nombreArtista = entrada.nextLine();

				System.out.print("Genero: ");
				String genero = entrada.nextLine();

				System.out.print("Numero de reproducciones: ");
				Integer nReproducciones = Integer.parseInt(entrada.nextLine());

				System.out.print("Numero de canciones: ");
				Integer nCanciones = Integer.parseInt(entrada.nextLine());

				System.out.print("Numero de suscriptores: ");
				Integer nSuscriptores = Integer.parseInt(entrada.nextLine());

				Artista artista = new Artista(nombreArtista, genero, nReproducciones, nCanciones, nSuscriptores);

				bw.write(artista.getNombre() + "\t" + artista.getGenero() + "\t" + artista.getnReproducciones() + "\t"
						+ artista.getnCanciones() + "\t" + artista.getnSuscriptores() + "\t"
						+ artista.calcularGananciaTotal() + "\n");
				

			}

			entrada.close();
			
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
