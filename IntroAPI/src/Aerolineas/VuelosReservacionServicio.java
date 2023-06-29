package Aerolineas;

public class VuelosReservacionServicio 
{
	public int calculaPrecio (int distancia, String claseSeleccionada)
	{
		int precioBase = 0;
		if(claseSeleccionada.equals("Economy"))
		{
			precioBase = 100;
		}
		if (claseSeleccionada.equals("Business"))
		{
			precioBase = 200;
		}
		int precioPor100km = precioBase;
		int distanciaTotal = distancia;
		if (distancia % 100 != 0)
		{
			distanciaTotal = ((distancia / 100)+1) *100;
		}
		int precioTotal = (distanciaTotal / 100) * precioPor100km;
		return precioTotal;
	}
}