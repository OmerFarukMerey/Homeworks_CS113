import java.util.*;
import java.util.Locale;

public class IfClause2
{
	public static void main(String[] args)
	{
	// This programs provides if-clause correction means that a common mistake in English that is between if and comma will be solved after user types a sentence(input)
	Scanner myscan = new Scanner(System.in);
	
	System.out.println("Please enter the sentence:");	
	
	String sentence1, sentence2, sentence3;
	
	sentence1 = myscan.nextLine();
	sentence2 = sentence1.replace("if", ",");
	
	// This program is for the sentences that if-clause preceding and for that reason it should be no comma. So creating a comma will help the progress with replacing one. 
	int indexIf = sentence2.indexOf(',');
	int indexDot = sentence2.indexOf('.');
	
	// Line below is kind of tricky so be patient and take time to understand it.
	sentence3 = sentence2.substring(indexIf + 2, indexDot) + ", " + sentence2.substring(0,1).toLowerCase(Locale.ENGLISH) + sentence2.substring(1, indexIf - 1) + ".";
	
	//There is two types of I in English 'I' and "I'" so the programmer who wrote this found a solution.
	sentence3 = sentence3.replace(" i ", " I ");
	sentence3 = sentence3.replace(" i'", " I'");
	
	System.out.println("Repharased sentence: " + "If " + sentence3);
	}
}
	
	
