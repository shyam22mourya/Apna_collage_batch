package Assingmants ; 
  public class bit {
     public static void swap ( ) {
           int x = 3; 
           int y = 4; 
           x = x^y; 
           y = x^y; 
          x = x^y ; 
            System.out.println( "x value : "+x+ " y value : "+ y );
     }
     public static void Inder ( ){
           int x = 6; 
            System.out.println(x +" + "+1 +" is "+ -~x);
             x = -4  ; 
            System.out.println(x +" + "+1 +" is "+ -~x);
             x  =0; 
            System.out.println(x +" + "+1 +" is "+ -~x);

     }
      public static void Upper(){
        for ( char i = 'A' ; i <='Z' ; i++ ){
             System.out.print((char)(i |' '));
        }
      }
     public static void main(String[] args) {
    //    swap(); 
        // Inder();
        Upper();
    }
}
