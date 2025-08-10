package Assingmants;

import java.util.Scanner;

public class Function {
  // Q no.1 ;
  public static int average(int a, int b, int c) {
    return (a + b + c) / 3;
  }
  public static void printave() {
    Scanner sc = new Scanner(System.in);
    System.out.println(" Enter first number ");
     int a = sc.nextInt();
    System.out.println(" Enter Second number ");
   int  b = sc.nextInt();
    System.out.println(" Enter Third number ");
   int  c = sc.nextInt();
    System.out.println(average(a, b, c));
  }

  // Q 2 ;
  public static boolean isEven(int x) {
    if (x % 2 == 0) {
      return true;
    }
    return false;
  }   
   // Q 3 Answer
    public static void PrintisElse(  int x  ){ 
      if( x== 0 ){
        System.out.println( " Your number is Zero ");
      } else
       if( isEven(x)){ 
         System.out.println( " This number is Even ");
       } else{  
         System.out.println( " This is Odd Numver ");
       }
    } 
      public static void ispallmic ( int n ){  
         int current = n ; 
         int rev  = 0 ;  
          while (n> 0 ) {  
              int last = n%10 ; 
             rev =  last + rev*10  ; 
                n = n/10 ; 
          }  
  if( current==rev ){ 
     System.out.println( " Yes , This number is pailindrome");
  }
  else { 
     System.out.println(" This is not Pailindromic");
  }
      }   
       
       ///  Q 5 =  Sum the Digit of given number  ; 
          public static void sunnum (int num ){
             
             int sum = 0 ; 
              while (num>0 ) {
                int lastdigit = num%10 ; 
                 sum = sum+lastdigit  ; 
                  num = num/10 ;
              } 
               
              System.out.println( sum);
          }

  public static void main(String[] args) { 
  sunnum(98754
  );
  }
}
