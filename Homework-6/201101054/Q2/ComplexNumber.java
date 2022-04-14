public class ComplexNumber 
{

    	FractionalNumber realPart, imaginaryPart;

    	ComplexNumber(FractionalNumber in_realPart, FractionalNumber in_imaginaryPart)
    	{
        	realPart = in_realPart;
        	imaginaryPart = in_imaginaryPart;
    	}
    	ComplexNumber(String input_str)
    	{
        	int place;
        	if(input_str.contains("+"))
            		place = input_str.indexOf("+");
        	else
            	place = input_str.lastIndexOf("-");
        	
        	int place_2 = input_str.indexOf(("i"));
        	realPart = new FractionalNumber(input_str.substring(0, place));
       		imaginaryPart = new FractionalNumber(input_str.substring(place, place_2));
    	}
    	public String toString()
    	{
        	String str = "";
        	//realPart -+ imaginaryPart
        	if (imaginaryPart.toString().substring(0,1).equals("-"))
          	  	return str = realPart + "" + imaginaryPart + "i";
       		else
            		return str = realPart + "+" + imaginaryPart + "i";
    	}
    	public boolean equals(ComplexNumber cn)
    	{
        	FractionalNumber f1, f2, f3, f4;
        	f1 = FractionalNumber.simplify(cn.realPart);
        	f2 = FractionalNumber.simplify(cn.imaginaryPart);
        	f3 = FractionalNumber.simplify(this.realPart);
        	f4 = FractionalNumber.simplify(this.imaginaryPart);
        	return (f1.equals(f3) && f2.equals(f4));
    	}
    	public static ComplexNumber simplify(ComplexNumber cn)
    	{
        	FractionalNumber number1 = new FractionalNumber(cn.imaginaryPart.toString());
        	number1 = FractionalNumber.simplify(number1);
        	FractionalNumber number2 =  new FractionalNumber(cn.realPart.toString());
        	number2 = FractionalNumber.simplify(number2);
        	return new ComplexNumber(number2, number1);
    	}
    	public static ComplexNumber add(ComplexNumber cn1, ComplexNumber cn2)
    	{
        	FractionalNumber real_added = FractionalNumber.add(cn1.realPart, cn2.realPart);
        	FractionalNumber imaginary_added = FractionalNumber.add(cn1.imaginaryPart, cn2.imaginaryPart);
        	ComplexNumber added = new ComplexNumber(real_added, imaginary_added);
        	return ComplexNumber.simplify(added);
    	}
    	public static ComplexNumber subtract(ComplexNumber cn1, ComplexNumber cn2)
    	{
        	FractionalNumber real_sub = FractionalNumber.subtract(cn1.realPart, cn2.realPart);
        	FractionalNumber imaginary_sub = FractionalNumber.subtract(cn1.imaginaryPart, cn2.imaginaryPart);
        	ComplexNumber subtracted = new ComplexNumber(real_sub, imaginary_sub);
        	return ComplexNumber.simplify(subtracted);
    	}
    	public static ComplexNumber multiply(ComplexNumber cn1, ComplexNumber cn2)
    	{
        	FractionalNumber f1 = new FractionalNumber(cn1.realPart.toString());
        	FractionalNumber f2 = new FractionalNumber(cn1.imaginaryPart.toString());
        	FractionalNumber f3 = new FractionalNumber(cn2.realPart.toString());
        	FractionalNumber f4 = new FractionalNumber(cn2.imaginaryPart.toString());
        	FractionalNumber new_real, new_imagi;
        	new_real = FractionalNumber.subtract(FractionalNumber.multiply(f1,f3), FractionalNumber.multiply(f2, f4));
        	new_imagi = FractionalNumber.add(FractionalNumber.multiply(f1, f4), FractionalNumber.multiply(f2, f3));
        	ComplexNumber multiplied = new ComplexNumber(new_real, new_imagi);
        	return ComplexNumber.simplify(multiplied);
    	}

    	public static ComplexNumber divide(ComplexNumber cn1, ComplexNumber cn2)
    	{
        	int test1 = cn2.imaginaryPart.getNumerator();
        	int test2 = cn2.imaginaryPart.getDenominator();
        	int test3 = cn2.realPart.getNumerator();
        	int test4 = cn2.realPart.getDenominator();
        	if ((test1 == 0) && (test3 == 0))
            		return null;
        	else
            	{
            		FractionalNumber f0 = new FractionalNumber("-1/1");
            		FractionalNumber f1 = new FractionalNumber(cn1.realPart.toString());
            		FractionalNumber f2 = new FractionalNumber(cn1.imaginaryPart.toString());
             		FractionalNumber f3 = new FractionalNumber(cn2.realPart.toString());
            		FractionalNumber f4 = new FractionalNumber(cn2.imaginaryPart.toString());
            		FractionalNumber f5 = FractionalNumber.multiply(f3, f3);
            		FractionalNumber f6 = FractionalNumber.multiply(f4, f4);
            		FractionalNumber sum = FractionalNumber.add(f5, f6);
            		f4 = FractionalNumber.multiply(f4, f0);
            		ComplexNumber mult1 = new ComplexNumber(f3, f4);
            		ComplexNumber mult2 = new ComplexNumber(f1, f2);
            		ComplexNumber multip = ComplexNumber.multiply(mult1, mult2);
            		FractionalNumber fn1 = multip.realPart;
            		FractionalNumber fn2 = multip.imaginaryPart;
            		fn1 = FractionalNumber.divide(fn1, sum);
            		fn2 = FractionalNumber.divide(fn2, sum);
            		ComplexNumber divided = new ComplexNumber(fn1, fn2);
            		return ComplexNumber.simplify(divided);
        	}	
    	}
}
