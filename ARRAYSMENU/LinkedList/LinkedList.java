package ARRAYSMENU.LinkedList;

public class LinkedList {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node Tail;
    public static int size;

    public void addfirst(int data) {
        // step 1 = create new node
        Node newnode = new Node(data);
        size++;
        if (head == null) {
            head = Tail = newnode;
            return;
        }
        // step 2 = new nodes next = head ;
        newnode.next = head; // link
        // step 3 = head = newnodes
        head = newnode;
    }


    public void addlast(int data) {
        // step1 create new node
        Node newnode = new Node(data);
        size++;

        if (head == null) {
            head = Tail = newnode;
        }
        // step2 newnode next = tail
        Tail.next = newnode;
        // step3 tail = newnode
        Tail = newnode;
    }

    public void add(int ind, int data) {
        Node newnode = new Node(data);
        if (ind == 0) {
            addfirst(data);
            return;
        }
        size++;

        Node temp = head;
        int i = 0;
        while (i < ind - 1) {
            temp = temp.next;
            i++;
        }
        // i == ind -1 ; temp -> prev ;
        newnode.next = temp.next;
        temp.next = newnode;
    }

    public void print() {
        Node temp = head;
        if (temp == null) {
            System.out.println(" SOLUTION  is not exixt ");
        }
        while (temp != null) {
            System.out.print(temp.data + "-> ");
            temp = temp.next;

        }
        System.out.println("null");
    }

    public int remofist() {
        if (size == 0) {
            System.out.println("LL is Empty ");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = Tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removelast() {
        if (size == 0) {
            System.out.println("ll is empty ");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = Tail = null;
            size = 0;
            return val;
        }
        // prev : 1 = size-2 ;
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data; // tail.data ;
        prev.next = null;
        Tail = prev;
        size--;
        return val;
    }

    public int searchIter(int key) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }

        // key not found ;
        return -1;
    }

    public int helper(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int inx = helper(head.next, key);
        if (inx == -1) {
            return -1;
        }
        return inx + 1;

    }

    public int searchRec(int key) {
        return helper(head, key);
    }

