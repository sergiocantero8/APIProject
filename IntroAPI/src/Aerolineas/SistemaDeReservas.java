package Aerolineas;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
/* Estamos desarrollando un sistema de reserva para vuelos
y tienes que calcular el precio de un vuelo en funcion
de la distancia y la clase seleccionada. Los precios
para la clase Economy son de $50 por cada 100 kilometros, y,
para la clase Business son de $200 por cada 100 kilometros.abstract
Vamos a analizar como es el comportamiento cuando la distancia
es un multiplo de 100
*/
public class SistemaDeReservas 
{
	private VuelosReservacionServicio sistemadeserservas =  new VuelosReservacionServicio();
	@Before //Inicializa los objetos necesarios para poder ejecutar las pruebas.
	public void setup()
	{
		sistemadeserservas = new VuelosReservacionServicio();
	}
	@Test
	public void testMultiploDe100()
	{
		
		int distancia = 500;
		String claseSeleccionada = "Economy";
		int precioEsperado = 500; //$50 por cada 100km
		int precioActual = sistemadeserservas.calculaPrecio(distancia, claseSeleccionada);		
		assertEquals(precioEsperado, precioActual);
	}
}