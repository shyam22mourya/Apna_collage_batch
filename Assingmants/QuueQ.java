package Assingmants;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import Queue.Dueue.stack;
// Q 1 Generat binary number ; 
public class QuueQ { 
        public static void getbinary( int n ){
             Queue<String> q = new LinkedList<>() ; 
              q.add("1") ;  
                while (n> 0 ) {
               String s1 = q.remove() ; 

                      System.out.println(s1); 
                       String s2  = s1 ; 
                       q.add(s2+"0") ; 
                       q.add(s2+"1") ; 
                       n-- ; 
                }
        }
        //Q 2 Connected with n nodes ; 
   public static long minCost(long arr[], int n) 
    {
         PriorityQueue<Long> pq = new PriorityQueue<>(); 
          for( int i = 0 ; i<n  ; i++){
              pq.add(arr[i] ) ; 
          } 
          
           long  rev = 0 ; 
            while( pq.size()>1){
                  long A = pq.poll() ;
                   long B = pq.poll() ; 
                     rev += A+B ; 
                     
                     pq.add(A+B) ; 
            }
         return    rev  ; 
    }
    
        //  Q4  reverse k th elemnt 
          public static Queue<Integer>  reversek (Queue<Integer> q , int k){
            Stack<Integer> s = new Stack<>() ; 
            Queue<Integer> ans = new LinkedList<>() ; 

             for( int i = 0 ; i< k  ; i++){
                 s.push(q.remove()) ; 
             }
             while (!s.isEmpty()) {
                ans.add(s.pop()) ; 
             }
              while (!q.isEmpty()) {
                ans.add(q.remove()) ; 
              }
              return ans ;
          }

    public static void main ( String[]arg){
        Queue<Integer> q = new LinkedList<>() ; 
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        reversek(q, 4) ; 
        while (!q.isEmpty()) {
            System.out.print(q.peek()+" ");
            q.remove() ; 
        }
          
    }
}
