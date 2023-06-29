package PruebasJunit;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
/*
 * Pruebas funcionales (Functional Testing) O  pruebas de caja negra:
 * Las pruebas funcionales se enfocan en verificar que la aplicación cumpla con los
 * requisitos y funcionalidades esperadas. Pueden realizarse pruebas manuales o utilizar herramientas
 * de automatización de pruebas como Selenium, Cucumber o JBehave para simular acciones
 * de los usuarios y validar los resultados
 */
public class PruebasFuncionales 
{
	//Prueba de funcionalidad con casos de borde:
	/*
	Las pruebas de funcionalidad con casos de borde se centran
	en probar el comportamiento de una función o sistema en los limites
	o situaciones extremas. Estos casos de borde pueden ser, por ejemplo,
	valores minimos, maximos, nulos, vacios, valores limite, etc.
	El objetivo es verificar que el sistema maneje adecuadamente
	estas situaciones y produzca resultados correctos y coherentes.
	¿QUE IMPORTANCIA TIENEN LOS CASOS DE BORDE?
	- Identificar errores y vulnerabilidades: Los casos de borde a menudo
	revelean errores o vulnerabilidades en el sistema que no se pueden encontrar
	con pruebas tipicas. 
	Cumplir con los requisitos y especificaciones: Con los casos de borde
	podemos verificar si el sistema cumple con los requisitos y especificaciones establecidas.
	Esto es importante si hay temas regulatorios o estandares de industria a cumplir.
	Mejorar la calidad del codigo: Ayuda a mejorar la calidad del codigo al garantiza el correcto
	funcionamiento del sistema. 
	Prevenir fallos inesperados: Utilizando los casos de borde se pueden descubrir
	fallos inesperados que podrían ocurrir en situaciones poco comunes, PERO posibles.
	Validar el diseño y la implementación: Las pruebas de casos de borde
	permiten validar el diseño y la implementación del sistema. Si el
	sistema puede manejar correctamente los escenarios extremos, es una señal
	de que el diseño y la implementación son solidos. 
	*/
	//Ejemplo 1: Prueba de funcionalidad con valor minimo	
	@Test
	//Prueba de valor minimo
	public void testEsIgualAValorMinimo()
	{
		NumberUtils numberUtils = new NumberUtils();
		boolean resultado = numberUtils.isEven(Integer.MIN_VALUE); //Integer.MIN_VALUE es una constante predefinida en Java que representa el valor minimo posible para un tipo de dato entero.
		assertEquals(true, resultado);
	}	
	//Prueba de valor maximo
	public void testEsValorMaximo()
	{
		NumberUtils numberUtils = new NumberUtils();
		boolean resultado = numberUtils.isPrime(Integer.MAX_VALUE); //Integer.MAX_VALUE es una constante predefinida en Java que representa el valor maximo posible para un tipo de dato entero. 
		assertEquals(true, resultado);
	}
	//Valores Nulos o vacios
	public void testStringConVacios()
	{
		StringUtils stringUtils = new StringUtils();
		@SuppressWarnings("static-access")
		String resultado = stringUtils.stringAlReves(null);
		assertEquals(null, resultado);
	}
}