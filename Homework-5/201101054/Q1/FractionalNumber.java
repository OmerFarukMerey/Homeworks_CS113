public class FractionalNumber
{
	int numerator;
	int denominator;

    	public FractionalNumber(String input_str)
    	{
        	int place = input_str.indexOf("/");
        	numerator = Integer.parseInt(input_str.substring(0, place));
        	denominator = Integer.parseInt(input_str.substring(place + 1));
    	}
	public FractionalNumber(int input_numer, int input_denom)
	{
		numerator = input_numer;
		denominator = input_denom;
    	}
    	public double getDoubleValue()
    	{
        	double double_result = (double) numerator / denominator;
        	return double_result;
    	}
    	public boolean equals(FractionalNumber fn) //Using toString() method for a equals() method
    	{
        	String str1 = simplify(this).toString();
        	String str2 = simplify(fn).toString();
        	return (str1.equals(str2));
    	}
    	public String toString() 
    	{
        	String represent = Integer.toString(numerator) + "/" + Integer.toString(denominator);
        	return represent;
    	}
    	public static FractionalNumber simplify(FractionalNumber fn) //Using a theory for positive franctionals and implementing with the negative ones both. 
    	{
        	String calculate = fn.toString();
        	int index_divide = calculate.indexOf("/");
        	int numerator = Integer.parseInt(calculate.substring(0, index_divide));
        	int denominator = Integer.parseInt(calculate.substring(index_divide + 1));
        	int nume = numerator, deno = denominator, new_nume, new_deno;
        	String simplified = "";
        	if ((0 < numerator) && (0 < denominator) && (denominator - numerator != 0))
        	{
            		while (numerator != denominator)
            		{
                		if(numerator < denominator)
                    		denominator = denominator - numerator;
                		else
                    		numerator = numerator - denominator;
            		}
            		new_nume = nume / numerator;
            		new_deno = deno / numerator;
            		simplified = new_nume + "/" + new_deno;
        	}
        	else if ((0 < numerator) && (denominator < 0) && (denominator - numerator != 0))
        	{
            		denominator = -denominator;
            		while (numerator != denominator)
            		{
                		if(numerator < denominator)
                    		denominator = denominator - numerator;
                		else
                    		numerator = numerator - denominator;
            		}
            		new_nume = nume / numerator;
            		new_deno = deno / numerator;
           		simplified = -new_nume + "/" + -new_deno;
        	}
       		else if ((numerator < 0) && (0 < denominator) && (denominator - numerator != 0))
        	{
            		numerator = -numerator;
            		while (numerator != denominator)
            		{
                		if(numerator < denominator)
                    		denominator = denominator - numerator;
                	else
                    		numerator = numerator - denominator;
            		}
            		new_nume = nume / numerator;
            		new_deno = deno / numerator;
            		simplified = new_nume + "/" + new_deno;
        	}
        	else if ((numerator < 0) && (denominator < 0) && (denominator - numerator != 0))
        	{
            		denominator = -denominator;
            		numerator = -numerator;
            		while (numerator != denominator)
            		{
                		if(numerator < denominator)
                    		denominator = denominator - numerator;
                		else
                    		numerator = numerator - denominator;
            		}
            		new_nume = nume / numerator;
            		new_deno = deno / numerator;
            		simplified = -new_nume + "/" + -new_deno;
        	}
        	else if (numerator == 0)
        		simplified  = "0/1";
        	else
            		simplified = 1 + "/" + 1;

        	FractionalNumber simplified_object = new FractionalNumber(simplified);
        	return simplified_object;
    	}
    	public static FractionalNumber add(FractionalNumber fn1, FractionalNumber fn2) //Using toString() for adding
    	{
        	String calculate1 = fn1.toString();
        	String calculate2 = fn2.toString();
        	int index_divide1 = calculate1.indexOf("/");
        	int index_divide2 = calculate2.indexOf("/");
        	int nume_1 = Integer.parseInt(calculate1.substring(0, index_divide1));
        	int nume_2 = Integer.parseInt(calculate2.substring(0, index_divide2));
        	int deno_1 = Integer.parseInt(calculate1.substring(index_divide1 + 1));
        	int deno_2 = Integer.parseInt(calculate2.substring(index_divide2 + 1));

        	int shared_deno = deno_1 * deno_2;
        	nume_1 = nume_1 * deno_2;
        	nume_2 = nume_2 * deno_1;

        	String add_result = (nume_1 + nume_2) + "/" + shared_deno;
        	FractionalNumber simp_add = new FractionalNumber(add_result);
        	return simplify(simp_add);
    	}
	public static FractionalNumber subtract(FractionalNumber fn1, FractionalNumber fn2) //Using toString() method for subtracting
	{
		String calculate1 = fn1.toString();
		String calculate2 = fn2.toString();
		int index_divide1 = calculate1.indexOf("/");
		int index_divide2 = calculate2.indexOf("/");
		int nume_1 = Integer.parseInt(calculate1.substring(0, index_divide1));
		int nume_2 = Integer.parseInt(calculate2.substring(0, index_divide2));
		int deno_1 = Integer.parseInt(calculate1.substring(index_divide1 + 1));
		int deno_2 = Integer.parseInt(calculate2.substring(index_divide2 + 1));

		int shared_deno = deno_1 * deno_2;
		nume_1 = nume_1 * deno_2;
		nume_2 = nume_2 * deno_1;

		String subtract_result = (nume_1 - nume_2) + "/" + shared_deno;
		FractionalNumber simp_subt = new FractionalNumber(subtract_result);
		return simplify(simp_subt);
	}
	public static FractionalNumber multiply(FractionalNumber fn1, FractionalNumber fn2) //Using toString() method for multiply
	{
		String calculate1 = fn1.toString();
		String calculate2 = fn2.toString();
		int index_divide1 = calculate1.indexOf("/");
		int index_divide2 = calculate2.indexOf("/");

		int nume_1 = Integer.parseInt(calculate1.substring(0, index_divide1));
		int nume_2 = Integer.parseInt(calculate2.substring(0, index_divide2));
		int deno_1 = Integer.parseInt(calculate1.substring(index_divide1 + 1));
		int deno_2 = Integer.parseInt(calculate2.substring(index_divide2 + 1));

		int shared_nume = nume_1 * nume_2;
		int shared_deno = deno_1 * deno_2;

		String multiply_result = shared_nume + "/" + shared_deno;
		FractionalNumber simp_multi = new FractionalNumber(multiply_result);
		return simplify(simp_multi);
	}
	public static FractionalNumber divide(FractionalNumber fn1, FractionalNumber fn2) //Using toString() method for dividing
    	{
		String calculate1 = fn1.toString();
		String calculate2 = fn2.toString();
		int index_divide1 = calculate1.indexOf("/");
		int index_divide2 = calculate2.indexOf("/");

        	int nume_1 = Integer.parseInt(calculate1.substring(0, index_divide1));
        	int nume_2 = Integer.parseInt(calculate2.substring(0, index_divide2));
        	int deno_1 = Integer.parseInt(calculate1.substring(index_divide1 + 1));
        	int deno_2 = Integer.parseInt(calculate2.substring(index_divide2 + 1));

		if (nume_2 == 0)
			return null;
		else
        	{
            		int shared_nume = nume_1 * deno_2;
            		int shared_deno = nume_2 * deno_1;
            		String divide_result = shared_nume + "/" + shared_deno;
            		FractionalNumber simp_divide = new FractionalNumber(divide_result);
            		return simplify(simp_divide);
		}

	}

}
