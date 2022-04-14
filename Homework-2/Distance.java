import java.util.*;

public class Distance
{
	public static void main(String[] args)
	{
	// This program will tell us distance in three dimensional space by the points. Which will be given from the user.
	Scanner myscan = new Scanner(System.in);
	
	System.out.println("Please enter two points:");
	
	double x1, y1, z1, x2, y2, z2;
	
	x1 = myscan.nextDouble();
	y1 = myscan.nextDouble();
	z1 = myscan.nextDouble();
	
	x2 = myscan.nextDouble();
	y2 = myscan.nextDouble();
	z2 = myscan.nextDouble();
	
	double Manhattan, Euclidean, Cosine;
	//Be carefull when you read this it is kind of complicated.
	Manhattan = Math.abs(x1 - x2) + Math.abs(y1 - y2) + Math.abs(z1 - z2);
	Euclidean = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2) + Math.pow(z1 - z2, 2));
	Cosine = 1 - ((x1 * x2 + y1 * y2 + z1 * z2) / (Math.sqrt(Math.pow(x1, 2) + Math.pow(y1, 2) + Math.pow(z1, 2)) * Math.sqrt(Math.pow(x2, 2) + Math.pow(y2, 2) + Math.pow(z2, 2))));
	
	System.out.println("Manhattan distance is equal to:" + Manhattan);
	System.out.println("Euclidean distance is equal to:" + Euclidean);
	System.out.println("Cosine distance is equal to:" + Cosine);
	
	}
}
	
