package BD;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
EJERCICIO 7:
Desarrollar un programa que permita a los usuarios almacenar a traves de la consola información sobre sus tareas. La aplicación permite a los usuarios crear tareas,
asignarles categorias, establecer fechas limites de entrega. 
Implementar al menos 2 clases que usen herencia de clases entre si
Hacerlo para al menos 5 tareas

ENTREGABLE:
- Codigo del proyecto.
*/
public class HacerTareas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Scanner scanner = new Scanner(System.in);

	     // Crear usuarios
	     Usuario usuario1 = new Usuario(1, "Pepe", "1234", "pepe@email.com");
	     Usuario usuario2 = new Usuario(2, "Laura", "1234", "laura@email.com");

		List<String> items = new ArrayList<>();
		
		// Crear 5 tareas
        for (int i = 1; i <= 5; i++) {
        	// Seremos el usuario 1 por ejemplo
        	System.out.println("Eres el usuario: " + usuario1.getUsername());
        	
        	// Vamos pidiendo los datos de las tareas
            System.out.println("Ingrese los detalles de la tarea " + i + ":");
        
            System.out.print("Nombre de Tarea: ");
            String nombreTarea = scanner.nextLine();

            System.out.print("Categoria: ");
            String categoria = scanner.nextLine();

            System.out.print("Fecha Límite: ");
            String fechaLimite = scanner.nextLine();

            System.out.print("¿La tarea está completada? (S/N): ");
            char completada = scanner.next().charAt(0);

            // Consumir el carácter de nueva línea pendiente
            scanner.nextLine();
            
            // Si se ha completado podemos poner un comentario
            if (completada == 'S') {
                System.out.print("Comentario: ");
                String comentario = scanner.nextLine();

                TareaCompletada tareaCompletada = new TareaCompletada(i, nombreTarea, categoria, fechaLimite, comentario);
                tareaCompletada.mostrarInformacion();
            } else {
                Tarea tarea = new Tarea(i, nombreTarea, categoria, fechaLimite);
                tarea.mostrarInformacion();
            }

        }

        scanner.close();
	}

}
