import java.util.*;

public class Hanoi
{
    public static void main(String[] args)
    {
        Scanner myscan = new Scanner(System.in);
        System.out.println("Welcome to the game of Hanoi!..");
        int x = 1, y = 2, z = 3, a = 0, b = 0, c = 0, d = 0, e = 0, f = 0, legal = 0, illegal = 0, k1 = 0, k2 = 0, k3 = 0, l1 = 0, l2 = 0, l3 = 0;
        String game = "\n" + x + "\t\t" + a + "\t\t" + d + "\n" + y + "\t\t" + b + "\t\t" + e + "\n" + z + "\t\t" + c + "\t\t" + f + "\n";
        System.out.println(game.replace("0", ""));

        while (d != 1)
        {
            String pegA = x + "" + y + "" + z;
            String pegB = a + "" + b + "" + c;
            String pegC = d + "" + e + "" + f;
            System.out.println("Please make a move:");
            String move = myscan.next();
            if ((move.equals("A-A") && (z > 0)) || (move.equals("B-B") && (c > 0)) || (move.equals("C-C") && (f > 0)))
            {
                legal++;
                System.out.println(game.replace("0", ""));
            }
            else if ((move.equals("A-A") && (z == 0)) || (move.equals("B-B") && (c == 0)) || (move.equals("C-C") && (f == 0)) || (move.equals("A-B") && (z == 0)) || (move.equals("A-C") && (z == 0)) || (move.equals("B-C") && (c == 0)) || (move.equals("B-A") && (c == 0)) || (move.equals("C-B") && (f == 0)) || (move.equals("C-A") && (f == 0)))
            {
                illegal++;
                System.out.println("Illegal move: peg is empty.");
                System.out.println(game.replace("0", ""));
            }
            else
            {
                if (move.substring(0, 1).equals("A"))
                {
                    k1 = pegA.charAt(0) - '0';
                    k2 = pegA.charAt(1) - '0';
                    k3 = pegA.charAt(2) - '0';
                }
                if (move.substring(0, 1).equals("B"))
                {
                    k1 = pegB.charAt(0) - '0';
                    k2 = pegB.charAt(1) - '0';
                    k3 = pegB.charAt(2) - '0';
                }
                if (move.substring(0, 1).equals("C"))
                {
                    k1 = pegC.charAt(0) - '0';
                    k2 = pegC.charAt(1) - '0';
                    k3 = pegC.charAt(2) - '0';
                }
                if (move.substring(2, 3).equals("A"))
                {
                    l1 = pegA.charAt(0) - '0';
                    l2 = pegA.charAt(1) - '0';
                    l3 = pegA.charAt(2) - '0';
                }
                if (move.substring(2, 3).equals("B"))
                {
                    l1 = pegB.charAt(0) - '0';
                    l2 = pegB.charAt(1) - '0';
                    l3 = pegB.charAt(2) - '0';
                }
                if (move.substring(2, 3).equals("C"))
                {
                    l1 = pegC.charAt(0) - '0';
                    l2 = pegC.charAt(1) - '0';
                    l3 = pegC.charAt(2) - '0';
                }
                if (move.equals("A-B") || move.equals("A-C") || move.equals("B-A") || move.equals("B-C") || move.equals("C-B") || move.equals("C-A"))
                {
                    if (k1 != 0)
                    {
                        l3 = k1;
                        k1 = 0;
                        legal++;
                    }
                    else if (k1 == 0 & k2 > 0 & l3 == 0)
                    {
                        l3 = k2;
                        k2 = 0;
                        legal++;
                    }
                    else if (k1 == 0 & k2 > 0 & l3 > 0 & l3 > k2)
                    {
                        l2 = k2;
                        k2 = 0;
                        legal++;
                    }
                    else if (k1 == 0 & k2 == 0 & k3 > 0 & l3 == 0)
                    {
                        l3 = k3;
                        k3 = 0;
                        legal++;
                    }
                    else if (k1 == 0 & k2 == 0 & k3 > 0 & l3 > k3 & l2 == 0)
                    {
                        l2 = k3;
                        k3 = 0;
                        legal++;
                    }
                    else if (k1 == 0 & k2 == 0 & k3 > 0 & l3 > k3 & l2 > k3 & l1 == 0)
                    {
                        l1 = k3;
                        k3 = 0;
                        legal++;
                    }
                    else
                    {
                        illegal++;
                        System.out.println("Illegal move: bigger disk cannot be placed on top of smaller disk");
                    }
                }
                if (move.substring(0, 1).equals("A"))
                {
                    x = k1;
                    y = k2;
                    z = k3;
                }
                if (move.substring(0, 1).equals("B"))
                {
                    a = k1;
                    b = k2;
                    c = k3;
                }
                if (move.substring(0, 1).equals("C"))
                {
                    d = k1;
                    e = k2;
                    f = k3;
                }
                if (move.substring(2, 3).equals("A"))
                {
                    x = l1;
                    y = l2;
                    z = l3;
                }
                if (move.substring(2, 3).equals("B"))
                {
                    a = l1;
                    b = l2;
                    c = l3;
                }
                if (move.substring(2, 3).equals("C"))
                {
                    d = l1;
                    e = l2;
                    f = l3;
                }
                game = "\n" + x + "\t\t" + a + "\t\t" + d + "\n" + y + "\t\t" + b + "\t\t" + e + "\n" + z + "\t\t" + c + "\t\t" + f + "\n";
                System.out.println(game.replace("0", ""));
            }
        }
        System.out.println("Congratulations you won!..\nYou made " + legal + " legal moves to win.\nAlso you tried to make " + illegal + " illegal moves.");
    }
}
