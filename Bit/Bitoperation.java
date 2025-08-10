package Bit;
public class Bitoperation { 
    public static  int getbit( int n , int i ){ 
         int bitmask = 1<<i; 
         if ((n&bitmask)==0 ){
            return  0 ; 
         }
         else {
             return 1 ; 
        }
    }
    public static  int setbit( int n , int i ){ 

        int bitmask = 1<<i;
        return n|bitmask ; 
     }
     public static  int clearbit( int n , int i ){ 
        int bitmask = ~(1<<i);
         return n & bitmask ; 
     } 
     public static  int updatebit( int n , int i , int newbit ){

    //      if ( newbit ==0){
    //          clearbit(n , i ) ;
    //      }else { 
    //          setbit(n, i) ;
    //      }
      n = clearbit(n,  i ) ;
        int bitmask = newbit<<  i ; 
        return n|bitmask  ; 
    }
    public static   int cleariThBit ( int n , int i){

         int bitmask = ~(0)<<i; 
         return n&bitmask; 
    }
     public static  int clearBitInRange ( int n , int i , int j ){

         int a = ~(0)<<(j+1) ; 
         int b = (1<<i)-1 ; 
          int bitmask = a|b; 
           return n& bitmask ; 
     }
  
    public static void main(String[] args) {
        System.out.println( setbit(7, 1));

    }
}
