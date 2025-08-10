package ARRAYSMENU.Arrays;

public class Pair {  
     public static void pair (int []num ){ 
          int Tp = 0  ; 
         for (  int i = 0 ;  i<num.length ; i++){
              int curr = num[i]  ; // First number 
               for ( int j = i+1; j <num.length ; j++){
                  System.out.print("("+curr+","+j+")");
                 Tp++ ; 
               } 
            System.out.println();
         }
         System.out.println(Tp);     

     }
     public static void main(String[] args) {
    int [] num = { 2 ,4,6,8,10,12} ; 
       pair(num);  
     }
}
