package PruebasJunit;


public class StringUtils {
	
	public static boolean isEmpty(String str)
	{
		return str == null || str.isEmpty();
	}
	
	
	public static boolean isnotEmpty(String str)
	{
		return !isEmpty(str);
	}
	
	public static String stringAlReves(String str)
	{
		if (str == null)
		{
			return null;
		}
		return new StringBuilder(str).reverse().toString();
	}
	
}
