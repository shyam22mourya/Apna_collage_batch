package Assingmants;
import java.util.Arrays;

public class Solution {
  public static void println(int[] pal) {
    for (int i = 0; i < pal.length; i++) {
      System.out.print(pal[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    String plants[] = { "sun", "earth", "mars", "jupiter", "mercury", "vense", "saturn " };
    int arr[] = { 1, 1, 4, 5, 1, 1, 2, 4, 1 };
    int ar[] = { 1, 20, 6, 4, 5 };
    System.out.println(inver(ar, 0, arr.length - 1));
    // int so = winner(arr) ;
    // System.out.println(so);
  }

  // Q1 assiments there using fo merge sort i used comparto function ;
  public static void merge(String[] plan, int left, int right) {
    if (left >= right) {
      return;
    }
    int mid = left + (right - left) / 2;

    merge(plan, left, mid);
    merge(plan, mid + 1, right);
    merge(plan, left, right, mid);
  }

  public static void merge(String[] plan, int left, int right, int mid) {
    String tem[] = new String[right - left + 1];

    int l = left;
    int m = mid + 1;
    int k = 0;

    while (l <= mid && m <= right) {

      // compare the string
      if (plan[l].compareTo(plan[m]) <= 0) {
        tem[k] = plan[l];
        l++;
      } else {
        tem[k] = plan[m];
        m++;
      }
      k++;
    }

    while (l <= mid) {
      tem[k] = plan[l];
      l++;
      k++;
    }
    while (m <= right) {
      tem[k++] = plan[m++];
      m++;
      k++;
    }
    // COPY VALUE TEM STIRING ARRYS TO ORRIJANL
    for (int i = 0; i < tem.length; i++) {
      plan[i + left] = tem[i];
    }
  }

  // Q2 print the mesurity elemens
  // it is the Boyer more voting Algorithum
  // O(nlogn);
  public static int winner(int arr[]) {
    int winner = arr[0];
    int lead = 1;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] == winner) {
        lead++;
      } else if (lead > 0) {
        lead--;
      } else {
        winner = arr[i];
        lead = 1;
      }
    }
    return winner;
  }

  // invertion counting

  public static int inver(int[] arr, int left, int right) {
    int inv = 0;

    if (left < right) {
      int mid = left + (right - left) / 2;

      inv = inver(arr, left, mid);
      inv += inver(arr, mid + 1, right);
      inv += inver(arr, left, mid, right);
    }
    return inv;
  }
  public static int inver(int arr[], int l, int m, int r) {
    // left subarray ;
    int[] left = Arrays.copyOfRange(arr, l, m + 1);
    // right subarray ;
    int[] right = Arrays.copyOfRange(arr, m +1, r +1);

    int i = 0, j = 0, k = l, swaps = 0; // Fix: Initialize k to l instead of 1
    while (i < left.length && j < right.length) {

        if (left[i] <= right[j]) {
            arr[k++] = left[i++];
        } else {
            arr[k++] = right[j++];
            swaps += (m - i);
        }
    }

    while (i < left.length) {
        arr[k++] = left[i++];
    }

    while (j < right.length) {
        arr[k++] = right[j++];
    }
    return swaps;
}

  

}
