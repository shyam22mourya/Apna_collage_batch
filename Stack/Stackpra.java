package Stack;
import java.util.ArrayList;

public class Stackpra { 
          public static  class Node{
               int data ; 
                Node next ; 

                    public  Node( int data){
                         this.data =data ; 
                         this.next = null; 
                      }
            }
  
             static  class Stacklink{
                  static Node head = null; 
                   public  boolean isEmpty(){
                     return head == null ; 
                   } 
                    // push
                    public   void push(  int data){ 
                       Node  newnode  = new Node(data) ; 
                        if (isEmpty()) {
                       head = newnode ; 
                       return  ;  
                       }  
                        newnode.next= head; 
                        head= newnode; 
                    } 

                    // pop
                    public  int pop(){
                       if (isEmpty()) {
                        return -1; 
                       } 
                         int top = head.data ; 
                         head= head.next ; 
                          return top ; 
                    }
                     // peek 
                       public  int peek(){
                         if (isEmpty()) {
                            return -1; 
                         }  
                          return  head.data; 
                       }
                    
                    
             }

            static  class Stack {
      static ArrayList < Integer> list = new ArrayList<>() ; 
      // is empty 
        public boolean   isEmpty(){
            
              return  list.size()== 0 ; 
        } 
        //add something
     // push 
      public  void push ( int data){
          list.add(data) ; 
      }
          //   remove and take element
          // pop 
       public   int pop ( ){
          int top = list.get(list.size()-1) ; 
           list.remove(list.size()-1) ; 
           return top ; 
       }
        //    take element ; 
         // peep 
      public  int  peep (){
      int top = list.get(list.size()-1) ; 
      return top ;  
        }
 }
     
     public static void main ( String []arg){
        Stacklink st = new Stacklink() ; 
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
           while (!st.isEmpty()) {
             System.out.println(st.peek()) ; 
             st.pop() ; 
           }
     }
    }
