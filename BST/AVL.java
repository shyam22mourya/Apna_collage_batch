package BST;

public class AVL {
    static class Node {
        int data, height;
        Node left, right;

        Node(int data) {
            this.data = data;
            height = 1;
        }
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    // height
    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        return root.height;
    }

    // calculate balance factor
    public static int getBalance(Node root) {
        if (root == null) {
            return 0;
        }
        return height(root.left) - height(root.right);
    }

    // Left Rotate subTree rooted with x ;
    public static Node leftRotate(Node x) {
        Node y = x.right;
        Node t2 = y.left;

        y.left = x;
        x.right = t2;

        // update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return y;
    }

    // Right Rotate subTree rooted with y ;
    public static Node rightRotate(Node y) {
        Node x = y.left;
        Node t2 = x.right;

        x.right = y;
        y.left = t2;

        // update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    public static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        // Step 1: Perform the normal BST insert
        if (key < root.data)
            root.left = insert(root.left, key);
        else if (key > root.data)
            root.right = insert(root.right, key);
        else
            return root; // Duplicate keys are not allowed

        // Step 2: Update height of this ancestor node
        root.height = 1 + max(height(root.left), height(root.right));

        // Step 3: Get the balance factor of this ancestor node to check if it became
        // unbalanced
        int bf = getBalance(root);

        // Left Left Case
        if (bf > 1 && key < root.left.data)
            return rightRotate(root);

        // Right Right Case
        if (bf < -1 && key > root.right.data)
            return leftRotate(root);

        // Left Right Case
        if (bf > 1 && key > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Left Case
        if (bf < -1 && key < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root; // Return the (unchanged) node pointer
    }

    public static Node root;

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " -> ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 35);
        root = insert(root, 40);
        root = insert(root, 50);

        System.out.print("PreOrder Traversal: ");
        preOrder(root);
        System.out.println("NULL");
    }
}
