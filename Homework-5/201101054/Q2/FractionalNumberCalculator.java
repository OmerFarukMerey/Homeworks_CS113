import java.util.*;
public class FractionalNumberCalculator
{
	public static void main(String[] args) 
	{
		// Using FractionalNumber class we created let's combine it with calculating.
		Scanner myscan = new Scanner(System.in);
		System.out.println("Please enter the formula you want to calculate:");
		String str = myscan.nextLine();
		str = " " + str + " ";
		int index_multiply = str.indexOf("*"), index_divide = str.indexOf(" / "), index_add = str.indexOf("+"), index_subtract = str.indexOf(" - ");
		String number1 = "", number2 = "", result = "";
		int left_space = -1, right_space = -1, len = str.length();
		
		// x/0 type fractions 0/0 and 0/y type fractions x/1 and x/x type fractions -x/-y and x/-y  type fractions
		
		if (!str.contains("/ 0") && !str.contains("0/0") && !str.contains("/0"))
		{
			while (!(index_multiply < 0))
			{
				left_space = index_multiply;
				right_space = index_multiply;
				while (!(str.substring(left_space - 2, left_space - 1).equals(" ")))
					left_space = left_space - 1;
				while (!(str.substring(right_space + 2, right_space + 3).equals(" ")))
					right_space = right_space + 1;
				number1 = str.substring(left_space - 1, index_multiply - 1);
				number2 = str.substring(index_multiply + 2, right_space + 2);
				FractionalNumber obj_num1 = new FractionalNumber(number1);
				FractionalNumber obj_num2 = new FractionalNumber(number2);
				str = str.substring(0, left_space - 1) + FractionalNumber.multiply(obj_num1, obj_num2) + str.substring(right_space + 2);
				index_multiply = str.indexOf("*");
				index_add = str.indexOf("+");
				index_divide = str.indexOf(" / ");
				index_subtract = str.indexOf(" - ");
			
			}
			while (!(index_divide < 0))
			{
				left_space = index_divide;
				right_space = index_divide;
				while (!(str.substring(left_space - 1, left_space).equals(" ")))
					left_space = left_space - 1;
				while (!(str.substring(right_space + 3, right_space + 4).equals(" ")))
					right_space = right_space + 1;
				number1 = str.substring(left_space, index_divide);
				number2 = str.substring(index_divide + 3, right_space + 3);
				FractionalNumber obj_num1 = new FractionalNumber(number1);
				FractionalNumber obj_num2 = new FractionalNumber(number2);
				str = str.substring(0, left_space) + FractionalNumber.divide(obj_num1, obj_num2) + str.substring(right_space + 3);
				index_divide = str.indexOf(" / ");
				index_multiply = str.indexOf("*");
				index_subtract = str.indexOf(" - ");
				index_add = str.indexOf("+");
			}
			while (!(index_add < 0))
			{
				left_space = index_add;
				right_space = index_add;
				while (!(str.substring(left_space - 2, left_space - 1).equals(" ")))
					left_space = left_space - 1;
				while (!(str.substring(right_space + 2, right_space + 3).equals(" ")))
					right_space = right_space + 1;
				number1 = str.substring(left_space - 1, index_add - 1);
				number2 = str.substring(index_add + 2, right_space + 2);
				FractionalNumber obj_num1 = new FractionalNumber(number1);
				FractionalNumber obj_num2 = new FractionalNumber(number2);
				str = str.substring(0, left_space - 1) + FractionalNumber.add(obj_num1, obj_num2) + str.substring(right_space + 2);
				index_add = str.indexOf("+");
				index_divide = str.indexOf(" / ");
				index_multiply = str.indexOf("*");
				index_subtract = str.indexOf(" - ");
			}
			while (!(index_subtract < 0))
			{
				left_space = index_subtract;
				right_space = index_subtract;
				while (!(str.substring(left_space - 1, left_space).equals(" ")))
					left_space = left_space - 1;
				while (!(str.substring(right_space + 3, right_space + 4).equals(" ")))
					right_space = right_space + 1;
				number1 = str.substring(left_space, index_subtract);
				number2 = str.substring(index_subtract + 3, right_space + 3);
				FractionalNumber obj_num1 = new FractionalNumber(number1);
				FractionalNumber obj_num2 = new FractionalNumber(number2);
				str = str.substring(0, left_space) + FractionalNumber.subtract(obj_num1, obj_num2) + str.substring(right_space + 3);
				index_subtract = str.indexOf(" - ");
				index_add = str.indexOf("+");
				index_divide = str.indexOf(" / ");
				index_multiply = str.indexOf("*");
			}
			System.out.println("Result:" + str.replace(" ", ""));
		}
		else 
		System.out.println("Result:" + "null");
		
		
	}
}