    public void reverse() {
        Node prev = null;
        Node curr = Tail = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    //  remove nth element from end ; 
    public   void  removenth( int n ){
            int size = 0 ; 
             Node temp = head;  
               while ( temp!=null) {
                temp = temp.next ; 
                size++;
               }
              if ( n ==size){  // remove fisrt ; 
                head = head.next; 
                 return ; 
              }
             int i = 1; 
              int iTofind = size-n  ; 
              Node  prev =  head ; 
              while (i<iTofind) {
                  prev=prev.next ; 
                  i++ ; 
              }
              prev.next= prev.next.next ; 
              return ; 
    }
    //helper
   // check is pallandrom   ; 
     public   Node findmid(   Node head  ){
          Node slow = head ; 
           Node fast = head ; 
             while (fast!=null && fast.next != null) {
                 slow =slow.next ; 
                 fast = fast.next.next ; 
             }  
             return slow ; 
     }
       public  boolean ispall ( ){
        if ( head==null || head.next == null){
             return true ; 
        }
              
        // step 1  find mid 
        Node midMode = findmid(head); 

        // step 2  reverse 2nd half ; 
            Node prev = null ; 
            Node  curr  =  midMode  ; 
            Node next ; 
 while (curr != null) {
         next = curr.next; 
          curr.next= prev ; 
           prev = curr; 
            curr  = next  ; 

 }
        // step 3 compar    left && right ; 

  Node right  = prev  ;
    Node left = head ; 
    while ( right !=  null) {
         if ( left.data != right.data){
            return false ; 
         } 
          left = left.next; 
           right = right.next;
    }
       
     return  true ; 
       }
      
// floyd's cycle finding algorithum 
       public static boolean iscycle ( ){
          Node  slow = head ;
          Node fast = head ; 
          while ( fast!= null && fast.next !=null) {
              slow = slow.next; //+1
               fast = fast.next.next ; //+2
               if ( slow == fast) {
                     return true ; //cycle exixts ; 
               }
          }
          return false ; // cycle does't exixt ; 
       }
       public static  void removecycle(){
          
        // detect loop 
               Node slow = head ; 
               Node  fast = head;  
               boolean cycle =  false ; 

                while (fast!=null&&fast.next != null) {
                    slow = slow.next ; 
                    fast = fast.next.next ; 
                    if (fast == slow) {
                        cycle = true ; 
                        break ;  
                    }
                }
                if (cycle==false) {
                    return ; 
                }

        // find moving point ; 
        slow = head ;
        Node prev=null ; // last node
         while (slow!= fast) { 
            prev = fast ; 
             slow = slow.next ; 
              fast = fast.next  ;      
         } 
// remove cycle  -> last.next =  null ; 
      prev.next = null ; 

    
       }

       // merge sort in linkeylist  ; 
   // to getmid 
    private Node getmid( Node head){
         Node slow = head ; 
          Node fast = head.next ; 

          while (fast!=null&&fast.next!= null) {
             slow = slow.next ;  
            fast = fast.next.next ; 
          }
          return slow ; 
    }// merge funtion 
     private Node mergesort( Node head1 , Node head2){
         Node mergeall  = new Node(-1) ; 
          Node temp = mergeall ; 
          while (head1 != null  && head2!=null) {
            if (head1.data <=head2.data) {
                temp.next = head1 ; 
                head1 = head1.next ; 
                temp = temp.next ;  
            } else{
                 temp.next = head2 ; 
                 head2 = head2.next ; 
                 temp = temp.next ; 
            }
          }
          while ( head1!=null) {
            temp.next = head1 ; 
            head1 = head1.next ; 
            temp = temp.next ; 
          }
          while (head2!=null) {
            temp.next = head2 ; 
            head2 = head2.next ; 
            temp = temp.next ; 

          }
           return  mergeall.next ; 
     }


        public Node mergesort( Node head){
            if (head ==null || head.next== null) {
                return head;
            }
             // tofind mid  
              Node  mid = getmid(head); 
             // left&right  
              Node rightHead = mid.next ; 
               mid.next = null ; 
               Node leftNode =  mergesort(head) ; 
               Node  rightNode =  mergesort(rightHead) ; 
              // merge ; 
              return mergesort(leftNode , rightNode) ; 
        }
        
        // tozigzag linklist 
        public void zigzag ( ){
  // find mid  
   Node slow  = head ; 
   Node fast = head ; 
    while ( fast!= null && fast.next != null) {
        slow = slow.next  ; 
        fast = fast.next.next ; 
    }
    Node mid = slow ; 
  // step 2   reverse 2ns half ; 
   
   Node curr = mid.next ;  
    mid.next = null ; 
    Node prev =  null ; 
     Node next  ; 
     while ( curr!= null) {
         next = curr.next ; 
         curr.next = prev ; 
          prev = curr  ; 
           curr = next  ;    
     }
     Node  left = head ; 
     Node   right = prev ; 
      Node  nextL , nextR ; 

       // altermate merge  - zigzag merge ; 
        while ( left != null && right != null) {
            nextL= left.next ; 
            left.next = right; 
              nextR  = right.next ; 
             right.next =  nextL;  

             //  update 
              left = nextL ; 
              right = nextR ; 
        }
        }

    public static void main(String[] args) {
    //   head = new Node(1 ) ; 
    //   head.next= new Node(2 ) ; 
    //   Node  temp =  new Node(6);
    //   head.next = temp ;
    //   head.next.next = new Node(3 ) ; 
    //   head.next.next.next= new Node(4) ; 
    //   head.next.next.next.next= temp  ; 
    LinkedList ll = new LinkedList() ; 
    ll.addfirst(1); 
    ll.addfirst(2);
    ll.addfirst(3);
    ll.addfirst(4);
    ll.addfirst(5);
    ll.addfirst( 6);
ll.print();
// ll.reverse();
//   ll.zigzag(); 
  ll.print(); 
        
  }
}
