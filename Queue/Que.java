package Queue;
   public class Que {  
          static class Node{ 
             int data ; 
             Node next ; 
              Node (  int data){
                 this.data = data ; 
                this.next = null ; 
              } 
          }

     static  Node head; 
      static Node tail  ; 

          // Queue using linked list 
           static class linkedQue{
              
             public boolean Isempty(){
                return head== null & tail == null ; 
             } 

             // ADD
              public void add(  int data ){
                  Node newnode  = new Node(data) ; 
                  if( head== null){
 
                        head = tail= newnode ; 
                  } else{
                     tail.next =  newnode  ; 
                     tail = newnode ; 
                  }
              }
              public   int  remove ( ){
                 if (Isempty()) {
                     System.out.println( " ll is    empty "); 
                     return -1 ; 
                 } 
                  int front = head.data ;
                  if( head == tail){
                     head = tail =null ; 
                  }else{
                     head = head.next ; 
                  }
            return front ; 
              }
               public   int peek(){  
                 if (Isempty()) {
                    return -1  ; 
                 }
                 return  head.data ; 
               }
           }
  
           // Queue  using circulaerArray ; 
           static class circularArrayQueue {    
               static  int  size  ;
               static int rear ; 
               static  int arr[] ; 
               static int front ; 

            circularArrayQueue( int n){
                  arr = new int [n] ; 
                  size = n ; 
                   rear  = -1 ; 
                   front = -1 ; 
             }

              public    boolean  isEmpty(){
                 return rear == -1 && front == -1; 
              }
               
               public static  boolean full (){
                 return (rear+1)%size== front ; 
               }
                // add
                 public   void add( int data ){
                         if (full() ) {
                             System.out.println(" CARUCULER QUEUE is FULL ");
                         }
                          // if add first element 
                          if (front == -1 ) {
                             front = 0 ; 
                          }
                          rear = (rear+1)%size  ; 
                           arr[rear] = data  ; 
                 }
                 // remove
            public   int remove (){
                 if (isEmpty()) {
                    System.out.println(" Queue is empty ");
                    return -1; 
                 } 
                   int  result = arr[front] ; 
                //   when we remove last element 
                 if (front== rear ){
                     rear  =front=-1 ; 
                       } else{
                        front  = ( front+1)%size ; 
                       }
                  return result  ; 
            }
            //  peek 
          public  int peek (){
              if (isEmpty()) {
                System.out.println("CARUCULER QUEUE is empty" );
              return -1 ;
              }
              int ans = arr[front] ; 
              return ans ;
          }
           

  }
   

            // Queuse using array
          static class Arrays {  
        static  int  size  ;
        static int rear ; 
      static  int arr[] ;  
            Arrays ( int  n ){
               arr = new int[n] ;   
              size  =  n ; 
              rear =-1; 
            }
             public static boolean isEmpty (){
                  return rear == -1 ; 
             } 
              public static  void add( int data){
                if (rear == size-1) {
                    System.out.println( " Queue is full");
                  } 
                  rear++ ; 
                 arr[rear] = data; 
              }
               public static  int remove(){
                if (rear == size-1) {
                    System.out.println( " Queue is full");
                  }
                  int  front = arr[0] ; 
                   for ( int i =  0 ; i<rear ; i++){
                   arr[i] = arr[i+1] ; 
                   }
                   rear--  ; 
                   return front ; 
               }
               public static  int peek (){
                if (rear == size-1) {
                    System.out.println( " Queue is full");
                  }
                        int front = arr[ 0] ; 
                        return front  ;
             }
            
            }

    
public static void main ( String [] arg){
   linkedQue newque = new  linkedQue() ; 
 newque.add(8);
 newque.add(9);
 newque.add(10);
 newque.add(11);
  System.out.println(newque.remove());
  newque.add(12);
  System.out.println(newque.remove());
  newque.add(13);
   while (!newque.Isempty()) {
     System.out.println(newque.peek()); 
      newque.remove() ; 
   }
}
}
