package ARRAYSMENU.Arraylist;

import java.util.*;

public class Pairsum {
    public static boolean pairsum1(ArrayList<Integer> list, int target) {
        // brute force
        // O(n^2) ;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) + list.get(j) == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean pairsum2(ArrayList<Integer> list, int target) {
    // 2 pointer approach  O(n)  ; 
        int lp = 0, rp = list.size() - 1;
        while (lp != rp) {
            if (list.get(lp) + list.get(rp) == target) {
                return true;
            }
            if (list.get(lp) + list.get(rp) < target) {
                lp++;
            } else if (list.get(lp) + list.get(rp) > target){
                rp--;
            }
        }
        return false ; 
    }
 
    public static boolean pairsum3 ( ArrayList <Integer> list , int target ){  
           // tow pointer approach  O(n) ; 
              int bp = -1 ; 
               int n = list.size() ; 
                for ( int i  = 0 ;   i<n ; i++) {
                     if ( list.get(i) > list.get(i+1)) {
                        bp = i ; 
                        break ;  
                     }
                    
                }
              int lp = bp+1; 
               int rp = bp ; 
                 
               while (lp!=rp) {
                   if ( list.get(lp)+list.get(rp)== target){ 
                     return true; 
                   }
                    if (list.get(rp)+list.get(lp)< target) {
                        lp = (lp+1)%n ; 
                    } 
                    else{ 
                         rp = (n+rp-1)%n; 
                    } 
               }
           return false ; 
            }

            public static void main(String[] args) {
        ArrayList<Integer> hight = new ArrayList<>();
        hight.add(11);
        hight.add(15);
        hight.add(6);
        hight.add(8);
        hight.add(9);
        hight.add(10);

   System.out.println(pairsum3(hight, 19) );
        
    }
}
