package Assingmants.FunctionSection;

public class Pallandrom {
      
      public static void Pallandro (int num){ 
        int Curr = num ;

         int rev  = 0 ; 
          while (num>0) {
             int lastdigit =  num%10 ;  
              rev = lastdigit+rev*10 ; 
               num= num/10 ;     
          }  
             if( Curr == rev ){
             System.out.println(   "This is number is pallandrom "); 
             }else{
               System.out.println(  "This is number not pallandrom ");
             }
         
      }
    public static void main(String[] args) {
      Pallandro(132);   
    }
}
