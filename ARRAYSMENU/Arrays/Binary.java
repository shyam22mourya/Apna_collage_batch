package ARRAYSMENU.Arrays;

public class Binary {
    public static int Binarysearch(int number[], int key) {
        int star = 0;
        int end = number.length - 1;
        for (int i = star; i <= end; i++) {
            int mid = (star + end) / 2;

            // Comparisons
            if (number[mid] == key) {
                return mid;
            }

            if (number[mid] < key) { // Right
                star = mid + 1;
            } // left
            else {
                end = mid - 1;
            }

        }
        return -1;

    }

    public static int getbinaraysearch(int num[], int key) {
        int st = 0;
        int n = num.length;
        int ed =n-1;
        while (st <= ed) {
            int mid = (st + ed) / 2;
            if (num[mid] == key) {
                // System.out.println("key found in "+mid+"this index");
                return mid;
            }
            if (num[mid] < key) {
                st = mid + 1;
            } else {
                ed = mid - 1;
            }

        }
        return -1; 
    }

    public static void main(String[] args) {
        int number[] = { 2, 4, 6, 8, 10, 12, 14, 16 };
        int key = 10;
        System.out.println(" Key is found in  : " + getbinaraysearch(number, key));
    }
}
