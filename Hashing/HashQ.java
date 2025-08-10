package Hashing;

import java.util.*;

public class HashQ {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    static class Info {
        Node root;
        int hd;

        public Info(Node root, int hd) {
            this.root = root;
            this.hd = hd;
        }
    }

    // Q1
    public static void bottomView(Node root) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        HashMap<Integer, Integer> map = new HashMap<>(); // Store horizontal distance and node data
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(root, 0));

        while (!q.isEmpty()) {
            Info curr = q.remove();

            // Update the map with the current node's data
            map.put(curr.hd, curr.root.data);

            // Update min and max horizontal distances
            min = Math.min(min, curr.hd);
            max = Math.max(max, curr.hd);

            // Add left and right children to the queue
            if (curr.root.left != null) {
                q.add(new Info(curr.root.left, curr.hd - 1));
            }

            if (curr.root.right != null) {
                q.add(new Info(curr.root.right, curr.hd + 1));
            }
        }

        // Print the bottom view from min to max horizontal distance
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i) + " ");
        }
    }

    // Q2 two sum
    public static void twoSum(int arr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < arr.length; i++) {
            int num = k - arr[i];
            if (map.containsKey(num)) {
                ans[0] = map.get(num);
                ans[1] = i;
            }
            map.put(arr[i], i);
        }
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    // public static void countByFre(String str) {
    //     TreeMap<Character, Integer>map = new TreeMap<>();
    //     for (int i = 0; i < str.length(); i++) {
    //         char ch = str.charAt(i);
    //         map.put(ch, map.getOrDefault(ch, 0) + 1);
    //     }
       

    // }

    public static void main(String[] args) {
        // Node root = new Node(1);
        // root.left = new Node(2);
        // root.right = new Node(3);
        // root.left.left = new Node(4);
        // root.left.right = new Node(5);
        // root.right.left = new Node(6);
        // root.right.right = new Node(7);
        // bottomView(root);
        int arr[] = { 2, 7, 11, 15 };
        twoSum(arr, 9);
    }
}
