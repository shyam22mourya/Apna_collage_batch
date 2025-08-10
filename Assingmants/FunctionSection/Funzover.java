package Assingmants.FunctionSection;
public class Funzover {
     public static int   sum ( int a , int b){
          return a+b ; 
     } 
       // ovrlodng using parameters 
        
     public static int   sum ( int a , int b , int c ){
        return a+b+c ; 
   } 


   //oveloding using  data type  
   public static float    sum ( float a , float b  ){
    return a+b ; 
}


    public static void main(String[] args) {
          System.out.println( sum(50.8f, 78.9f));
    }
}
