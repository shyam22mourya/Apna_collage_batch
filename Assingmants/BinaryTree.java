package Assingmants;

import java.util.HashMap;

import Queue.Dueue.stack;

public class BinaryTree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    // Q1 Check root isUnvaluted
    public static boolean isUnvalutad(Node root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.data != root.left.data) {
            return false;
        }
        if (root.right != null && root.data != root.right.data) {
            return false;
        }
        if (!isUnvalutad(root.left) || !isUnvalutad(root.right)) {
            return false;
        }

        return true;
    }

    // Q2 Invert binary tree
    public static Node mirror(Node root) {
        if (root == null) {
            return null;
        }
        Node newNode = new Node(root.data);
        newNode.left = mirror(root.right);
        newNode.right = mirror(root.left);
        ;
        // Node temp = root.left;
        // root.left = root.right;
        // root.right = temp;

        return newNode;
    }

    // Q3 Delete leaf nodes with values as x

    public static Node deleteLeaves(Node root, int x) {
        if (root == null) {
            return null;
        }
        // Delete leaf Node in left subTree ;
        root.left = deleteLeaves(root.left, x);

        // Delete leaf Node in right subTree
        root.right = deleteLeaves(root.right, x);

        if (root.data == x && root.left == null && root.right == null) {
            return null;
        }
     return root ; 
    }

    // Q 4 Find Duplicate subTree 
   
    public static String dupSubTree(Node node, HashMap<String,Integer> map) {
        if (node == null) {
            return "";
        }

        // Generate subtree string
        String str = "(";
        str += dupSubTree(node.left, map);
        str += Integer.toString(node.data);
        str += dupSubTree(node.right, map);
        str += ")";

        // Count occurrences of each subtree
        map.put(str, map.getOrDefault(str, 0) + 1);

        // Print if a duplicate is found (i.e., appears more than once)
        if (map.get(str) == 2) {
            System.out.print(str + " ");
        }

        return str;
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // Q5 
    static class Res {
        
        int val ; 
        Res(int val){
             this.val = val ; 
        }
    }
    public static int findMaxUtil ( Node root ,Res res){
         if( root == null){
             return 0 ; 
         }

         // FInd max in Left SubTree 
         int l = findMaxUtil(root.left ,res); 
         // FInd max in right SubTree 
         int r = findMaxUtil(root.right,res) ; 

         // Find max sum height  starting form this node 
          int max_single = Math.max(Math.max(l, r)+root.data , root.data) ; 

          // FInd max sum Path Contain this node 
          int max_top = Math.max(max_single, l+r+root.data);

          // Store max Path 
           res.val = Math.max(res.val, max_top) ; 
           
           return max_single;
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(7);
        root.right = new Node(3);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(7);
        root.right.right = new Node(18);
       Res res = new Res(0);
        findMaxUtil(root ,res);
       System.out.println(res.val);
    //     Node root = new Node(1);
    //     root.left = new Node(4);
    //     root.right = new Node(3);
    //     root.left.left = new Node(3);
    //     root.right.left = new Node(4);
    //     root.right.right = new Node(3);
    //     root.right.left.left = new Node(3);

    //     HashMap<String, Integer> map = new HashMap<>();
    //     dupSubTree(root, map);
     }
}
