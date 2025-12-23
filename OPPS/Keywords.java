package OPPS;


public class Keywords {
    public static void main(String[] args) {
     Horse h = new Horse() ;
     System.out.println(h.colour);
    }
      
}
 class Child  {
       
    static String schoolname ; 
       
       int id   ; 
    String name ; 
       
     void setname ( String name){
         this.name = name ; 
        
     }
       String getname (){
         return this.name ; 
       }
 }

  class Animal {
    String  colour ; 
     Animal(){
         System.out.println("Animal class constructer called");
     }
  }
   class Horse extends Animal { 
     Horse (){ 
        super.colour = " Shu " ; 
         System.out.println("Horse  constructer called ");
     }
     
   }


   