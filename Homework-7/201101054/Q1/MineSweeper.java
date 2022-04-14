import java.util.*;
public class MineSweeper 
{
    	static ArrayList<String> checked = new ArrayList<>();

    	public static void main(String[] args) 
    	{
        	Scanner scan = new Scanner(System.in);
        	Scanner myscan = new Scanner(System.in);
        	Random mines = new Random();

        	System.out.println("Please enter the size of the board (m x n) : "); //For example 3 x 3
        	String str = scan.nextLine();

        	//Let's try to get the the x-axis and y-axis length
        	int first_index = str.indexOf(" ");
        	int m = Integer.parseInt(str.substring(0, first_index));
        	int second_index = str.lastIndexOf(" ");
        	int n = Integer.parseInt(str.substring(second_index + 1));

        	int[][] field = new int[m][n]; //created our field
        	//Don't forget that the normal x and y axis are swaped in this homework I don't know why :D

        	//Let's define the difficulty. %15 mines --> Easy, %25 --> Medium, %40 --> Hard.
        	System.out.println("Please select the difficulty (E, M, H): ");
        	String diffi = scan.next();
        	int count = 0;
        	int amount_of_bombs = 0;
		
		// Creating bombs by the diffuculty.
        	if (diffi.equals("E")) 
        	{
            		while (count < (m * n * 15 / 100)) 
            		{
                		amount_of_bombs = m * n * 15 / 100;
                		int x_place = mines.nextInt(m);
                		int y_place = mines.nextInt(n);
                		if (field[x_place][y_place] != -1) 
                		{
                    			field[x_place][y_place] = -1;
                    			count++;
                		}
            		}
        	} 
        	else if (diffi.equals("M")) 
        	{
            		while (count < (m * n * 25 / 100)) 
            		{
                		amount_of_bombs = m * n * 25 / 100;
                		int x_place = mines.nextInt(m);
                		int y_place = mines.nextInt(n);
                		if (field[x_place][y_place] != -1) 
                		{
                    			field[x_place][y_place] = -1;
                    			count++;
                		}
            		}
        	} 
        	else 
        	{
            		while (count < (m * n * 40 / 100)) 
            		{
                		amount_of_bombs = m * n * 40 / 100;
                		int x_place = mines.nextInt(m);
                		int y_place = mines.nextInt(n);
                		if (field[x_place][y_place] != -1) 
                		{
                    			field[x_place][y_place] = -1;
                   			count++;
                		}
            		}
        	}
        	int result = 0;

        	String[][] game = new String[m][n];
        	for (int j = 0; j < game.length; j++)
           		for (int k = 0; k < game[j].length; k++)
                		game[j][k] = "o";

		// The Game!!!!
        	print2DArrayString(game);
        	while (result != 1) 
        	{
            		System.out.println("Please make a move:");
            		String move = myscan.nextLine();
            		move = coorToIndex(move, field);
            		int x = xAxis(move);
            		int y = yAxis(move);

            		if (move.contains("F")) 
            		{

                		if (game[x][y].equals("o"))
                    			game[x][y] = "F";
                		else if (!game[x][y].equals("o") && !game[x][y].equals("F"))
                    			System.out.println("Open cells cannot be flagged");
                		else if (!game[x][y].equals("o") && game[x][y].equals("F"))
                    			System.out.println("The cell is already flagged");

                		print2DArrayString(game);
              		}
               		else if (move.contains("U")) 
               		{
                		if (game[x][y].equals("F"))
                    			game[x][y] = "o";

                		else if (!game[x][y].equals("F") && game[x][y].equals("o"))
                    			System.out.println("Only flagged cells can be unflagged");
                
                		else if (!game[x][y].equals("F") && !game[x][y].equals("o"))
                    			System.out.println("Only flagged cells can be unflagged");
                		print2DArrayString(game);
            		}
            		else if (isAMine(move, field)) 
            		{
                		for (int i = 0; i < field.length; i++)
                		{
                    			for (int j = 0; j < field[0].length; j++)
                        			if (field[i][j] == -1)
                            				game[i][j] = "X";
                            	}
           			result++;
                		print2DArrayString(game);
                		System.out.println("You lost, better luck next time.");
            		} 
             		else if (!move.contains("U") && !move.contains("F")) 
             		{
                		if (!game[x][y].equals("o") && !game[x][y].equals("F"))
                		{
                    			System.out.println("The cell is already open");
                    			print2DArrayString(game);
                    		}
                    		else if (game[x][y].equals("F"))
                    		{
                    			System.out.println("Flagged cells cannot be opened");
                    			print2DArrayString(game);
                    		}
                		else 
                		{
                    			open(x, y, field, game);
                    			print2DArrayString(game);
                		}
                	
                	if (win(field, game, amount_of_bombs))
                	{
                    			System.out.println("Congratulations, you won.");
                    			result++;
                    			print2DArrayString(game);
                	}

            		}
        	}
    	}
    	
