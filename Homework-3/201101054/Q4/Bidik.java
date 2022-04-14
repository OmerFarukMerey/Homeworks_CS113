import java.util.*;

public class Bidik
{
	public static void main(String[] args)
	{	
		Scanner myscan = new Scanner(System.in);
		
		double num1, num2, num3, num4, num5, num6, num7, cube, sphere, cylinder, rect_prism;
		
		System.out.println("Please enter the geometric shape which you wish to compute it's volume: ");
		
		String shape, name_1, name_2, name_3, name_4;
		shape = myscan.nextLine();
		
		if (shape.equals("cube") )
		{ 
		    System.out.println("Please enter the length of the cube:");
		    num1 = 1;
		    num1 = myscan.nextDouble();
		    System.out.println("Volume of the cube is " + Math.pow(num1, 3));		  
		} 
		
		if (shape.equals("cylinder"))
	        {
		    System.out.println("Please enter the height and radius of the cylinder:");
		    num2 = 1;
		    num3 = 1;
		    num2 = myscan.nextDouble();
		    num3 = myscan.nextDouble();
		    System.out.println("Volume of the cylinder is " + (num2 * Math.PI * Math.pow(num3, 2)));
		}
		
		if (shape.equals("sphere"))
		{
		    System.out.println("Please enter the radius of the sphere:");
		    num4 = 1;
		    num4 = myscan.nextDouble();
		    System.out.println("Volume of the sphere is " + (4 * Math.PI * Math.pow(num4, 3)) / 3);
		}
		
		if (shape.equals("rectangular prism"))
		    {
		    System.out.println("Please enter the length, height and width of the rectangular prism:");
		    num5 = 1;
		    num6 = 1;
		    num7 = 1;
		    num5 = myscan.nextDouble();
		    num6 = myscan.nextDouble();
		    num7 = myscan.nextDouble();
		    System.out.println("Volume of the rectangular prism is " + (num5 * num6 * num7));
		    }  
	}
}
