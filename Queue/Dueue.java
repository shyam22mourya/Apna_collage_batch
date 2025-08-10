package Queue;

import java.util.*;

public class Dueue { 
    // Q1 Stack using  Dueue ; 
     public static class stack  {
          
         static Deque <Integer> d = new LinkedList<>() ;  
           public  boolean isEmpty(){
             return d.isEmpty() ; 
           }
          //  
          public static void push( int data){
             d.addLast(data);
          }

          // 
          public static int pop(){
            return d.removeLast() ; 
          }

           public static int peek(){
             return d.getLast() ; 
           }
     }
   
   // Q2   Queue using Dueue ; 
   static   class Queue {
        static Deque <Integer> d = new LinkedList<>() ;  
        public  boolean isEmpty(){
          return d.isEmpty() ; 
        }

        public void add( int data){
             d.addLast(data);
        }
         public int remove (){
             return d.removeFirst() ; 
         }
           public int  peek(){
             return d.getFirst() ; 
           }  
    }
   
     public static void main(String[] args) {
        Queue s  = new Queue() ; 
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.remove() ; 
        }
     System.out.println(s);
}
}