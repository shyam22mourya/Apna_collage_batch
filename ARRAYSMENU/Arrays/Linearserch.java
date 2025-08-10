package ARRAYSMENU.Arrays;

public class Linearserch {  
     public static int   linearsearch(int number[] , int key ){
          for ( int i = 0 ; i< number.length ; i++ ){
             if (number[i]==key ){
                 return i  ; 
             } 
          }
          return -1 ; 
     }
    public static void main(String[] args) {
        int number [] = { 2, 4,6,8,10,12,14,16};
        int key = 20  ;  
          int index =  linearsearch(number, key); 
           if (index ==-1){
             System.out.println(" Not found ");  
           }else {
             System.out.println( " Key is Found  At "+ index  + " index ");
           }
    }
}
