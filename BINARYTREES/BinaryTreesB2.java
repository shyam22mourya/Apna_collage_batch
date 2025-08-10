package BINARYTREES;

import java.util.*;

public class BinaryTreesB2 {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Kth level
    public static void Klevel(Node root, int level, int k) {
        // base case
        if (root == null) {
            return;
        }
        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }
        Klevel(root.left, level + 1, k);
        Klevel(root.right, level + 1, k);
    }

    public static void Klevel2(Node root, int k) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        int level = 0;
        q.add(root);
        q.add(null); // Level marker

        while (!q.isEmpty()) {
            Node curr = q.remove();

            if (curr == null) {
                // End of the current level
                if (!q.isEmpty()) {
                    q.add(null); // Add marker for the next level
                }
                level++; // Move to the next level
            } else {
                if (level == k) {
                    System.out.print(curr.data + " ");
                } else if (level < k) {
                    // Only add children if we haven't reached the desired level yet
                    if (curr.left != null) {
                        q.add(curr.left);
                    }
                    if (curr.right != null) {
                        q.add(curr.right);
                    }
                }
            }

            // Stop processing once we reach level k
            if (level > k) {
                break;
            }
        }
    }

    public static void klevel3 (Node root , int k ){
         if(root == null) return ; 

         Queue <Node> q = new LinkedList<>(); 
          q.offer(root);
          int leve1 = 0 ; 
          while (!q.isEmpty()){
             int n = q.size() ; 
           leve1++; 
           for(int i = 0 ; i<n ; i++){ 
            Node curr  = q.poll(); 
            if(leve1 == k){
                 System.out.print(curr.data + " ");
            }
            if(curr.left != null){
                 q.offer(curr.left);
            }
             if(curr.right != null){
                 q.offer(curr.right);
             }
           } 

          }
    }
    // Lowwest Commene Ancestor ;
    public static boolean getPath(Node root, int n, ArrayList<Node> path) {   
        if (root == null) {
            return false;
        }
        path.add(root);

        if (root.data == n) {
            return true;
        }
        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if (foundLeft || foundRight) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

    public static Node lca(Node root, int n1, int n2) {

        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }
        return path1.get(i - 1);

    }

    public static Node lca2(Node root, int n1, int n2) {
        // base case
        if (root == null) {
            return null;
        }
        if (root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        // leftLca == data , rightLca = null
        if (leftLca == null) {
            return rightLca;
        }

        if (rightLca == null) {
            return leftLca;
        }

        return root;
    }

    // Minmum Distance Between Nodes ;
    public static int lcaDis(Node lca, int n) {
        if (lca == null) {
            return -1;
        }

        if (lca.data == n) {
            return 0;
        }

        int leftDist = lcaDis(lca.left, n);
        int rightDist = lcaDis(lca.right, n);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        } else if (leftDist == -1) {
            return rightDist + 1;
        } else {
            return leftDist + 1;
        }

    }

    public static int minDist(Node root, int n1, int n2) {
        Node lca = lca2(root, n1, n2);
        int dis1 = lcaDis(lca, n1);
        int dis2 = lcaDis(lca, n2);

        return dis1 + dis2;
    }

    // Kth Ancestor of nodes
    public static int KAncestor(Node root, int n, int k) {
        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return 0;
        }

        int leftDis = KAncestor(root.left, n, k);
        int rightDis = KAncestor(root.right, n, k);

        if (leftDis == -1 && rightDis == -1) {
            return -1;
        }
        int max = Math.max(leftDis, rightDis);
        if (max + 1 == k) {
            System.out.println(root.data + " ");
        }
        return max + 1;
    }

    // Transform Tree to sum tree

    public static int transform(Node root) {
        if (root == null) {
            return 0;
        }
        int leftRoot = transform(root.left);
        int rightRoot = transform(root.right);

        int data = root.data;
        int newleft = root.left == null ? 0 : root.left.data;
        int newright = root.right == null ? 0 : root.right.data;
        root.data = newleft + leftRoot + newright + rightRoot;
        return data;
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // transform(root);
        // preOrder(root);
        // KAncestor(root, 7, 2) ;
    }

}


