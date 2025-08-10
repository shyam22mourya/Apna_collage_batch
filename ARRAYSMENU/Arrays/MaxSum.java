package ARRAYSMENU.Arrays;

public class MaxSum {
    // Brute force
    // Time COm = O(n^3)
    public static void MaxSumArray(int[] arr) {
        int CurrSum = 0;
        int MaxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                CurrSum = 0;
                for (int k = i; k <= j; k++) {

                    CurrSum += arr[k];
                    MaxSum = Math.max(MaxSum, CurrSum);
                }
                // System.out.println(CurrSum);

            }

        }
        System.out.println("Max sum  =  " + MaxSum);
    }

    public static void Prefixsum(int num[]) {
        int Maxsum = Integer.MIN_VALUE;
        int CurrSum = 0;

        // Calculate Prifix sum ;
        int[] Prifix = new int[num.length];
        Prifix[0] = num[0];

        for (int i = 0; i < num.length; i++) {
            int start = i;
            for (int j = i; j < num.length; j++) {
                int end = j;
                CurrSum = 0;
                // calculate CurrSum
                CurrSum = start == 0 ? Prifix[end] : Prifix[end] - Prifix[start - 1];
                // Find MaxSum
                if (Maxsum < CurrSum) {
                    Maxsum = CurrSum;
                }

            }
        }
        System.out.println("Max sum = " + Maxsum);
    }

    public static void kadane(int[] num) {
        int ms = Integer.MIN_VALUE;
        int cs = 0;

        for (int i = 0; i < num.length; i++) {

            cs = Math.max(num[i], cs + num[i]);
            ms = Math.max(cs, ms);

        }
        System.out.println(" Max sum = " + ms);
    }

    public static void main(String[] args) {
        int arr[] = { 1, -2, 6, -1, 3 };
        int num[] = { -2, -3, -4, -1, -2, -1, -5, -3 };
        Prefixsum(arr);
        //   kadane(arr);
        MaxSumArray(num);

    }

}
