package PruebasJunit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.Test;

/*
Ejercicio 5:
Considere una clase llamada EmailValidator que se encarga de validar direcciones de correo electrónico. Donde el usuario ingresa su email y su edad por consola. 
El método principal de esta clase es emailEsValido, que toma una cadena de texto como entrada y devuelve un valor booleano que indica si la dirección de correo electrónico es válida o no.
Escribe pruebas unitarias para la clase EmailValidator que cubran diferentes escenarios posibles. A continuación se muestra un ejemplo de cómo podrían verse algunas de estas pruebas.
Ademas, de las pruebas unitarias, realizar pruebas funcionales de borde para los valores de la edad ingresados. 
Realizarlo para al menos 5 usuarios.

ENTREGABLES:
- Codigo del proyecto.
*/

public class EmailValidator {
	
	// Función para validar el email
	public boolean emailEsValido(String email) {
		
        // Expresión regular para validar el email
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        
        return email.matches(emailRegex);

	}
	
	//Función para validar la edad
	public boolean edadEsValida(int edad) {
        
        return (edad >0 && edad < 130) ;
    }
	

	
	@Test
	public void doTests() {
		
		// Variables de edad y email
		String email;
		int edad;
		
	    //Creación de objeto para pedir entrada de usuario
	    Scanner entrada = new Scanner (System.in); 
		
	    EmailValidator emailV = new EmailValidator();
	    do {
		    System.out.println ("Introduzca un email (F para terminar):");
		    email = entrada.next(); 
		    
		    System.out.println ("Introduzca la edad :");
		    edad = entrada.nextInt(); 
		    
			//Test Unitarios
			
			// Test para comprobar si el email es valido
			assertTrue(emailV.emailEsValido(email));
			
			
			
			//Test para comprobar que el email no es válido
			assertFalse(emailV.emailEsValido("email_novalido"));
			
			
			//Test para comprobar si la edad es valida
			assertTrue(emailV.edadEsValida(edad));
			
			//Pruebas Funcionales
			
			//Test para comprobar el límite de edad superior
			assertFalse(emailV.edadEsValida(131));
			
			
			//Test para comprobar el límite de edad inferior
			assertFalse(emailV.edadEsValida(-1));
			
	    	
	    }while(email!="F");

		
		

	}

	public void main(String[] args) {   

	}

}
