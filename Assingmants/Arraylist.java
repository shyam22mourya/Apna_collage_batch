package Assingmants;
import java.util.*; 

public class Arraylist {
 
    //Q1  Monotonic arraylist
    //   time complaxity O(n); 
     public static boolean  monotonic ( ArrayList<Integer> list){ 
         
          for ( int i = 1 ; i< list.size()-1 ; i++){
             if ( list.get(i)==list.get(i+1)|| list.get(i)==list.get(i-1))
              {
                 return true  ;
              }
          } 
           return false ; 
     }
  
    //  Q2 lonely number in array 
    //   time complaxity O(nlog n ); 
   
    public static  ArrayList<Integer>  lonely( ArrayList<Integer> list){
        ArrayList<Integer> result = new ArrayList<>() ; 
          Collections.sort(list) ; 
           for ( int i  = 1  ; i< list.size() ; i++){
              if (   i!=0 &&list.get(i-1) ==(list.get(i)-1)  || list.get(i-1) == list.get(i)) {
                continue ; 
              }
              if (   i !=list.size()-1 &&list.get(i+1) ==(list.get(i)+1)  || list.get(i+1) == (list.get(i))  ){
                continue ; 
              }

              result.add(list.get(i)) ; 
           }
           return result ; 
     }
     // Q3  most freQuency NUmber following Easy  ; 
    //   time complaxity O(n); 
              
      public static int maxFrequvency ( ArrayList<Integer>fre  , int key){
         
          int [] count =  new int[1001] ; 
           for ( int i = 0  ; i< fre.size()-1; i++){
               if ( fre.get(i)==key){
                 count[fre.get(i+1)]++ ; 
               }
           } 
            
             int max = Integer.MIN_VALUE ; 
              int  ans = 0 ; 
               for ( int i = 0 ; i< count.length ; i++){
                  if ( count[i] > max) {
                   max = count[i];  
                   ans = i ;   
                  }
               }

                return ans ; 
          
      }


    //   Q4 beautiful array 
     public  static ArrayList<Integer> beatuful (  int n  ){
        ArrayList  <Integer> res = new ArrayList<>() ; 
             res.add(1) ;  
              int size = res.size() ; 
              while ( res.size()< n) {               
         ArrayList  <Integer> list = new ArrayList<>() ; 
         for ( int i = 0 ; i< size  ; i++){
             if ( (res.get(i)*2  -1)<=n )
             {
                 list.add(res.get(i)*2-1) ; 
             }
         }
         for ( int i = 0 ; i<size ; i++){
             if (res.get(i)*2<=n){
                list.add(res.get(i)*2) ; 
                 
             }
         }  
          res = list ;   
              }  
            return  res ; 
         
     }

     
     public static void main(String[] args) {
         ArrayList  <Integer> list = new ArrayList<>() ; 
         list.add(1);
         list.add(10);
         list.add(1);
         list.add(10);
         list.add(2);
         list.add(1); 
         list.add(11); 
         list.add(1); 

        //   System.out.println( monotonic(list));
        //  System.out.println(lonely(list));
        //  System.out.println(maxFrequvency(list, 10));
         System.out.println( beatuful(5));
    }
}
