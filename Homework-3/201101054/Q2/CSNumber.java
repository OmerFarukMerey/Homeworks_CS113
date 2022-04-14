import java.util.*;

public class CSNumber
{
	public static void main(String[] args)
	{
		int number, a1, a2, a3, a4, x1, x2;
		
		Scanner myscan = new Scanner(System.in);
		
		System.out.println("Please enter a 4-digit number:");
		
		number = myscan.nextInt();
		a1 = number - (number / 10) * 10;
		a2 = ((number - (number / 100) * 100) - a1);
		a3 = ((number - (number / 1000) * 1000) - a1 - a2);
		a4 = ((number - (number / 10000) * 10000) - a1 - a2 - a3);
		
		a2 = a2 / 10;
		a3 = a3 / 100;
		a4 = a4 / 1000;
		
		x1 = a3 + a4;
		x2 = a1 + a2;
		
		if (x2 % x1 == 0)
		    System.out.println(number + " is a Bil113 Number.");
		if (x2 % x1 != 0)
		    System.out.println(number + " is not a Bil113 Number.");
	}
}
		
		
		
