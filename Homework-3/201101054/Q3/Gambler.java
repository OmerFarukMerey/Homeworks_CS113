import java.util.*;

public class Gambler
{	
	public static void main(String[] args)
	{	
		Scanner myscan = new Scanner(System.in);
		Random myrandom = new Random();
		
		double n, m, p, number, chance = 1;
		int win = 0, lose = 0;
		final double first_value;
		
		System.out.println("Initial money:");
		n = myscan.nextDouble();
		
		System.out.println("Goal:");
		m = myscan.nextDouble();
		
		System.out.println("Probability of winning in a round:");
		p = myscan.nextDouble();
		
		System.out.println("Number of times the game will be simulated:");
		number = myscan.nextDouble();
		
		first_value = n;
		
		while (lose + win < number)
		{	
				n = first_value;
			while ((n < m) && (0 < n))
			{
				chance = myrandom.nextDouble();
				if (chance <= p)
					n++;
				else if (p < chance)
					n--;
			}	
				if (n == 0)
					lose++;
				if (n == m)
					win++;
				
		}	
			
		System.out.println("Win:" + win +"\nLose:" + lose);
	}		
}		
