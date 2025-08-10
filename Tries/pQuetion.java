package Tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TreeNode {
    List<String> data;
    TreeNode children[];
    boolean isEnd;

    TreeNode() {
        data = new ArrayList<>();
        children = new TreeNode[26];
        isEnd = false;
    }
}

public class pQuetion {

    static TreeNode root;
    static List<List<String>> ans;

    public static List<List<String>> groupAnagrams(String[] strs) {
        ans = new ArrayList<>();

        root = new TreeNode();

        for (String word : strs) {
            build(word);
        }

        dfs(root);

        return ans;
    }

    public static void build(String s) {
        TreeNode temp = root;
        char[] word = s.toCharArray();
        Arrays.sort(word);

        for (char c : word) {
            TreeNode child = temp.children[c - 'a'];
            if (child == null) {
                temp.children[c - 'a'] = new TreeNode();
            }
            temp = temp.children[c - 'a'];
        }
        temp.isEnd = true;
        temp.data.add(s);
    }

    public static void dfs(TreeNode rt) {
        if (rt.isEnd) {
            ans.add(rt.data);
        }

        for (int i = 0; i < 26; i++) {
            if (rt.children[i] != null) {
                dfs(rt.children[i]);
            }
        }
    }

    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> abs = groupAnagrams(strs);
        System.out.println(abs);
    }
}