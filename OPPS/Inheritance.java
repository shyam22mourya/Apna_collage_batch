package OPPS;

public class Inheritance {
    public static void main(String[] args) {
        Fish shark = new Fish() ; 
         shark.eat();
        // shark.breathe(); 
         shark.swim() ; 
         
    }
}

 class Pat {
      String colour ; 
       
      void  eat(){
         System.out.println(" Eats");
      } 
      void breathe (){
         System.out.println("breathes");
      }
 }

 class mamals extends Pat {
    int lages ;
 }
 
 class Dog  extends mamals {
    String bread ; 
 }
 class Fish extends Pat {
     int fins ; 
     void  swim (){
    System.out.println(" Swim is imp ");  
     }
 }
