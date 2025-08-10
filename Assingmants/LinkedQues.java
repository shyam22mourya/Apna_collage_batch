package Assingmants;
public class LinkedQues {  
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head ; 
    public static Node Tail ; 
    public static   int size  ; 

    public void addfirst(int date) {
        // step 1 = create new node
        Node newnode = new Node(date);
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

        // Q 1 getINSERTION  IN JAVA ; 
           public  Node  Insertion ( Node temp1 , Node  temp2){

             Node head1  = temp1 ; 
             Node head2 = temp2 ;
                while ( head1 != head2 ) {
                     if( head1== null){
                         head1 = temp2 ; 
                     } 
                      if( head2 == null){
                         head2 = temp1 ;
                      } 
                      head2 = head2.next ;
                      head1 = head1.next ;

                } 
                return head1; 
           }
  // implimentation 
           /*   Node  head2 = new Node(3) ; 
          Node newnode = new Node(6) ; 
          head2.next = newnode  ; 
           newnode = new Node(9) ; 
           head2.next.next = newnode ; 
        Node  head1 = new Node(10);   
           newnode = new Node(15) ; 
           head1.next = newnode ; 
           head2.next.next.next = newnode ; 
  
           newnode = new Node(9) ; 
            head1.next.next =  newnode ; 
             head1.next.next.next = null ; 
               Node indestion = ll.Insertion(head1, head2) ;  
               System.out.println(indestion.data); */
  //Q2 skipnelents
  public void skipElements(Node head, int m, int n) {
    Node temp = head;
    while (temp != null) {
        // Skipping m elements
        for (int i = 0; i < m - 1 && temp != null; i++) {
            temp = temp.next;
        }

        // Base case check
        if (temp == null || temp.next == null) {
            return;
        }

        Node current = temp.next;
        
        // Deleting n elements
        for (int j = 0; j < n && current != null; j++) {
            current = current.next;
        }
        // Update pointers
        temp.next = current;
        // Move temp to the next starting point for next iteration
        temp = current;
    }
}

/* implementation part 
 *      ll.addfirst(4);
         ll.addfirst(5);
         ll.addfirst(6);
         ll.addfirst(7);
         ll.addfirst(8);
         ll.addfirst(9);
         ll.addfirst(10);
         ll.addfirst(11);
         ll.print();
  ll.skipElements(head, 3,2);
       ll.print();
 */


 //Q3 swap element 
 public void swap(Node  head1, Node head2){
    int temp =   head1.data ; 
  head1.data = head2.data ;
  head2.data = temp  ;
}
public void swiping( Node  head , int k ){
  Node slow = head ; 
  Node fast = head ;  
   int i = 0; 
  while(i<k){
      fast = fast.next ; 
      i+=1 ; 
  }
   
  Node   fist =  fast  ; 
   while ( fast.next != null) {
       slow = slow.next ; 
       fast = fast.next ; 
   }

   swap ( fist , slow ) ; 

   return ; 
}

// Q 4 segrete  sum and even node 
  public Node  segerate( Node head){
Node  head1 = new Node(0) ; 
Node head2 = new Node(0) ;

 
   Node  dumieven  = head1  ; 
   Node  dumiodd =head2 ; 
 Node temp  = head ; 
 while( temp!= null){
      
       if( ( temp.data %2)==0){
             head1.next = temp ; 
             head1= temp ; 
       }
        else{
             head2.next = temp ; 
              head2 = temp ;
        }
        temp = temp.next ; 
 } 
   head1.next = dumiodd.next ;  
   head2.next  = null ;  
      return dumieven.next  ;
}
 public static void main(String[] args) {
         LinkedQues ll = new LinkedQues() ; 
         ll.addfirst(4);
         ll.addfirst(5);
         ll.addfirst(6);
         ll.addfirst(7);
         ll.addfirst(8);
         ll.addfirst(9);
         ll.addfirst(10);
         ll.addfirst(11);
         ll.print();
    Node newnode = ll.segerate(head)    ;
ll.print();
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
}
