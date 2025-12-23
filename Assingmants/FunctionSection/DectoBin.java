package Assingmants.FunctionSection;

import java.util.ArrayList;

public class DectoBin {

    public static void DecToBin(int Dec) {
        int myNum = Dec;
        int pow = 0;
        int bin = 0;

        while (Dec > 0) {
            int rem = Dec % 2;
            bin = bin + (int) (rem * Math.pow(10, pow));
            pow++;
            Dec = Dec / 2;
        }
        System.out.println(myNum + "Decimal to  =  " + bin);
    }

    public static void subSet(int i, int[] arr, ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> list) {
        if (i == arr.length) {
            list.add(new ArrayList<>(ans));
            return ; 
        }
        // pick
        ans.add(arr[i]);
        subSet(i + 1, arr, ans, list);
        ans.remove(ans.size() - 1);
        // not pick
        subSet(i + 1, arr, ans, list);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        subSet(0, arr, new ArrayList<>(), ans);
        System.out.println(ans);
    }
}
