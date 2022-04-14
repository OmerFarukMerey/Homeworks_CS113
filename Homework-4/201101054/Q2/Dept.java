import java.util.*;
import java.text.NumberFormat;

public class Dept 
{
	public static void main(String[] args)
	{
		Scanner myscan = new Scanner(System.in);
		NumberFormat myform = NumberFormat.getCurrencyInstance();
	
		System.out.println("Please enter the initial debt:");
		double debt = myscan.nextDouble();
		System.out.println("Please enter the yearly interest rate (in percentages):");
		double interest = myscan.nextDouble();
		System.out.println("Please enter the monthly payment you want to make:");
		double payment = myscan.nextDouble();
		
		double month = (interest / 1200), calculation = 0, times = 0, total = 0, current = debt;

		while (current != 0) 
		{
			if ((current + (current * month)) > payment)
			{
				calculation = current * month;
				current = current - (payment - calculation); 
				total = total + calculation;
				times++;
			}
			
			if (payment >= (current + (current * month)))
			{	
				total = total + (current * month);
				times++;
				current = 0;
			}
		}
		total = total + debt;
		System.out.println("It takes " + (int)times + " months to pay the debt and the total payment equals to " + myform.format(total));			
	}	
}




