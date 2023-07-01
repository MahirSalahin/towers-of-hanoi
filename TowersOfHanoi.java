/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class TowersOfHanoi {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        move(n, 'A', 'B', 'C');
        System.out.println();
    }

    public static void move(int n, boolean left) {
        if (n == 0) return;
        move(n - 1, !left);
        if (left) System.out.print(n + " left ");
        else System.out.print(n + " right ");
        move(n - 1, !left);
    }

    public static void move(int n, char from, char temp, char to) {
        if (n == 0) return;
        move(n - 1, from, to, temp);
        System.out.println("Move disc " + n + " from " + from + " to " + to);
        move(n - 1, temp, from, to);
    }
}
