package Revision;

public class BinarySearchTree {

  class  Node {
      int data;
      Node left, right;

      Node(int data) {
          this.data = data;
      }
  }

       private Node   insert(Node root , int val){
             if(root == null) return new Node(val);
             if(val > root.data){
                 root.right = insert(root.right , val);
             }else{
                  root.left = insert(root.left , val);
             }
             return root ;
       }

         Node build(int [] arr){
             Node node = null ;
             for(int i : arr){
                  node = insert(node , i );
             }
             return node ;
         }

          void inOrder(Node root){
             if(root == null) return ;
             inOrder(root.left);
              System.out.print(root.data+" ");
              inOrder(root.right);
          }

          boolean search(int val , Node root){ // O(log h )
         if(root== null) return  false ;
         if(root.data == val){
            return true ;
         }
         if(root.data > val){
           return    search(val,root.left);
         }else {
             return  search(val, root.right);
         }
     }
       Node deleteNode(Node root , int val ){
      if (root == null) return root ;
       // find exact node
           if(root.data > val){
              root.left= deleteNode(root.left , val);
           }else if(root.data < val ){
              root.right =  deleteNode(root.right ,val) ;
           } else {

               // leaf node
               if (root.left == null && root.right == null) {
                   return null;
               }
               if (root.left == null) {
                   return root.right;
               } else if (root.right == null) {
                   return root.left;
               }
                   Node Is = inOrderSuccessor(root.right);
                   int data = Is.data;
                   root.data = data;
                   root.right = deleteNode(root.right, data);
           }
           return root ;
       }

    private Node inOrderSuccessor(Node right) {
      while(right.left!= null){
           right = right.left ;
      }
      return right ;
    }

    void printInRange(Node root , int n1 , int n2 ){
       if(root== null ) return;

       if(root.data >= n1 && root.data <= n2) {
           printInRange(root.left, n1, n2);
               System.out.print(root.data + " ");
           printInRange(root.right, n1, n2);
       }else if(root.data < n1){
          printInRange(root.right , n1 ,n2);
       }else {
            printInRange(root.left , n1 , n2);
       }

    }
 boolean isvalidBst(Node root , Node min ,Node  max ){
       if(root == null ){
            return  true ;
       }
       if( min != null && root.data <= min.data ){
            return false ;
       }
       if( max != null && root.data >= max.data ){
         return false ;
     }
       return isvalidBst(root.left , min , root) && isvalidBst(root.right , root , max );
 }

   boolean isMiror(Node root , Node mirror){
       if(root == null && mirror == null){
            return true;
       }
       if(root.data != mirror.data || root== null || mirror == null ) return  false ;
        return  isMiror(root.left , mirror.right) && isMiror(root.right  , mirror.left);
   }

    static void main() {
        Avl avl = new Avl();
        int arr[] = { 1,2,3,4,5,6,7,8,9};
        Avl.Node root =avl.build(arr);
        avl.preOrder(root);
    }

}

class Avl {
     static class Node{
          int data , height;
          Node left , right ;
          Node(int data){
               this.data = data ;
               this.height = 1 ;
          }
     }

     int height(Node root){
       return root == null ? 0 : root.height ;
     }

     Node insert(Node root , int key ){
          if(root == null){
               return new Node(key);
          }
          if(root.data > key){
              root.left = insert(root.left , key);
          }else if(root.data < key){
               root.right = insert(root.right , key);
          }else{
               return root ;
          }
          root.height  = 1 + Math.max(height(root.left) , height(root.right));
          int bf = getBalanceFactor(root);
          // ll case
          if(bf > 1  && key < root.left.data){
               return rightRotation(root);
               // rr case
          }else if(bf < -1 &&  key > root.right.data){
               return leftRotation(root);
               // LR case
          }else if(bf > 1 && key > root.left.data ){
               root.left = leftRotation(root.left);
               return rightRotation(root);
          }
          else if(bf < -1 && key < root.right.data ){
              root.right = rightRotation(root.right);
              return leftRotation(root);
          }
          return root ;
     }
    private Node leftRotation(Node y) {
         Node x = y.right ;
         Node t1 = x.left ;

         x.left = y ;
         y.right = t1 ;

        y.height = Math.max(height(y.left),height(y.right))+1 ;
        x.height = Math.max(height(x.left),height(x.right))+1 ;
         return x ;
    }
    private Node rightRotation(Node y) {
        Node x = y.left ;
        Node t1 = x.right ;

        x.right = y ;
        y.left = t1 ;

        y.height = Math.max(height(y.left),height(y.right))+1 ;
        x.height = Math.max(height(x.left),height(x.right))+1 ;
        return x ;
    }
    private int getBalanceFactor(Node root) {
         if(root == null) return 0 ;
          int left = height(root.left);
          int right= height(root.right);
          return left - right ;
    }
    Node build(int arr[]){
          Node root = null ;
          for(int i : arr){
               root = insert(root , i);
          }
          return root;
     }
     void preOrder(Node root){
         if(root == null) {
             System.out.print("null");
             return ;  }
         System.out.print(root.data +" ");
         preOrder(root.left);
         preOrder(root.right);
     }

}