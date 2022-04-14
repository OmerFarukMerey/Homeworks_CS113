import java.util.*;

public class IfClause1
{
	public static void main(String[] args)
	{
	// This programs provides if-clause correction means that a common mistake in English that is between if and comma will be solved after user types a sentence(input).
	System.out.println("Please enter the sentence:");
	
	Scanner myscan = new Scanner(System.in);
	
	String sentence1, sentence2, sentence3;
	
	sentence1 = myscan.nextLine();
	
	// As we know the user is restricted with only using one dot and one comma so we took advantage of that usage.
	int commaNum = sentence1.indexOf(',');
	int dotNum = sentence1.indexOf('.');
	
	// And now that we spotted the comma and dot we are going to use those indexes to write the proper way of the sentence
	sentence2 = sentence1.substring(commaNum + 2, commaNum + 3).toUpperCase() + sentence1.substring(commaNum + 3, dotNum);
	sentence3 = sentence1.substring(2, commaNum);
	
	System.out.println("Repharased sentence: " + sentence2 + " if" + sentence3 + "."); 
	}
}
	
