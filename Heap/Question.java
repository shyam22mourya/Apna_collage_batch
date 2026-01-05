package Heap;

import java.util.*;

public class Question {
    // Q1 Nears Car
    static class Point implements Comparable<Point> { // O(nLog n);
        int x, y, distance, idx;

        Point(int x, int y, int distance, int idx) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p) {
            return this.distance - p.distance;
        }
        /*
         * int points[][] = { { 3, 3 }, { -2, 4 }, { 5, -1 } };
         * int k = 2;
         * PriorityQueue<Point> p = new PriorityQueue<>();
         * 
         * for (int i = 0; i < points.length; i++) {
         * int distance = points[i][0] * points[i][0] + points[i][1] * points[i][1];
         * p.add(new Point(points[i][0], points[i][1], distance, i));
         * }
         * //
         * for (int i = 0; i < k; i++) {
         * System.out.println("C" + p.remove().idx);
         * }
         * 
         */
    }

    // Q2 Connet n ropes
    public static int connectNRopes(int arr[]) {
        PriorityQueue<Integer> p = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            p.add(arr[i]);
        }

        int cost = 0;
        while (p.size() > 1) {
            int n1 = p.remove();
            int n2 = p.remove();
            int sum = n1 + n2;
            cost += sum;
            p.add(sum);
        }

        return cost;
    }

    static class Soldiar implements Comparable<Soldiar> {
        int sol; // Number of soldiers
        int idx; // Row index

        Soldiar(int sol, int idx) {
            this.sol = sol;
            this.idx = idx;
        }

        @Override
        public int compareTo(Soldiar s1) {
            // Compare based on the number of soldiers. Break ties using the row index.
            if (this.sol != s1.sol) {
                return this.sol - s1.sol;
            } else {
                return this.idx - s1.idx;
            }
        }
        /*
         * int k = 2; // Number of weakest rows to find
         * int arr[][] = {
         * { 1, 0, 0, 0 },
         * { 1, 1, 1, 1 },
         * { 1, 0, 0, 0 },
         * { 1, 0, 0, 0 }
         * };
         * 
         * // Count the number of soldiers in each row and add to the PriorityQueue
         * for (int i = 0; i < arr.length; i++) {
         * int solCount = 0;
         * for (int j =   0; j < arr[i].length; j++) {
         * if (arr[i][j] == 1) {
         * solCount++;
         * } else {
         * break; // Since soldiers (1s) are always at the beginning of the row
         * }
         * }
         * sl.add(new Soldiar(solCount, i));
         * }
         * 
         * // Retrieve the k weakest rows
         * for (int i = 0; i < k; i++) {
         * System.out.println("Weakest Row: " + sl.remove().idx);
         * }
         * 
         * }
         */
    }

    static class Pair implements Comparable<Pair> {
        int val, idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p2) {
            return p2.val - this.val;
        }
    }

    public static void slidWinMaxi(int arr[], int ans[], int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // step1 add k value ;
        for (int i = 0; i < k; i++) {
            pq.add(new Pair(arr[i], i));
        }

        // step 2 (i)
        ans[0] = pq.peek().val;
        // (ii)
        for (int i = k; i < arr.length; i++) {
            while (pq.size() > 0 && pq.peek().idx <= (i - k)) {
                     pq.remove(); 
            }

            pq.add(new Pair(arr[i], i));
            ans[i-k+1] = pq.peek().val ; 
        }
    }

    public static void main(String[] args) {
        int k = 3; // Number of weakest rows to find
        int arr[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int ans[] = new int[arr.length - k + 1];
        slidWinMaxi(arr, ans, k);
        for (int i : ans) {
            System.out.print(i + ",");
        }
    }
}
