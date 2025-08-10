package Hashing;

import java.util.*;

public class MyHashSet {
    // Q1 - Count distrinct element
    public static int coundDstelmt(int[] arr) {
        HashSet<Integer> el = new HashSet<>();
        for (int i : arr) {
            el.add(i);
        }
        return el.size();
    }

    // Q2 - Union and intertion
    public static int[] unionOrInter(int arr1[], int arr2[]) {
        // union
        HashSet<Integer> el = new HashSet<>();
        for (int i : arr1) {
            el.add(i);
        }
        for (int i : arr2) {
            el.add(i);
        }
        int union = el.size();
        // Intersation
        el.clear();
        for (int i : arr1) {
            el.add(i);
        }
        int intersation = 0;
        for (int i : arr2) {
            if (el.contains(i)) {
                intersation++;
                el.remove(i);
            }
        }
        return new int[] { union, intersation };
    }

    // Q3 - Find Itinerary from Tickets O(n)
    public static String getStart(HashMap<String, String> tickets) {
        HashMap<String, String> revmap = new HashMap<>();
        // create copy arrr
        for (String key : tickets.keySet()) {
            revmap.put(tickets.get(key), key);
        }
        // find key
        for (String key : tickets.keySet()) {
            if (!revmap.containsKey(key)) {
                return key;
            }
        }
        return null;
    }

    public static void findItiTicket(HashMap<String, String> tickets) {
        // find start
        String start = getStart(tickets);
        System.out.print(start);
        for (String key : tickets.keySet()) {
            System.out.print("->" + tickets.get(start));
            start = tickets.get(start);
        }
    }

    // Q4 Largest subArray sum with 0 ;
    public static int largestSubArraySum(int arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                ans = (i - map.get(sum) > ans ? i - map.get(sum) : ans);
            } else {
                map.put(sum, i);
            }
        }
        return ans;
    }

    // Q5 Subarray sum equal to k
    public static int subArraySum(int[] arr, int k) {
        int sum = 0;
        int ans = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        HashMap<String, String> cities = new HashMap<>();
        cities.put("Mumbai", "Delhi");
        cities.put("Chennai", "Bengluru");
        cities.put("Delhi", "Goa");
        cities.put("Goa", "Chennai");
        // findItiTicket(cities);
        int arr[] = { 15, -2, 2, -8, 1, 7, 10 };
        System.out.println(subArraySum(arr, 15));
    }
}