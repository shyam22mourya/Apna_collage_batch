package Assingmants;

public class Arayas {
    // Duplicate sum
    public static boolean Q1(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    return true;
                }
            }
        }
        return false;
    }
 
    // print Binary 
    
    // print Total PROFIT ;
    public static void Q3(int[] arr) {
        int BuyPrice = Integer.MAX_VALUE;
        int ts = 0;

        for (int i = 0; i < arr.length; i++) {
            if (BuyPrice < arr[i]) {// profit
                int profit = arr[i] - BuyPrice;
                ts = Math.max(profit, ts);
            } else {
                BuyPrice = arr[i];
            }

        }
        System.out.println(ts);

    }

    // Trapping rain water ;
    public static void Q4(int[] hight) {
        // leftmax bounrty
        int n = hight.length;
        int[] leftmax = new int[n];
        leftmax[0] = hight[0];
        for (int i = 1; i < n; i++) {
            leftmax[i] = Math.max(leftmax[i - 1], hight[i]);
            System.out.print(leftmax[i] +" ");
        }
        System.out.println();
        // right max boundry
        int[] rightmax = new int[n];
        rightmax[n - 1] = hight[n - 1];
        for (int i = n - 2; i >=0; i--) {
            rightmax[i] = Math.max(rightmax[i + 1], hight[i]);
        System.out.print(rightmax[i]+" ");
        }
        System.out.println();

        // loops
        int Trapping = 0;
        for (int i = 0; i < n; i++) {
            // calculate watervlevel
            int waterlevel = Math.min(leftmax[i], rightmax[i]);
            Trapping += waterlevel - hight[i];
        }
        System.out.println(Trapping);

    }

    // return all 3sum ;
    public static void Q5(int[] arr) {
        int a = arr.length;
        for (int i = 0; i < a; i++) {
            for (int j = i + 1; j < a; j++) {
                for (int k = j + 1; k < a; k++) {

                    if (i != j && i != k && j != k && (arr[i] + arr[j] + arr[k]) == 0) {
                        System.out.print("( " + arr[i] + " " + arr[j] + " " + arr[k] + " ) ");
                    }
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int arr[] = { -1, 0, 1, 2, -1, -4 };
        int price[] = { 7, 1, 6, 4, 3, 2 };
        Q4(price);
        Q1(arr);
    }
}
