package Assingmants;

import java.util.Arrays;

public class Greedy {
    // Q1 minimum balanced String partitions ; 
     public static void mbspar(String str ){
          int l = 0 , r = 0 , ans = 0 ; 
          for( int i = 0 ; i<str.length() ; i++){
                char ch = str.charAt(i) ; 
                if (ch =='R') {
                     r++ ; 
                }else if( ch == 'L') { 
                  l++ ; 
                }

                if (l==r) {
                    ans++ ; 
                }
          }
          System.out.println( "minimum balanced String partitions "+ans);
     }
// kth largest old element in a given range 
 public static int  kthlagest( int range[] , int k ){
    int l = range[0] ; 
    int r = range[1] ; 
 if (k<=0) {
    return 0 ; 
 }

 if ((r&1)>0) {
     int Count = (int)Math.ceil((r-l+1)/2);
      if (k>Count) {
        return 0 ; 
      }else{
        return (r-2*k+2)  ; 
      }
 }else{
      int count = ( r-l+1)/2 ; 
      if (k>count) {
        return 0 ; 
      }else{
        return (r-2*k+1)  ; 
      }
      
 }
 
 }
    //  Q 3  Lexicographycaly 
    public static String smallString  ( int n , int k){
        StringBuilder sb  = new StringBuilder() ; 
         int total_char = n ; 
         int csum = k ; 

         while (total_char> 0 ) {
            // is it possible  to fill 'a'  here 
             if ((total_char -1)*26 >=(csum-1) ) {
               sb.append('a') ; 
               csum-- ;  
             }else {
                int position = csum%26 ; 
                if (position==0) {
                     sb.append('z'); 
                     csum-=26; 
                }else{
                    sb.append((char)(position-1+'a')) ;
                    csum -= position ;
                }
             }
             total_char--;
         }
         return sb.toString() ; 
    }
    public static  int  maxprofit ( int price[] ){
          int buy = price[0] ; 
           int maxprofit = 0 ; 
              for( int i =  0 ; i< price.length ; i++){
                 if (buy > price[i]) {
                    buy = price[i] ; 
                 }else { 
                     maxprofit = Math.max(maxprofit, price[i]-buy) ; 
                 }
              }
           return maxprofit ; 
    }
  

   // Minimum cost for acquiring all coins with k extra coins allowed with every coin
      public static int  minicoinsum ( int arr[] ,  int k ){
            Arrays.sort(arr); 
              int  reccoin = (int)Math.ceil(( 1.0 * arr.length) / (k+1)) ; 
              int cnt = 0 ; 
               for( int i = 0 ; i< reccoin  ; i++){
                   cnt += arr[i] ; 
               }
               return cnt ; 
      }
    public static void main(String[]arg){
          
      int coin[] = { 8, 5, 3, 10,  
         2, 1, 15, 25 }; 
           
           System.out.println(minicoinsum(coin, 3));          
    }
}
