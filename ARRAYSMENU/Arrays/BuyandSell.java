package ARRAYSMENU.Arrays;

public class BuyandSell {  
    public static  int buyandsell(int [] prices ){
          int Buyprices = Integer.MAX_VALUE ; 
           int Maxprice = 0 ; 
          for ( int  i = 0 ;i <prices.length ; i++ ){
               if( Buyprices <  prices[i]){ // profit ; 
                 int profit =  prices [i] - Buyprices   ;    // Today  s prices 
                  Maxprice  = Math.max(Maxprice, profit);
                 
               } else {
                Buyprices = prices[i] ; 
               }
          }
           return Maxprice ; 
    }

   public static void main (String [] args ){
       int [] prices = {7,1,5,3,6,4} ; 
        System.out.println(buyandsell(prices));
   }  
}
