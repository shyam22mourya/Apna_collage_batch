
package Assingmants.FunctionSection ; 
 public class  BinarytoDec {
    public static void bintoDec( int n ){
        int pow  = 0; 
         int Dec = 0; 
          while (n >0 ){
            int lastdigit = n%10;   

        Dec = Dec+ (int)(lastdigit *Math.pow(2, pow)) ;  
        pow++ ; 
        n = n/10 ; 
          }
 
          System.out.println( Dec); 
    } 
   public static void main(String[] args) {
    bintoDec(111);
   } 
 }