package OPPS;

public class Polymorphim { 
    public static void main(String[] args) {
          Methodover me =  new Methodover() ; 
          me.sum();
    }

}
 class Methodoverloding{

       int sum ( int i , int j ){
         return i+j ; 
       }
       float  sum ( float  i , float j ){
        return i+j ; 
      } double sum (  double i , double j ){
        return i+j ; 
      }
 }

 class MethodOverriding{
     
      void sum (){
         System.out.println( " Sum to umique number ");
      }
 }
 class Methodover extends MethodOverriding{

     void sum (){
         System.out.println("SUm is two binary ");
     }
 }
