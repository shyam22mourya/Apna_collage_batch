package Assingmants;
public class Recurtion {  
// Q1 print all occurence   
//  time com =  O(n) ; 
//  space = O(n);
 static int arr  [] = { 3,2,4,5,6,2,7,2,2};
     public static  void printall ( int arr [] , int ind , int target ){
        if ( ind == arr.length ){
             return   ; 
        }
          if ( target == arr[ind]){
              System.out.print(  ind+" ") ; 
          }
          printall(  arr , ind+1 , target );
     }
// Q2  print change num to string 
// time com =  O(n) ; 
//  space = O(n);
     static String num []  = { "ZERO","ONE","TWO","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE"}  ;  
   public static void  printnum (  int n ){
    if (n == 0 ){
        return ; 
    }
       int  lastdigit  = n%10 ;
       printnum(n/10) ; 
       System.out.print(num[lastdigit]+" ") ; 
   }
 
 //  Q3 find length of Strring 
 //  time com =  O(n) ; 
//  space = O(n);
    public static  int fine( String str){
         if ( str.length()==0){
             return  0; 
         }
           
            return fine(str.substring(1 ))+1 ;
        
    }
  
    //  Q4  
    public static  int coutsub (String str , int i , int j , int n ){ 
         if ( n==1){
             return 1; 
         } 
         if ( n<=0 ){
            return 0 ; 
         }

          int res = coutsub(str, i+1, j, n-1) +coutsub(str, i, j-1, n-1)-coutsub(str, i+1, j-1, n-2) ; 
          if ( str.charAt(i)==str.charAt(j)){
            res++ ; 
          }
          return res  ; 
    }

    //  Q 5 print tower honai ; 
    // time complexity 0(2^n) ;
     // space com = O(n);
    public static void  tower (  int n  ,  int tower ,  int desk , int helper ){
         if (n==0) {
            return ; 
         }
        tower(  n-1 ,  tower ,helper , desk ) ; 
        System.out.println( "moving "+ n  +"nth disk for "+tower+" to "+desk);  
         tower(n-1, helper, desk, tower);
    }
      
    public static void main ( String []args){
         String str = "abcab" ; 
        int A =   1;
        int B =   2;
        int C =   3;
        // System.out.println(coutsub(str, 0, str.length()-1, str.length()));
        tower(3, A, B, C);
    }
}
