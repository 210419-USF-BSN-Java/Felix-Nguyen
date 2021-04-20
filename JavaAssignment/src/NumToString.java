
public class NumToString {

	public String string;
	
	public String printNumberInWord(int num)
	{
		if (num == 0)
			string = "zero";
		else if (num == 1)
			string = "one";
		else if (num == 2)
			string = "two";
		else if (num == 3)
			string = "three";
		else if (num == 4)
			string = "four";
		else if (num == 5)
			string = "five";
		else if (num == 6)
			string = "six";
		else if (num == 7)
			string = "seven";
		else if (num == 8)
			string = "eight";
		else if (num == 9)
			string = "nine";
		else if (num < 0)
			string = "other";
		else if (num > 9)
			string = "other";
		return string;
	}
}
