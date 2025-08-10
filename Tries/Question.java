package Tries;

public class Question {

    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;
        int freq;

        Node() {
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
            freq = 0;
        }
    }

    public static Node root = new Node(); // Initialize the root node here.

    public static void insert(String word) { // O(L), L=length of the word ;
        Node curr = root;
        for (int level = 0; level < word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr.children[idx].freq++; // Increment frequency of the current prefix
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static boolean startsWith(String pre) {
        Node curr = root;
        for (int i = 0; i < pre.length(); i++) {
            int idx = pre.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                count += countNodes(root.children[i]);
            }
        }
        return count + 1;
    }

    public static int uniqueSubstring(String str) { // O(n^2);

        // step 1 suffix -> insert in trie ;
        for (int i = 0; i < str.length(); i++) {
            String suffix = str.substring(i);
            insert(suffix);
        }
        // step 2
        return countNodes(root);
    }

    public static String ans;

    public static void longestWordWith(Node root, StringBuilder temp) {
        if (root == null) {
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].eow) {
                char ch = (char) (i + 'a');
                temp.append(ch); // Add the character to the current word
                if (temp.length() > ans.length()) {
                    ans = temp.toString(); // Update ans if the current word is longer
                }
                longestWordWith(root.children[i], temp); // Recur for the child node
                temp.deleteCharAt(temp.length() - 1); // Backtrack to remove the last character
            }
        }
    }

    public static void main(String[] args) {
        root = new Node(); // Ensure root is initialized.

        String words[] = { "apple", "a", "app", "appl", "ap", "apply" };
        for (String word : words) {
            insert(word);
        }
        ans = "";
        longestWordWith(root, new StringBuilder(""));
        System.out.println(ans);
    }
}
