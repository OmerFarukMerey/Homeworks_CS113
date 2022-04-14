import java.util.*;

public class UnifyingTribes
{
	public static void main(String[] args)
	{
	System.out.println("Please enter 4 observation pairs:");
	
	Scanner myscan = new Scanner(System.in);
	double x1, y1, x2, y2, x3, y3, x4, y4;
	
	x1 = myscan.nextDouble();
	y1 = myscan.nextDouble();
	
	x2 = myscan.nextDouble();
	y2 = myscan.nextDouble();
	
	x3 = myscan.nextDouble();
	y3 = myscan.nextDouble();
	
	x4 = myscan.nextDouble();
	y4 = myscan.nextDouble();
	
	// Best way to solve this is to use Linear Regression that we learned from the first homework.
	double k, l;
	k = 4 * (x1 * y1 + x2 * y2 + x3 * y3 + x4 * y4) - (x1 + x2 + x3 + x4) * (y1 + y2 + y3 + y4); 
	l = 4 * (x1 * x1 + x2 * x2 + x3 * x3 + x4 *x4) - (x1 + x2 + x3 + x4) * (x1 + x2 + x3 + x4);
	
	double a = k / l;
	
	double b = ((y1 + y2 + y3 + y4) - a * (x1 + x2 + x3 +x4)) / 4;
	
	// y=ax+b x = Uzumaki and y = Uchiha 
	System.out.println("Please enter the measurement you want to convert:");
	
	double YourPoint = myscan.nextDouble();
	
	double ConvertedPoint = a * YourPoint + b;
	
	System.out.println("Converted measurement is " + ConvertedPoint);
	}
} 
	
	
	
	
