package Tries;

public class Implement {

    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;
        int freq;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            freq = 0;
        }
    }

    public static Node root = new Node();

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

    public static boolean search(String key) { // O(L), L = length of the key
        Node curr = root;
        for (int level = 0; level < key.length(); level++) {
            int idx = key.charAt(level) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow;
    }

    // Word break method
    public static boolean wordBreak(String key) {
        if (key.length() == 0) {
            return true;
        }
        for (int index = 1; index <= key.length(); index++) {
            if (search(key.substring(0, index)) && wordBreak(key.substring(index))) {
                return true;
            }
        }
        return false;
    }

    // Find prefix method
    public static void findPrefix(Node root, String ans) { // O(L), L = levels in the trie
        if (root == null) {
            return;
        }

        if (root.freq == 1) { // Unique prefix found
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < root.children.length; i++) {
            if (root.children[i] != null) {
                findPrefix(root.children[i], ans + (char) (i + 'a'));
            }
        }
    }

    public static void main(String[] args) {
        String words[] = { "zebra", "dog", "duck", "dove" };
        for (String word : words) {
            insert(word);
        }
        findPrefix(root, "");
    }
}
