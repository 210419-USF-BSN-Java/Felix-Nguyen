import java.util.*;

public class ReverseString {

	String stringResult = "";
	
	public String reverse(String string)
	{
		for(int i = string.length(); i > 0; i--)
		{
			stringResult += string.charAt(i - 1);			
		}				
		return stringResult;
	}
}
