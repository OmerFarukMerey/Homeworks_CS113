import java.util.*;
import java.text.NumberFormat;

public class CarPrice
{
	public static void main(String[] args)
	{
		Scanner myscan = new Scanner(System.in);
		
		double price, eng_capa, SCT, SCT_amount, VAT_amount, Final_price;
		SCT = 1;
		
		System.out.println("Please enter the base price of the car:");
		price = myscan.nextDouble();
		
		System.out.println("Please enter the engine capacity of the car:");
		eng_capa = myscan.nextDouble();
		
		NumberFormat frmt1 = NumberFormat.getCurrencyInstance();
		NumberFormat frmt2 = NumberFormat.getPercentInstance();
		
		if ((eng_capa <= 1600) && (price <= 10625)) 
		    SCT = 0.45;
		if ((eng_capa <= 1600) && (10625 < price) && (price < 16250))
		    SCT = 0.50;
		if ((eng_capa <= 1600) && (16250 < price))
		    SCT = 0.80;
		if ((1600 < eng_capa) && (eng_capa < 2000) && (price < 21250))
		    SCT = 1.30;
		if ((1600 < eng_capa) && (eng_capa < 2000) && (21250 <= price))
		    SCT = 1.50;
		if (2000 < eng_capa)
		    SCT = 2.20;
		
		SCT_amount = price * SCT;
		VAT_amount = (price + SCT_amount) * 18 / 100;
		Final_price = price + VAT_amount + SCT_amount;
		
		System.out.println("Base price:" + frmt1.format(price) + "\nSpecial Consumption Tax:" + frmt1.format(SCT_amount) + "\nValue Added Tax:" + frmt1.format(VAT_amount));
		System.out.println("Total Tax:" + frmt1.format(SCT_amount + VAT_amount) + "\nFinal Price:" + frmt1.format(Final_price));
		System.out.println("Approximately " + frmt2.format(SCT_amount / Final_price) + " of the final price is Special Consumption Tax");
		System.out.println("Approximately " + frmt2.format(VAT_amount / Final_price) + " of the final price is Value Added Tax");
	}
}
		
		
		
