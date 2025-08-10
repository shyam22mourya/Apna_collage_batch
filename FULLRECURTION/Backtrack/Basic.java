package FULLRECURTION.Backtrack;

import Queue.Dueue.stack;

public class Basic {
    // Q findsubset O( n*n^n) ;
    public static void findsubset(String str, String ans, int i) {
        // base case
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null");
            } else {
                System.out.println(ans);
            }
            return;
        }
        // recurtine
        // yes choise
        findsubset(str, ans + str.charAt(i), i + 1);
        // no chiose
        findsubset(str, ans, i + 1); // backtracking step
    }

    // Q find all permutation
    // O(n*n!) ;
    public static void findper(String str, String newStr) {
        // base case
        if (str.length() == 0) {
            System.out.println(newStr);
            return;
        }
        // recurtine
        for (int i = 0; i < str.length(); i++) {

            char currchar = str.charAt(i);
            String newstring = str.substring(0, i) + str.substring(i + 1);
            findper(newstring, newStr + currchar);

        }
    }

    public static void permutation (String str ,String ans){
         //base case 
          if(str.isEmpty()){
            System.out.println(ans);
            return ;
          }
           // recursion 
           for(int i = 0 ; i<str.length() ; i++){
             char currchar = str.charAt(i); 
             String newString = str.substring(0, i)+str.substring(i+1);
             permutation(newString, ans);
           }
    }

    public static void full(int[] arr, int idx, int value) {
        // base case
        if (idx == arr.length) {
            printarr(arr);
            return;
        }

        // recursion

        arr[idx] = value;
        full(arr, idx + 1, value + 5);
        arr[idx] = arr[idx] - 2; // restore the original value during backtracking
    }

    public static void printarr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int grind(int i, int j, int n, int m) {
        // base case
        if (i == n - 1 && j == m - 1) { // commond for last cell
            return 1;
        } else if (i == n || j == m) { // boundry of grid
            return 0;
        }
        // recurtion
        int way1 = grind(i + 1, j, n, m);
        int way2 = grind(i, j + 1, n, m);
        return way1 + way2;
    }

    public static void main(String[] args) {
        // int[] arr = new int[5];
        // full(arr, 0, 1);
        // printarr(arr);
        // findsubset("abc", "", 0);
        // findper("ABC", "");
System.out.println( grind(0, 0, 4, 5));
    }
}