    	public static void print2DArrayString(String[][] array)
    	{
    		for (int i = 0; i < array.length; i++)
    		{
    			for (int j = 0; j < array[0].length; j++)
    				System.out.print(array[i][j] + " ");
    			System.out.println();
    		}
    	}

    	public static boolean isAMine(String str, int[][] array) // Checks if the move is a mine or not.
    	{
        	int x = xAxis(str);
        	int y = yAxis(str);

        	if (array[x][y] == -1)
            		return true;
        	else
           		return false;
    	}

    	public static boolean isValid(String move, int[][] array) // Checks if the move is valid or not.
    	{
       		int x = xAxis(move);
        	int y = yAxis(move);

        	int x_len = array.length;
        	int y_len = array[0].length;

        	if (x < x_len && y < y_len && 0 <= x && 0 <= y)
            		return true;
        	else
            		return false;
    	}

    	public static String coorToIndex(String move, int[][] table) // Converting between the coordinates to indexes
    	{
        	int x = xAxis(move);
        	int y = yAxis(move);
        	int x_index = table.length - x;
        	int y_index = y - 1;
        	String new_move;
        	if (move.contains(" "))
            		new_move = x_index + "," + y_index + move.substring(move.indexOf(" "));
        	else
            		new_move = x_index + "," + y_index;

        	return new_move;
    	}

    	public static void open(int x, int y, int[][] field, String[][] game) // Opening a mine and using recursion if the mine has no mines surrounded
    	{
        	int count = 0;
        	for (int i = x - 1; i <= x + 1; i++)
       	 	{
            	for (int j = y - 1; j <= y + 1; j++)
                	if (isValid(i + "," + j, field) && !game[i][j].equals("F") && !game[i][j].equals("-") && (j != y || i != x))
                    		if (isAMine(i + "," + j, field))
                       		 	count++;
        	}
        	if (count == 0) 
        	{
            		game[x][y] = "-";
            		for (int i = x - 1; i <= x + 1; i++)
                		for (int j = y - 1; j <= y + 1; j++)
                    			if (isValid(i + "," + j, field) && (j != y || i != x) && !game[i][j].equals("-"))
                        			open(i, j, field, game);
        	} 
        	else
            		game[x][y] = count + "";

    	}

    	public static int xAxis(String move) // returns the index of x
    	{
        	int index = move.indexOf(",");
        	int x = Integer.parseInt(move.substring(0, index));
        	return x;
    	}

    	public static int yAxis(String move) //returns the index of y
    	{
        	int index = move.indexOf(",");
        	int y = 0;
        	if (move.contains(" "))
        	    	y = Integer.parseInt(move.substring(index + 1, move.indexOf(" ")));
        	else
            		y = Integer.parseInt(move.substring(index + 1));
        	return y;
    	}

    	public static boolean win(int[][] array1, String[][] array2, int bombs) //Checking if the player won. By calculating the numbers of the mines and non-mines.
    	{
        int check1 = 0, check2 = 0;
        	for (int i = 0; i < array1.length; i++) 
        	{
            		for (int j = 0; j < array1[0].length; j++)
                		if (array2[i][j].equals("o") && array1[i][j] == -1)
                    			check1++;
                    		else if ((array2[i][j].equals("F") || array2[i][j].equals("o")) && array1[i][j] != -1)
                    			check2++;	
        	}
        if (check1 == bombs && check2 == 0)
            return true;
        else
            return false;

    	}
}
