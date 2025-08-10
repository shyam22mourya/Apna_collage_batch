package BST;

import java.util.*;

public class BST1 {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            Node data = new Node(val);
            return data;
        }

        if (val < root.data) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static boolean search(Node root, int key) { // O(H)
        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }
        if (root.data > key) {
            return search(root.left, key);
        }
        if (root.data < key) {
            return search(root.right, key);
        }
        return false;
    }

    public static Node delete(Node root, int val) {
        if (root == null) {
            return null; // Base case: if the tree is empty
        }
       if (root.data > val) {
            root.left = delete(root.left, val); // Correct direction
        } else if (root.data < val) {
            root.right = delete(root.right, val); // Correct direction
        } else { // Node to be deleted found
            // Case 1: No children (leaf node)
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: One child
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            // Case 3: Two children
            Node inorderSuccessor = findInorderSuccessor(root.right); // Fix: Look in the right subtree
            root.data = inorderSuccessor.data; // Replace data with inorder successor
            root.right = delete(root.right, inorderSuccessor.data); // Delete inorder successor
        }
        return root;
    }

    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left; // Smallest node in the right subtree
        }
        return root;
    }

    public static void printInRange(Node root, int k1, int k2) {
        if (root == null) {
            return; // Base case: if the tree is empty
        }

        // Traverse left subtree only if the current node might have values in range
        if (root.data > k1) {
            printInRange(root.left, k1, k2);
        }

        // Print the current node if it lies within the range
        if (root.data >= k1 && root.data <= k2) {
            System.out.print(root.data + " ");
        }

        // Traverse right subtree only if the current node might have values in range
        if (root.data < k2) {
            printInRange(root.right, k1, k2);
        }
    }

    public static void printPath(ArrayList<Integer> path) {
        for (int i : path) {
            System.out.print(i + "->");
        }
        System.out.println();
    }

    public static void rootToLeaf(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return; // Base case: empty tree
        }

        // Add current node to the path
        path.add(root.data);

        // If it's a leaf node, print the path
        if (root.left == null && root.right == null) {
            printPath(path);
        } else {
            // Recur for left and right subtrees
            rootToLeaf(root.left, path);
            rootToLeaf(root.right, path);
        }

        // Remove the current node from the path (backtracking)
        path.remove(path.size() - 1);
    }

    public static void inOrder(Node data) {
        if (data == null) {
            return;
        }
        inOrder(data.left);
        System.out.print(data.data + " ");
        inOrder(data.right);
    }

    public static void main(String[] args) {
        // int value[] = { 5, 1, 3, 4, 2, 7, 6, 9, 8, 10 };
        int value[] = { 8, 5, 3, 6, 10, 11, 14 };
        // int value[] = { 1, 1, 1, };
        Node root = null;
        for (int i : value) {
            root = insert(root, i);
        }
        inOrder(root);
        System.out.println();

        // Node root1 = delete(root, 8);
        // inOrder(root1);
        // printInRange(root, 5, 12);
        // rootToLeaf(root, new ArrayList<>());
        // System.out.println(isValid(root, null, null));
        inOrder(root);

    }
}
