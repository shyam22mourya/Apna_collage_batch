package Bit.Strings;
public class Strings {
      public static void compare  (){
         String str = "hello"; 
        String str1 = "hello" ;  
         String str3 = "seds";
         String str2 = new String("hello") ; 
          if(  str == str2){
             System.out.println("String is euaal");
          }else {
            System.out.println("String is  not euaal");     
          }
      System.out.println(  str3.compareTo(str1)) ; 
        if(  str.equals(str2) ){
            System.out.println("String is euaal");
         }else {
           System.out.println("String is  not euaal");
            
         }

      }
      public static void  printLetter ( String str){
         for( int i = str.length()-1 ; i>= 0 ; i--){
             System.out.print(str.charAt(i)+" ");
         }
      }
    public static void main(String[] args) {
         String str = "abcd shyam" ; 
         System.out.println(str.length()); 
          
//  CONCATENATION 
String firstname = "Shyam" ; 
 String lastname = " Rajput" ; 
 String fullname = firstname+" "+lastname ; 


System.out.println(fullname.charAt(0));
    //  printLetter(fullname);

compare();}
}
