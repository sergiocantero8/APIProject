package PruebasJunit;

public class Calculadora 
{
	
	public int suma(int a, int b)
	{
		return a+b;
	}
	
	public int resta(int a, int b)
	{
		return a-b;
	}
	
	public int multiplicacion(int a, int b)
	{
		return a*b;
	}
	
	public int division(int a, int b)
	{
		if (b== 0)
		{
			throw new ArithmeticException("Division por 0 no permitida");
			
		}
		return a/b;
	}
}
