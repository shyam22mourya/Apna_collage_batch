package ARRAYSMENU.Arrays;
// Find minimum number of merge operations to make an array palindrome ; 
 // time O(n) ;  space O(1) ; 
public class Optimal { 
      public static   int mergeoptimal ( int []arr ){
           int  flage = 0 ;  ; 
             int start = 0 ; 
               int end = arr.length-1 ; 
               while (start <=end) {
                  if ( arr[start]== arr[end]){
                     start++ ; 
                     end --; 
                  } else 
                  if ( arr[start]< arr[end]){
                         start++ ; 
                         arr[start]+=arr[start-1];  
                         flage++ ; 
                  }  else { 
                   end-- ;  
                    arr[end] +=arr[end+1];
                    flage++ ;
                  }
               }
        return flage ; 
      }
 public static void main(String[] args) {
     int []arr  = { 1 ,2 , 5,3,2 ,1};
      int  metge = mergeoptimal(arr) ; 
      System.out.println(metge);
 }
}
