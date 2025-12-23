package Java8Features;

import Tries.pQuetion;

public class lamdaExp {
    public static void main(String[] args) {

        // Runnable t1 = ()->{
        //  System.out.println("run the code");
        // }; 
        
        // Thread t2 = new Thread(t1); 
        // t2.start();

        MathOperation sum1 = (int a , int b )->{
             return a+b ; 
            };

        MathOperation sum = (a , b) -> a+b; 
        MathOperation min = (a , b) -> a-b; 
        MathOperation mul = (a , b) -> a*b; 
        MathOperation div = (a , b) -> a%b; 


         System.out.println(sum.operation(2 , 5));
         System.out.println(min.operation(2 , 5));
         System.out.println(mul.operation(2 , 5));
         System.out.println(div.operation(2 , 5));

    }
}


@FunctionalInterface
 interface MathOperation {
    public int operation(int a , int b); 
}

class Task implements Runnable {

     public void run(){
         System.out.println("thread running ");
     }
}