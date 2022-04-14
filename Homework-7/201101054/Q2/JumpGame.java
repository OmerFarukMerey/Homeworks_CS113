import java.util.Scanner;

public class JumpGame {
    	public static void main(String[] args)
    	{
        	int [] arr = {2,3,1,1,4};
        	System.out.println("Solution:" + JumpGame.numberJump(arr));
    	}

    	public static int numberJump(int [] array)
    	{
        	int[] jumps = new int[array.length];
        	int max = Integer.MAX_VALUE;
        	
        	for (int m = 0; m < array.length; m++)
            		jumps[m] = max;
        		jumps[0] = 0; //for the beginning

        	for (int i = 0; i < jumps.length; i++)
        	{
            		for (int j = i + 1; j < array.length && j <= i + array[i]; j++)
            		{
                		jumps[j] = Math.min((1 + jumps[i]), jumps[j]);
            		}
        	}
        	return jumps[jumps.length - 1];
    	}
}

/* Okay just because you won't remember the algorithm:
We start by checking each elements jumps one by one. 
Because we have at least one jump for every index we move one place when swapping elements and
Since we are trying to find the least we make every jump MAX_VALUE and compare it to the other elements of jump.
or we check if it's less than the previous jump range.
Okay I wrote 2,3,1,1,4 for instance.
we start by index 0. and start to jump from it. (other values are max to find the least.)
it starts checking 2 to 3 2 to 1 and writes 0 1 1. (1's are for number 2)
and than it tries 3 it checks 3 to 1 3 to other 1 and finally 3 to 4. (From the least jump starts adding 2 so the previous jump array is 0 1 1 2 2 )
it chose 1 because it had the least jump. Comparing 1 and 2.
When our jump array reaches the length of the given array the last index is the answer since it holds the least number of jumps.

****THIS PART IS WRITTEN FOR A BETTER EXPLANATION IN THE PRESENTATION ON SATURDAY****
arr = [2,3,1,1,4]
for i = 0
	jump[1] = 1
	jump[2] = 1
for i = 1
	jump[2] = 1 (As I said ıt takes the min(2,1))
	jump[3] = 2
	jump[4] = 2
	jump[5] = 2
 
*/



