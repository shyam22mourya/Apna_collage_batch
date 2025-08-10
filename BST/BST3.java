package BST;

import java.util.ArrayList;
import java.util.Stack;

public class BST3 {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    // 04/01/2025
    // Q1 sum In range O(n)
    public static int sumInRange(Node root, int k1, int k2) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.data > k1) {
            sum += sumInRange(root.left, k1, k2);
        }
        if (root.data >= k1 && root.data <= k2) {
            sum += root.data;
        }
        if (root.data < k2) {
            sum += sumInRange(root.right, k1, k2);
        }
        return sum;
    }

    // Q2 closet element
    static int diff = Integer.MAX_VALUE;
    static int closest = -1;

    public static void closeElement(Node root, int val) {
        if (root == null) {
            return;
        }

        int currDiff = Math.abs(root.data - val);
        if (currDiff < diff) {
            closest = root.data;
        }

        if (val > root.data) {
            closeElement(root.right, val);
        } else if (val < root.data) {
            closeElement(root.left, val);
        }

    }

    // Q3 Kth smallest element
    public static int kthSmallest(Node root, int k, int[] count) {   
        if (root == null) {
            return -1;
        }

        // Search in the left subtree
        int left = kthSmallest(root.left, k, count);
        if (left != -1) {
            return left; // Return the result from the left subtree if found
        }

        count[0]++;
        if (k == count[0]) {
            return root.data;
        }
        return kthSmallest(root.right, k, count);
    }

    // Q4 Two SUm BST's
    public static int countPair(Node root1, Node root2, int sum) {
        if (root1 == null || root2 == null) {
            return 0;
        }

        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        int count = 0;

        Node current1 = root1, current2 = root2;

        while (true) {
            // Traverse the left subtree of root1
            while (current1 != null) {
                st1.push(current1);
                current1 = current1.left;
            }

            // Traverse the right subtree of root2
            while (current2 != null) {
                st2.push(current2);
                current2 = current2.right;
            }

            // If either stack is empty, traversal is complete
            if (st1.isEmpty() || st2.isEmpty()) {
                break;
            }

            Node top1 = st1.peek();
            Node top2 = st2.peek();

            // Check the sum of the top elements of both stacks
            if (top1.data + top2.data == sum) {
                count++;
                // Move to the next elements in both trees
                st1.pop();
                st2.pop();
                current1 = top1.right;
                current2 = top2.left;
            } else if (top1.data + top2.data < sum) {
                // If the sum is less, move to the right in tree1
                st1.pop();
                current1 = top1.right;
            } else {
                // If the sum is greater, move to the left in tree2
                st2.pop();
                current2 = top2.left;
            }
        }

        return count;
    }

    // Q5 MaxSum in Binary tree
    static class Info {
        int sum, min, max;
        boolean isBst;

        Info(int sum, int min, int max, boolean isBst) {
            this.sum = sum;
            this.min = min;
            this.max = max;
            this.isBst = isBst;
        }
    }

    static int maxSum;

    public static Info maxSumInBst(Node root) {
        if (root == null) {
            // Base case: Empty tree is a BST with sum = 0
            return new Info(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }

        // Recursively calculate info for left and right subtrees
        Info leftSub = maxSumInBst(root.left);
        Info rightSub = maxSumInBst(root.right);

        // Check if the current tree is a BST
        if (root.data > leftSub.max && root.data < rightSub.min && leftSub.isBst && rightSub.isBst) {
            int sum = leftSub.sum + rightSub.sum + root.data;
            int minVal = Math.min(root.data, leftSub.min);
            int maxVal = Math.max(root.data, rightSub.max);

            // Update the global maximum sum
            maxSum = Math.max(maxSum, sum);

            // Return updated info for this subtree
            return new Info(sum, minVal, maxVal, true);
        }

        // If not a BST, propagate the maximum sum so far and mark as not a BST
        return new Info(Math.max(leftSub.sum, rightSub.sum), Integer.MIN_VALUE, Integer.MAX_VALUE, false);
    }

    public static int findMaxSumInBst(Node root) {
        maxSum = 0; // Initialize maxSum
        maxSumInBst(root);
        return maxSum;
    }

    // Q1 3/1/2025 ;
    public static void getInorder(Node root, ArrayList<Integer> arr1) {
        if (root == null) {
            return;
        }

        getInorder(root.left, arr1);
        arr1.add(root.data);
        getInorder(root.right, arr1);
    }

    public static Node createBST(ArrayList<Integer> arr1, int st, int end) {
        if (st > end) {
            return null;
        }
        int mid = (st + end) / 2;
        Node root = new Node(arr1.get(mid));
        root.left = createBST(arr1, st, mid - 1);
        root.right = createBST(arr1, mid + 1, end);
        return root;
    }

    /// Merge two bsts O(n ) ;
    public static Node merge(Node root1, Node root2) {
        // step1
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1, arr1);

        // step2
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);

        // Final Sorted array
        ArrayList<Integer> finalArr = new ArrayList<>();
        int i = 0, j = 0;

        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) <= arr2.get(j)) {
                finalArr.add(arr1.get(i));
                i++;
            } else {
                finalArr.add(arr2.get(j));
                j++;
            }
        }
        while (i < arr1.size()) {
            finalArr.add(arr1.get(i));
            i++;
        }
        while (j < arr2.size()) {
            finalArr.add(arr2.get(j));
            j++;
        }

        // step 4
        return createBST(finalArr, 0, finalArr.size() - 1);
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + "->");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static Node createLargeSampleTree() {
        // Create the nodes
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);

        root.left.left = new Node(1);
        root.left.right = new Node(8);
        root.left.left.left = new Node(0);
        root.left.left.right = new Node(2);
        root.left.right.left = new Node(9); // Invalid placement to break BST property

        root.right.left = new Node(12);
        root.right.right = new Node(20);
        root.right.right.left = new Node(17);
        root.right.right.right = new Node(25);

        return root;
    }

    public static void main(String[] args) {
        // root 21
        Node root = new Node(5);
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right = new Node(7);
        root.right.left = new Node(6);
        root.right.right = new Node(8);

        Node sampal = createLargeSampleTree();
        System.out.println(findMaxSumInBst(sampal));

        Node root1 = new Node(10);
        root1.left = new Node(6);
        root1.left.left = new Node(3);
        root1.left.right = new Node(8);
        root1.right = new Node(15);
        root1.right.left = new Node(11);
        root1.right.right = new Node(18);

        // Node ans = merge(root, root1);
        // int sum = sumInRange(ans, 3, 9);
        // closeElement(ans, 5);
        // System.out.println(countPair(root, root1, 16));
        // System.out.println(kthSmallest(ans, 2, new int[] { 0 }));

    }

}
