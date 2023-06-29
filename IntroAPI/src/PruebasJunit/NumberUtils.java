package PruebasJunit;

public class NumberUtils {
	
	public boolean isEven(int number)
	{
		return number % 2 == 0;
	}
	
	public boolean isPrime(int number)
	{
		if (number <= 1)
		{
			return false;
		}
	return true;
	}
}
