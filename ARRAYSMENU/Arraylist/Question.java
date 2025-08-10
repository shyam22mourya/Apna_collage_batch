package ARRAYSMENU.Arraylist;

import java.util.*;

public class Question { 
    //  GET SWAP FUNCTION ;
    public static void swap(ArrayList<Integer> list, int indx1, int indx2) {
        int temp = list.get(indx1);
        list.set(indx1, list.get(indx2));
        list.set(indx2, temp);
    }

    public static void main(String[] args) {
          ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(6);
        list.add(8);
        System.out.println(list);
        int inx1 = 1, inx2 = 3;
        swap(list, inx1, inx2);
        // acending order ; 
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list, Collections.reverseOrder());
        // decending order ; 
        System.out.println(list);
          // FIND MAX ELEMEMT ;
         // O(n);

        // int max = Integer.MIN_VALUE ;
        // for ( int i = 0 ; i< list.size(); i++){ // time com = O(n)
        // max = Math.max(max, list.get(i)) ;
        // }
        // System.out.println(" max element "+ max);

    }
}
