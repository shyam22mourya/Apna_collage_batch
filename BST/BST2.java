package BST;

import java.util.ArrayList;

public class BST2 {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // Q1 2/1/2025 check for is Validv O(n)
    public static boolean isValid(Node root, Node min, Node max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.data <= min.data) {
            return false;
        }
        if (max != null && root.data >= max.data) {
            return false;
        }
        return isValid(root.left, min, root) && isValid(root.right, root, max);
    }

    // Q2 mirror image // O(n) ;
    public static Node mirror(Node root) {
        if (root == null) {
            return null;
        }
        Node lefts = mirror(root.left);
        Node rights = mirror(root.right);

        root.left = rights;
        root.right = lefts;
        return root;
    }

    // Q3 Sorted sequece to BST O(n) ; inorder to Bst 
    public static Node createBst(int arr[], int st, int ed) {
        // base case
        if (st > ed) {
            return null;
        }
        // find mid
        int mid = (st + ed) / 2;
        Node root = new Node(arr[mid]);
        root.left = createBst(arr, st, mid - 1);
        root.right = createBst(arr, mid + 1, ed);
        return root;
    }

    // Q4 Covert to balaced BST O(n) ;
    public static void getInorder(Node root, ArrayList<Integer> inorder) {
        if (root == null) {
            return;
        }
        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);

    }

    public static Node convertBalanace(ArrayList<Integer> inorder, int st, int end) {
        // base case
        if (st > end) {
            return null;
        }
        int mid = (st + end) / 2;
        Node root = new Node(inorder.get(mid));
        root.left = convertBalanace(inorder, st, mid - 1);
        root.right = convertBalanace(inorder, mid + 1, end);
        return root;
    }

    public static Node balaceBST(Node root) {

        // step1 inorder sequece O(n)
        ArrayList<Integer> inOrderSeq = new ArrayList<>();
        getInorder(root, inOrderSeq);
        // step2 to convert to balance O(n)
        return convertBalanace(inOrderSeq, 0, inOrderSeq.size() - 1);
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // Q 5 largest BST in a binary tree O(n) ;
    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    static int maxBST = 0;

    public static Info sizeOfLstBts(Node root) {
        if (root == null) {
            // For a null node, return an Info object representing a valid BST
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        // Get Info for left and right subtrees
        Info leftInfo = sizeOfLstBts(root.left);
        Info rightInfo = sizeOfLstBts(root.right);

        // Calculate size, min, and max for the current subtree
        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        // Check if the current subtree is a valid BST
        if (leftInfo.isBST && rightInfo.isBST && root.data > leftInfo.max && root.data < rightInfo.min) {
            // Update the maximum size of any BST found
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min, max);
        }

        // If not a BST, return false for isBST, but still pass size, min, and max
        return new Info(false, size, min, max);
    }

    public static void main(String[] args) {
        // Node root = new Node(8);
        // root.left = new Node(5);
        // root.right = new Node(10);
        // root.left.left = new Node(3);
        // root.left.right = new Node(6);
        // root.right.right = new Node(11);

        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);

        root.right = new Node(60);
        root.right.right = new Node(70);
        root.right.left = new Node(45);
        root.right.right.right = new Node(80);
        root.right.right.left = new Node(65);

        // int arr[] = { 3, 5, 6, 8, 10, 11, 12 };
        preOrder(root);
        System.out.println();
        // Node root2 = balaceBST(root);
        // preOrder(root2);

        sizeOfLstBts(root);
        System.out.println("Largest  BST of tree " + maxBST);
    }
}
