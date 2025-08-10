package FULLRECURTION.Backtrack.Recurtion;

public class Recurtion {     
    //  print  n to 1 (Decrision order me )
    public  static void  print( int n ){   
        if ( n == 1 ){
           System.out.print(1+ " ");
           return ; 
        }
        System.out.print(n+" " );
        print(n-1);
   } 
    // print 1  to n 
     public static void printp ( int n ){
           if(n ==1 ){
             System.out.println( n+" "); 
              return ;
           }
         printp(n-1);
          System.out.println(n);
     }
  // sum  of first n natural number 
    public static  int  sum ( int n ){

          if ( n ==  1 ){
             return  1; 
          } 
           return n+sum(n-1) ; 
    }
        // print factoral of of n numbers
    public static  int  fact ( int n ){
        
          if ( n ==  0 ){
             return  1; 
          } 
           return n*fact(n-1) ; 
    }
 // print  nTh febunachi number 
    public static int fedunachi ( int n ){
         if ( n == 0 || n ==1) {
            return n ; 
         } 
          int fedn1  = fedunachi(n-1); 
          int fedn2 = fedunachi( n-2); 
            
           return  fedn1 +fedn2 ; 

    }
    public static void main(String[] args) {
       System.out.print ( fedunachi(10)+ " ");
     }
} 
 