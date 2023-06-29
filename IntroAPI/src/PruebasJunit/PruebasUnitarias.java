package PruebasJunit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

/*Tipos de prueba en Java:
 *
 * Pruebas unitarias (Unit Testing): 
 * Las pruebas unitarias se enfocan en verificar el comportamiento
 * de unidades individuales de codigo, como métodos o clases, de manera aislada.
 * Se utilizan frameworks como JUnit o TestNG para dichas pruebas.
 *
 * Pruebas de integración (Integration Testing):
 * Las pruebas de integración se realizan para verificar que los diferentes componentes
 * o modulos de una aplicación funcionen correctamente juntos. Se pueden
 * utilizar frameworks como JUnit o herramientas como Mockito para simular o emular dependencias
 * y realizar pruebas de integración
 * 
 * Pruebas funcionales (Functional Testing):
 * Las pruebas funcionales se enfocan en verificar que la apalicación cumpla con los
 * requisitos y funcionalidades esperadas. Pueden realizarse pruebas manuales o utilizar herramientas
 * de automatización de pruebas como Selenium, Cucumber o JBehave para simular acciones
 * de los usuarios y validar los resultados
 * 
 * Pruebas de rendimiento (Performance Testing):
 * Las pruebas de rendimiento se llevan a cabo para evaluar el rendimiento, la escalabilidad
 * y la estabilidad de una aplicación bajo diferentes cargas y condiciones.
 * Podemos utilizar JMeter o Gatling por ejemplo.
 * 
 * Pruebas de seguridad (Security Testing): 
 * Las pruebas de seguridad se realizan para identificar vulnerabilidades y garantizar la protección de una aplicación
 * contra ataques. Se pueden utilizar herramientas como OWASP ZAP o Burp Suite.  
 */
public class PruebasUnitarias 
{
	@Test
	public void testSuma()
	{
		int a = 2;
		int b = 3;
		int resultado = a + b;
		assertEquals(5, resultado);
	}
	@Test
	public void testResta()
	{
		int a= 10;
		int b= 4;
		int resta = a - b;
		assertEquals(100, resta);
	}
	@Test
	public void testMultiplicacion()
	{
		int a = 100;
		int b = 10;
		int multiplicacion = a * b;
		assertEquals(100, multiplicacion);
	}
	@Test
	public void testDivision()	
	{
		int a = 0;
		int b = 10;
		int division = a / b;
		assertEquals(0, division);
	}
	
	
	@Test
	public void testConcatenar()
	{
		String str1 = "Hola";
		String str2 = "Mundo";
		String resultado = str1+str2;
		assertEquals("Hola Mundo", resultado);
	}
	
	@Test
	public void agregarItem()
	{
	 List<String> items = new ArrayList<>();
     items.add("Pelota");
     items.add("Sockete");
     assertEquals(2, items.size());
	}
	
	public static String reverseString(String str)
	{
		StringBuilder strDado = new StringBuilder(str);
		return strDado.reverse().toString();
	}
	
	@Test
	public void testStringDadoVuelta()
	{
		String str = "Hola";
		String strDado = reverseString(str);
		assertNotNull(strDado);
	}
/*Prueba de excepción esperada. Es una tecnica utilizada 
	en las pruebas unitarias para verificar que un metodo
	lanza una excepción especifica en determinadas circunstancias.
	Permite validar el comportamiento esperado cuando se producen condiciones
	excepcionales
CUando se espera que un metodo lance una excepción, se utiliza
el parametro expected dentro del @Test para indicar que tipo de excepción se espera.
*/
	@Test()
	public void dividoPorCero()
	{
		int a = 10;
		int b = 0;
		//ArithmeticException exception = 
		assertThrows(ArithmeticException.class, () -> 
		{
		int resultado = a/b;
		});
		//String mensajeEsperado = "Divide por 0";
		//String mensajeActual =exception.getMessage(); 
	}
	
	@Test
	public void tamañoLista()
	{
		List<String> nombres = new ArrayList<>();
		nombres.add("Gustavo");
		nombres.add("Pablo");
		nombres.add("Camila");
		nombres.add("Maria");
		assertEquals(4, nombres.size());
		assertTrue(nombres.contains("Gustavo"));
	}
	@Test
	public void tamañoListaFalso()
	{
		List<String> nombres = new ArrayList<>();
		nombres.add("Gustavo");
		nombres.add("Pablo");
		nombres.add("Camila");
		nombres.add("Maria");
		assertEquals(4, nombres.size());
		assertFalse(nombres.contains("Nicolas"));
	}	
	@Test
	public void testAssertionNested()
	{
		String valorActual = "Hola mundo";
		assertNotNull(valorActual, "El valor actual no debe ser nulo");
		assertAll("Verificar contenido del valor actual",
				() -> assertTrue(valorActual.startsWith("Hola")),
				() -> assertTrue(valorActual.endsWith("mundo")),
				() -> assertEquals(10, valorActual.length())
				);
		//sintaxis: assertAll(String mensaje, Ejecutable....n ejecutables)
		// Donde cada ejecutable representa un assert distinto.
		// Si todas las pruebas son exitosas -> El test funciona. 
		// De lo contrario, se informara la primer falla detectada.
	}
	
	//Ejemplo con objetos
	
	@Test
	public void testSumaCalculadora()
	{
	 Calculadora calculadora = new Calculadora();
	 int a=5;
	 int b=5;
	 int resultado = calculadora.suma(a, b);
	 assertEquals(15, resultado);
	}
	@Test
	public void testRestaCalculadora()
	{
		Calculadora calculadora = new Calculadora();
		int a = 100;
		int b= 200;
		int resultado = calculadora.resta(a, b);
		assertEquals(1000, resultado);
	}
}