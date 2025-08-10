package Bit;

public class Qbit {

    // Q1
    public static void Iseven(int n) {

        int bitmash = 1;
        if ((n & bitmash) == 0) {
            System.out.println("It is even number");
        } else {
            System.out.println(" it is odd number");
        }
    }

    public static boolean istWopower(int n) {
        return (n & (n - 1)) == 0;
    }

    public static int Countbit(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) != 0) {
                count++;
            }

            n = n >> 1;
        }
        return count;
    }

    public static int FastExpnation(int x, int n) {
        int ans = 1;
        while (n > 0) {
            if ((n & 1) != 0) {
                ans = x * ans;
            }
            x = x * x;
            n = n >> 1;

        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(FastExpnation(2, 5));
    }
}
