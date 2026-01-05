package Revision;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Queue1 {

  static void nonReapting(String str){
       int [] fre = new int [26];
      Queue<Character> q = new LinkedList<>( );
      for(char ch : str.toCharArray()){
           fre[ch-'a']++;
           q.add(ch);
           //while we don't get non repeating
          while( !q.isEmpty() &&fre[q.peek()-'a'] != 1){
              q.poll();
          }
          if(q.isEmpty())
              System.out.println(-1);
          else
              System.out.println(q.peek());
      }
  }
    static void main() {
        String str = "aabccxb";
        nonReapting(str);



    }
}

class QueueLink {
   static class Node {
       int data;
       Node next;

       Node(int data) {
           this.data = data;
       }
   }

       static Node front;
       static Node rear;
      boolean isEmpty(){
          return front == null ;
      }

       void add(int data) {
           Node newNode = new Node(data);
           if (front == null) {
               front = rear = newNode;
           } else {
               rear.next = newNode;
               rear = newNode;
           }
       }

       int remove(){
           if(front == null){
                throw  new NullPointerException();
           }
            int data = front.data ;
           front = front.next ;
           return data ;
       }

    int peek() {
        if (front == null) {
            throw new NullPointerException();
        }
        return  front.data ;
    }

   }

class QueueCur {

    private  int arr[];
    private int size;
    private int rear ;
    private int front ;

     QueueCur(int n) {
        arr = new int[n];
        size = n ;
        rear = -1 ;
        front = -1;
    }

    boolean isEmpty() {
        return rear == -1 && front == -1 ;
    }
    boolean isFull(){
          return (rear+1)%size == front ;
    }




    void add(int data) {
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        if(front == -1){
             front = 0 ;
        }
        rear = (rear+1)%size ;
        arr[rear] = data;
    }

    int remove() {
        if(isEmpty()){
            throw new NullPointerException();
        }

        int data = arr[front];
          if(front == rear){
            front = rear= -1;
          }else{
               front = (front+1)%size ;
          }
        return data;
    }
    int peek(){
        if(isEmpty()){
            throw  new NullPointerException();
        }
        return arr[front];
    }

}

class QueueAr {

          private  int arr[];
           private int size;
           private int rear ;

            QueueAr(int n) {
                arr = new int[n];
                size = n ;
                rear = -1 ;
            }

            boolean isEmpty() {
                return rear == -1;
            }




            void add(int data) {
              if(rear == size - 1 ){
                   throw  new IllegalStateException();
              }
                rear++ ;
                arr[rear] = data;
            }

            int remove() {
                if(isEmpty()){
                     throw new NullPointerException();
                }

                int data = arr[0];
                for(int i = 0 ; i<rear ; i++){
                     arr[i] = arr[i+1];
                }
                 rear -- ;
                return data;
            }
            int peek(){
                if(isEmpty()){
                    throw  new NullPointerException();
                }
                return arr[0];
            }

        }

