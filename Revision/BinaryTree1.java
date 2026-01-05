package Revision;

import Assingmants.Arayas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree1 {
     static  class  Node {
         int data;
         Node left;
         Node right;

         Node(int data) {
             this.data = data;
         }
     }

      static  class Diam{
          int diam ;
          int height ;

          Diam(int diam , int height){
              this.diam = diam ;
              this.height = height ;
          }

      }
     static  class  BinaryTree {
         int idx = -1;

         //           build tree O(n)
         Node build(int[] arr) {
             idx++;
             if (arr[idx] == -1) {
                 return null;
             }
             Node node = new Node(arr[idx]);
             node.left = build(arr);
             node.right = build(arr);
             return node;
         }

         // preorder O(n)
         void preOrder(Node root) {
             if (root == null) return;
             System.out.print(root.data + " ");
             preOrder(root.left);
             preOrder(root.right);
         }

         // inorder O(n)
         void inOrder(Node root) {
             if (root == null) return;
             inOrder(root.left);
             System.out.print(root.data + " ");
             inOrder(root.right);
         }

         // postOrder O(n)
         void postOrder(Node root) {
             if (root == null) return;
             postOrder(root.left);
             postOrder(root.right);
             System.out.print(root.data + " ");
         }


         void levelOrder(Node root) {
             Queue<Node> q = new LinkedList<>();
             q.add(root);
             while (!q.isEmpty()) {
                 Node curr = q.poll();
                 System.out.print(curr.data + " ");
                 if (curr.left != null) {
                     q.offer(curr.left);
                 }
                 if (curr.right != null) {
                     q.offer(curr.right);
                 }
             }
         }

         int height(Node root) {
             if (root == null) return 0;
             int left = height(root.left);
             int right = height(root.right);
             return Math.max(left, right) + 1;
         }

         int sum(Node root) {
             if (root == null) return 0;
             int left = sum(root.left);
             int right = sum(root.right);
             return left + right + root.data;
         }

         int count(Node root) {
             if (root == null) return 0;
             int left = count(root.left);
             int right = count(root.right);
             return left + right + 1;
         }

         // O(n^2)
         int diameter(Node root) {
             if (root == null) return 0;

             int lh = height(root.left);
             int rh = height(root.right);
             int diam = lh + rh + 1;
             int ldiam = diameter(root.left);
             int rdiam = diameter(root.right);
             return Math.max(diam, Math.max(ldiam, rdiam));
         }

         Diam diameter1(Node root) {
             if (root == null) {
                 return new Diam(0, 0);
             }
             Diam ld = diameter1(root.left);
             Diam rd = diameter1(root.right);
             int curr = ld.height + rd.height + 1;
             int dia = Math.max(curr, Math.max(rd.diam, ld.diam));

             int currHeight = Math.max(ld.height, rd.height);
             return new Diam(dia, currHeight + 1);
         }

         boolean isSubtree(Node tree, Node subTree) {
             if (tree == null) {
                 return false;
             }

             if (tree.data == subTree.data) {
                 if (isIdenticail(tree, subTree)) {
                     return true;
                 }
             }
             return isSubtree(tree.left, subTree) || isSubtree(tree.right, subTree);
         }

         private boolean isIdenticail(Node tree, Node subTree) {
             if (tree == null && subTree == null) return true;
             if (tree == null || subTree == null || tree.data != subTree.data) return false;
             return isIdenticail(tree.left, subTree.left) && isIdenticail(tree.right, subTree.right);
         }

         static class Info {
             int hd;
             Node node;

             Info(int hd, Node node) {
                 this.hd = hd;
                 this.node = node;
             }
         }

         void topView(Node tree) {
             Queue<Info> q = new LinkedList<>();
             HashMap<Integer, Node> map = new HashMap<>();
             q.offer(new Info(0, tree));
             map.put(0, tree);

             int min = 0, max = 0;
             while (!q.isEmpty()) {
                 Info root = q.poll();

                 if (!map.containsKey(root.hd)) {
                     map.put(root.hd, root.node);
                 }
                 if (root.node.left != null) {
                     q.offer(new Info(root.hd - 1, root.node.left));
                     min = Math.min(root.hd - 1, min);
                 }
                 if (root.node.right != null) {
                     q.offer(new Info(root.hd + 1, root.node.right));
                     max = Math.max(root.hd + 1, max);
                 }
             }
             for (int i = min; i <= max; i++) {
                 System.out.print(map.get(i).data + " ");
             }
         }

         void kthLevel(int k, Node node, int level) {
             if (node == null) return;

             if (k == level) {
                 System.out.print(node.data);
                 return;
             }
             kthLevel(k, node.left, level + 1);
             kthLevel(k, node.right, level + 1);
         }

         private boolean getPath(Node root, int n1, ArrayList<Integer> list) {
             if (root == null) return false;
             list.add(root.data);

             if (root.data == n1) return true;
             boolean left = getPath(root.left, n1, list);
             boolean right = getPath(root.right, n1, list);

             if (left || right) {
                 return true;
             }
             list.remove(list.size() - 1);
             return false;

         }

         int lca(int n1, int n2, Node root) {
             if (root == null) return -1;

             ArrayList<Integer> getPath1 = new ArrayList<>();
             getPath(root, n1, getPath1);
             ArrayList<Integer> getPath2 = new ArrayList<>();
             getPath(root, n2, getPath2);
             int i = 0;
             while (i < getPath1.size() && i < getPath2.size()) {
                 if (getPath1.get(i) != getPath2.get(i)) {
                     break;
                 }
                 i++;
             }
             return i > 0 ? getPath2.get(i - 1) : -1;
         }


         Node lca1(Node root, int n1, int n2) {
             if (root == null || root.data == n1 || root.data == n2) return root;

             Node leftNode = lca1(root.left, n1, n2);
             Node rightNode = lca1(root.right, n1, n2);
             if (leftNode == null) return rightNode;
             if (rightNode == null) return leftNode;
             return root;
         }
private  int lcaDis(Node root , int n ){
              if(root == null) {
                   return -1 ;
              }
              if(root.data == n){
                  return 0 ;
              }
         int leftDis = lcaDis(root.left , n );
        int rightDis = lcaDis(root.right , n );

        if(leftDis == -1 && rightDis == -1 ){
             return -1 ;
        }else if(leftDis == -1 ){
             return rightDis+1 ;
        }else if(rightDis == -1 )
            return leftDis +1 ;

        return -1 ;
}
         int minDis(Node root , int n1, int n2  ){
             if(root == null) return 0 ;
              Node lca = lca1(root , n1 , n2);

              int dis1 = lcaDis(lca , n1 );
              int dis2 = lcaDis(lca , n2)  ;

              return dis2+dis1 ;
         }
         int  treeSun(Node root ){
              if(root == null) return 0 ;

              int leftChild = treeSun(root.left);
              int rightChild = treeSun(root.right);

             int leftNode = root.left != null ? root.left.data : 0 ;
             int rightNode = root.right != null ? root.right.data : 0 ;

             int data = root.data ;
              root.data = leftChild+rightChild+leftNode+rightNode;
              return data ;
         }
     }


         static void main() {
         int arr[] = { 1 ,2 ,4,-1, -1 , 5,-1 , -1 , 3, -1 , 6 ,-1 , -1 };
         Node tree = new Node(1);
          tree.left = new Node(2);
          tree.left.left=new Node(4);
          tree.left.right = new Node(5);
          tree.right = new Node(3);
             tree.right.left = new Node(6);
             tree.right.right = new Node(7);
       BinaryTree newBinary =new BinaryTree();
                newBinary.treeSun(tree);
       newBinary.levelOrder(tree);
        Node root = newBinary.build(arr);
             Node subRoot = new Node(2);
              subRoot.left = new Node(4);
             subRoot.right = new Node(5);
//             System.out.println(newBinary.isSubtree(root , subRoot));
//             newBinary.topView(root);
//             newBinary.kthLevel(3 , root ,  1);
//             System.out.println(newBinary.lca1(root , 4 ,7 ).data);
//             System.out.println(newBinary.minDis(root , 4, 6 ));
//             System.out.println("preOrder ");
//             newBinary.preOrder(root);
//             System.out.println("inOrder ");
//             newBinary.inOrder(root);
//             System.out.println("postOrder ");
//             newBinary.postOrder(root);
//
//             System.out.println("levelOrder");
//             newBinary.levelOrder(root);
//             System.out.printf("sum : %d " , newBinary.sum(root) );
//             System.out.printf("heigh : %d " , newBinary.height(root) );
//             System.out.printf("count : %d " , newBinary.count(root) );
//             System.out.printf("diameter : %d " , newBinary.diameter(root) );
//
//             Diam diam = newBinary.diameter1(root);
//             System.out.println(diam.diam);

         }
    }

