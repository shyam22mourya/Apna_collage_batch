package ARRAYSMENU.Arrays;

public class Largest {  
    public static int   getSmallest(int[] num ){
        int small = Integer.MAX_VALUE ; 
         for ( int i = 0 ;  i < num.length ; i++){
             if( num[i]< small ){
                small = num[i ] ; 
             }
         } 
          return small ; 
    }
     public static int   getlargest(int[] num ){
         int largest = Integer.MIN_VALUE ; 
          for ( int i = 0 ;  i < num.length ; i++){
              if( num[i]> largest ){
                 largest = num[i ] ; 
              }
          } 
           return largest ; 
     }
    public static void main(String[] args) {
         int num [] = { 1,2,3 ,20,4,5,6} ; 
        System.out.println( " Largest number is :  "+ getlargest(num));  
        System.out.println( " smallest number is :  "+ getSmallest(num));  

    }
}
