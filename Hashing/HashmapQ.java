package Hashing;

import java.util.*;

public class HashmapQ {

    // Q1 mejority element
    public static int mejorityElment(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) > arr.length / 3) {
                return key;
            }
        }
        return -1;
    }

    public static boolean isAnalagram(String s1, String s2) { //O(n) O(n)
        if (s1.length() != s2.length()) {
            System.out.println("false ; ");
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            if (map.containsKey(ch)) {
                if (map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.get(ch) - 1);
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }

    public static void main(String[] args) {
        String s = "race";
        String t = "cape";
        System.out.println(isAnalagram(s, t));
    }
}
