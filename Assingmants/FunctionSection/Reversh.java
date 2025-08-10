package Assingmants.FunctionSection;

public class Reversh {    
       public static   boolean   isPrime (  int  n ){
           
           if ( n==  2 ){
             return  true   ;
           } 
            for ( int i =  2 ;  i < n -1 ; i++ ){
                  if( n%i== 0 ){
                  return false  ;    
                  }   
            } 
             
             return true ; 
             
        
       }
    public static void bin ( int n ){
         int pow = 0 ;  
          int  dec = 0 ; 
           while (n > 0 ) {
              dec = dec +  (int )((n%2) * Math.pow(10, pow)) ; 
              pow++ ; 
              n = n/2 ; 
           } 
            System.out.println( dec);
    }
       public static  int  isreverse (int n ) { 
         int  reverse =  0;
           while (n>0) {
             int  last =  n %10 ; 
                reverse = last + reverse*10 ;    ;  
             n = n /10 ;  
           } 
           return  reverse  ; 
       }
     public static void main(String[] args) { 
          System.out.println( isPrime(5) ); 
     }
}
