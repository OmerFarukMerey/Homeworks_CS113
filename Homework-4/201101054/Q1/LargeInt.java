import java.util.*;

public class LargeInt 
{
	public static void main(String[] args) 
	{
		
		Scanner myscan = new Scanner(System.in);
		
		System.out.println("Please enter two numbers. First number:");
		String big_number1 = myscan.next();
		System.out.println("Second number:");
		String big_number2 = myscan.next();
		System.out.println("Please enter 1 for addition or 2 for subtraction:");
		int operator = myscan.nextInt();
		
		int len_num1 = big_number1.length();
		int len_num2 = big_number2.length();
		int times = 0, sum = 0, sub = 0, equality = 0, remain = 0;
		String result = "";
		
		while (len_num1 > len_num2)
		{
			big_number2 = "0" + big_number2;
			len_num2 = len_num2 + 1; 
		}
		while (len_num2 > len_num1)
		{
			big_number1 = "0" + big_number1;
			len_num1 = len_num1 + 1; 
		}
		
		if (operator == 1) 
		{
			while (len_num1 + len_num2 != 0) 
			{
				sum = big_number1.charAt(len_num1 - 1) - '0' + big_number2.charAt(len_num2 - 1) - '0';
				sum = sum + remain; 
				if (sum >= 10) 
				{
					sum = sum % 10;
					result = sum + result;
					remain = 1;
					len_num1--;
					len_num2--;
				}
				else if (sum < 10)
				{
					result = sum + result;
					remain = 0;
					len_num1--;
					len_num2--;
				}
			}
		System.out.println("Result:" + result);
		}
		
		if (operator == 2)
		{
			while (len_num1 + len_num2 != 0)
			{
				sub = (big_number1.charAt(len_num1 - 1) - '0') - (big_number2.charAt(len_num2 - 1) - '0');
				sub = sub + remain;
				if (sub < 0) 
				{
					sub = sub + 10;
					result = sub + result;
					remain = -1;
					len_num1--;
					len_num2--;
				}
				else if (sub >= 0) 
				{
					result = sub + result;
					remain = 0;
					len_num1--;
					len_num2--;
				}
			}
		while (result.charAt(times) == '0') 
			times++;
			
		result = result.substring(times);
		System.out.println("Result:" + result);
		}
	}
}
