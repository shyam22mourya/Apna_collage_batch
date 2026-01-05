package Revision;

import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class LinkedList1 {

    static  class Node  {
        int data ;
        Node next ;
        public  Node(int data  ){
            this.data = data ;
        }
    }
      static Node head ;
     static Node tail ;
    private int size ;

 public void addFirst(int data ){
      Node newNode = new Node(data);
      if(head == null ){
            tail = head =newNode ;
      }else{
          newNode.next = head;
          head = newNode;
      }
      size++;

 }
    public void addLast(int data ){
        Node newNode = new Node(data);
        if(head == null ){
             tail = head  = newNode;
        }else{
            tail.next= newNode;
            tail= newNode ;
        }
        size++;
    }

    public  void add(int index , int data){
     if(index==0){
         addFirst(data);
         return;
     }
     // find index-1 index ;
        Node newNode = new Node(data);
        Node temp = head;
        for(int i = 0 ; i<index-1 ; i++){
            temp = temp.next ;
        }
        newNode.next = temp.next ;
        temp.next = newNode ;
        size++;
    }

    public int  size(){
      return size;
    }
 public  void print ( ){
      Node temp = head;
      while (temp != null){
          System.out.print(temp.data+ "->");
          temp = temp.next ;
      }
     System.out.println();
 }


 public  int removeFirst(){
     if(size == 0 ){
         System.out.println("LL is empty");
         return Integer.MIN_VALUE;
     }else if(size== 1 ){
        int val = head.data ;
        head = tail = null ;
        size = 0 ;
        return val;
     }
      int data = head.data;
      head = head.next ;
      size-- ;
      return data;
 }

    public int removeLast() {
        if(size == 0){
            throw new NoSuchElementException("LinkedList is empty");
        }
        if(size == 1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        Node temp = head;
        for(int i = 0; i < size - 2; i++){
            temp = temp.next;
        }
        int val = tail.data;
        temp.next = null;
        tail = temp;
        size--;
        return val;
    }

    public  int search(int key) {
        Node temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    public int searchR(int key ){
        Node temp = head ;
        return  search( key , temp, 0 );
    }
    public  int search(int key , Node temp , int i ){
      if(temp == null)return -1;
      if(temp.data == key) return i ;
      temp = temp.next ;
      return search(key, temp, i+1);
    }

    public void   reverse(){
        Node next ;
      Node curr = head = tail  ;
      Node prev= null ;
      while(curr!= null){
          next = curr.next;
           curr.next = prev;
           prev = curr;
           curr = next;
      }
      head = prev ;
    }

    public void removeNthElement(int n) {

        if(n <= 0 || n > size){
            throw new IllegalArgumentException("Invalid n");
        }

        // remove first node
        if(n == size){
            head = head.next;
            size--;
            if(size == 0){
                tail = null;
            }
            return;
        }

        Node temp = head;

        // move to (size - n - 1)th node
        for(int i = 0; i < size - n - 1; i++){
            temp = temp.next;
        }

        // update tail if last node removed
        if(temp.next == tail){
            tail = temp;
        }

        temp.next = temp.next.next;
        size--;
    }

    public Node  findMid (Node head ){
         Node slow = head ;
         Node fast = head;
         while (fast != null  && fast.next != null ){
             slow = slow.next;
             fast =fast.next.next;
         }
         return  slow ;
    }

    public  Node reverse(Node head ){

      Node prev = null ;
      Node curr = head;
      Node next ;
      while (curr != null){
           next = curr.next ;
           curr.next = prev ;
           prev  = curr ;
           curr = next ;
      }
      return prev ;
    }

    public  boolean pali() {
     if(head== null || head.next == null){
          return true;
     }
        Node temp = head;
        // find mid
        Node mid = findMid(temp);
        Node secondHalf = reverse(mid);
        temp = head;
        while (secondHalf != null){
            if(secondHalf.data!= temp.data){
                return false;
            }
              secondHalf = secondHalf.next ;
              temp = temp.next ;
         }
        return true;
    }

// remove cycle in ll
   public  void removeCycle(){
       Node slow = head ;
       Node fast = head ;
       boolean isCycle = false ;
       Node prev = null ;
       while ( fast != null && fast.next != null ){
           slow = slow.next ;
           fast = fast.next.next;
            if(slow == fast){
                isCycle = true;
                 break ;
            }
       }
       if(!isCycle){
           return ;
       }
       slow = head ;
       while(slow != fast){
           prev = fast;
           slow = slow.next ;
            fast = fast.next ;
       }
       prev.next = null;
   }
   public  boolean isCycle(){
       Node slow = head ;
       Node fast = head ;
       while ( fast != null && fast.next != null ){
           slow = slow.next ;
           fast = fast.next.next;
           if(slow == fast){
            return  true ;
           }
       }
       return false ;
   }
    public  static void main() {
       LinkedList1 ll = new LinkedList1();
//       ll.addFirst(1);
//       ll.addFirst(2);
//       ll.addFirst(3);
//       ll.add(3 , 4 );
//       ll.addFirst(4);
//       ll.addLast(5);
//       ll.addLast(6);
//       ll.addLast(7);
//       ll.add(2,2);
//       ll.print();
//       System.out.println();
//       System.out.println(ll.removeFirst());
//       ll.print();
//       System.out.println();
//       System.out.println(ll.size());
//       System.out.println(ll.removeLast());
//       ll.print();
//        System.out.println(ll.search(6));
//        ll.reverse();
//        System.out.println();
//        ll.print();
//        ll.removeNthElement(3);
//        System.out.println();
//        ll.print();
//        System.out.println( ll.findMid().data);
//        ll.addLast(1);
//        ll.addLast(2);
//        ll.addLast(3);
//        ll.addLast(4);
//        ll.addLast(3);
//        ll.addLast(2);
//        ll.addLast(1);
         head = new Node(3);
         Node newNode = new Node (4);
        head.next = newNode;
        head.next.next = new Node(5);
        head.next.next.next = new Node(6);
        head.next.next.next.next = new Node(7);
        head.next.next.next.next.next = newNode ;


        CircularList cl = new CircularList();
        cl.add(1);
        cl.add(2);
        cl.add(3);
        cl.add(4);
        cl.add(5);
        cl.print();
        System.out.println("complete");
        cl.remove();
        cl.remove();
        cl.print();
    }
}

class CircularList{
     static   class Node{
          int data ;
          Node next ;

         public  Node(int data) {
             this.data = data ;
         }
     }

     Node head ;
     Node tail;
     int size ;
    public void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            newNode.next = newNode; // circular link
        } else {
            newNode.next = head;
            tail.next = newNode;
            head = newNode;
        }
        size++;
    }
    public  void remove(){
         if(head == null){
              return;
         }else if(size == 1 ){
             head = tail = null ;
             size = 0 ;
         }else{
              head = head.next ;
              tail.next = head ;
              size--;
         }
    }
    public  void print(){
          Node temp = head ;
          for(int i = 0 ; i<size ; i++){
              System.out.println(temp.data);
              temp = temp.next ;
          }
     }

}
