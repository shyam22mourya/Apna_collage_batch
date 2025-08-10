package Queue;
 import java.util.* ;
public class Queue1 {   
    // Q1 Queue using 2 stacks 
    //time compalexiy  add= O(n) ;  remove O(1)  ; 
     // Peek O(1) ; 
    static class Queck{
        static Stack<Integer>s1 = new Stack<>() ;  
        static  Stack<Integer>s2 = new Stack<>() ;  
               // isEmpty 
                public  boolean  isEmpty(){
                    return s1.isEmpty() ;  
                } 
                public boolean isEmpty1(){
                    return s1.isEmpty() || s2.isEmpty() ; 
                }   
                // add 
                  public   void  add(int data){
                  //  step1  untill s1 is not empty ; 
                      while (!s1.isEmpty()) {
                         s2.add(s1.pop()) ; 
                      }
                      // step2   add data 
                       s1.add(data) ; 
                       // step 3   
                        while ( !s2.isEmpty()) {
                             s1.add(s2.pop()) ; 
                        }  
                  }
                  // remove 
                    public   int  remove (){ 
                         if (s1.isEmpty()) {
                            System.out.println("our Queue is empty "); 
                            return -1; 
                         }
                      return    s1.pop() ; 
                    }
                    // peek 
                     public int peek(){
                        if (s1.isEmpty()) {
                            System.out.println("our Queue is empty "); 
                            return -1; 
                         }
                      return    s1.peek() ;   
                     }


                     // add 
                       public  void   add1( int data){
                           if ( !s1.isEmpty()) {
                              s1.push(data) ; 
                           } else {
                             s2.push(data) ; 
                           }
                       }
                       public int remove1() {
                        if (isEmpty1()) {
                            System.out.println("Queue is empty");
                            return -1;
                        }
                    
                        // Move all elements from s1 to s2
                        while (!s1.isEmpty()) {
                            s2.push(s1.pop());
                        }
                    
                        // Pop the top element from s2
                        int top = s2.pop();
                    
                        // Move all elements back to s1 from s2
                        while (!s2.isEmpty()) {
                            s1.push(s2.pop());
                        }
                    
                        return top;
                    }
                    
                    public int peek1() {
                        if (isEmpty1()) {
                            System.out.println("Queue is empty");
                            return -1;
                        }
                    
                        // Move all elements from s1 to s2
                        while (!s1.isEmpty()) {
                            s2.push(s1.pop());
                        }
                    
                        // Get the top element from s2
                        int top = s2.peek();
                    
                        // Move all elements back to s1 from s2
                        while (!s2.isEmpty()) {
                            s1.push(s2.pop());
                        }
                    
                        return top;
                    }
                    
    }
     
 // Q2  Stack using 2 queue ; 
   // time complexity push O(1) ;pop O(n) ; peek O(n) ;   
   static  class Staq {
   static  Queue<Integer>  q = new LinkedList<>() ; 
   static  Queue<Integer>  q1 = new LinkedList<>() ; 
   
      // is empty 
       public static   boolean isEmpty(){
         return q.isEmpty()  && q1.isEmpty() ; 
       }

       // push 
        public static  void push( int data){
              
             if (!q.isEmpty()) {
                q.add(data) ; 
             }else{
                 q1.add(data) ; 
             }
        }
       // remove 
        public static int  pop(){
            if (isEmpty()) {
                System.out.println(" our Stack is empty ");
                 return -1;            
            }
            int top  = -1; 
            // case 1 ; 
          if (!q.isEmpty()) {
            while (!q.isEmpty()) {
               top  = q.remove()   ; 
               if (q.isEmpty()) {
                 break ; 
               }  
               q1.add(top) ;  
            }
          }else{ //case 2 
            while (!q1.isEmpty()) {
                top  = q1.remove()   ; 
                if (q1.isEmpty()) {
                  break ; 
                } 
               q.add(top) ;  
             }    
          }
           return top ; 
        }
       public static int peek(){
        if (isEmpty()) {
            System.out.println(" our Stack is empty ");
             return -1;            
        }
        int top  = -1; 
        // case 1 ; 
      if (!q.isEmpty()) {
        while (!q.isEmpty()) {
           top  = q.remove()   ; 
          
           q1.add(top) ;  
        }
      }else{ //case 2 
        while (!q1.isEmpty()) {
            top  = q1.remove()   ; 
           q.add(top) ;  
         }    
      }
       return top ; 
       }
    
        //tc = O(n) ;  and other one O(1) ; 
       public   void push1 ( int data){
         while (!q.isEmpty()) {
            q1.add(q.remove()) ; 
         }
         q.add(data) ;
          while (!q1.isEmpty()) {
            q.add(q1.remove()) ; 
          } 
       }
        public   int pop1(){
               if (q.isEmpty()) {
                System.out.println(" staq  is empty ");
               }
              return q.remove() ;   
        }

        public   int peek1(){
            if (q.isEmpty()) {
             System.out.println(" staq  is empty ");
            }
           return q.peek() ;   
     }
  }
   
    //   time com = O(n) ; 
    //Q3  non reapting  first character ; 
  public static void nonreapeting( String str){
     int frequncy[] = new int[26] ; 
     Queue<Character> q = new  LinkedList<>() ; 
      for( int i =  0  ; i<str.length() ; i++){
          char ch = str.charAt(i) ; 
            q.add(ch) ; 
            frequncy[ch-'a']++ ; 
             //  check frequency of my front  
             while (!q.isEmpty() && frequncy[q.peek()-'a']>1) {
                q.remove() ; 
             } 
              if ( q.isEmpty()) {
                System.out.print(-1+" ");
              } else{
                 System.out.print(q.peek()+ " ");
              }
      }
  }
    public   static void  interperepes( Queue <Integer> q){
           int size = q.size()  ; 
           Queue <Integer> newq = new LinkedList<>() ; 
             for( int i = 0 ; i<size/2 ;i ++){
                 newq.add(q.remove()) ; 
             }
              while (!newq.isEmpty()) {
                  q.add(newq.remove());
                  q.add(q.remove()) ; 
              }
    }
  // Q6 reversal queue 
  // time com = O(n) ; space  com = O(n) ; 
   public static void  reversal ( Queue <Integer> q){
     Stack<Integer> sta = new Stack<>() ;  
      // step 1 push element in stack ; 
      while (!q.isEmpty()) {
        sta.push(q.remove()) ; 
      }
      // step 2 add element in out queue ; 
      while (!sta.isEmpty()) {
        q.add(sta.pop()) ; 
      }
   }


  public static void main(String[] args) {
       Queue <Integer> q = new LinkedList<>() ; 
       q.add(1);
       q.add(2);
       q.add(3);
       q.add(4);
       q.add(5);
       q.add(6);
       q.add(7);
       q.add(8);
       q.add(9);
       q.add(10);
           reversal(q);
            while (!q.isEmpty()) {
                System.out.print(q.peek()+" ") ; 
                 q.remove() ;     
            }
            System.out.println();

    }
}
