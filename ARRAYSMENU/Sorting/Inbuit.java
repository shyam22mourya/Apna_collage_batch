package ARRAYSMENU.Sorting;

import java.util.* ; 
public class Inbuit {
    public static void printarr(Integer [] nums){
        for ( int i = 0 ; i<nums.length; i++){
          System.out.print(nums[i]+" ");
        } 
        System.out.println();
      }
     public static void main(String[] args) {
         Integer []arr = {4,5,3,1,2} ; 
         Arrays.sort(arr, 0, 3,Collections.reverseOrder()) ;
         printarr(arr); 
            }
}
