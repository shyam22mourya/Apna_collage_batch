package Heap;

import java.util.*;

public class Question1 {
    // Q1 Kth smallest elemtnt in Streams

    public static void KthLargestelement(int[] stream, int[] ans, int k) {
        // Min-heap to store the top k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < stream.length; i++) {
            // Add the current element to the heap
            minHeap.add(stream[i]);

            // If heap size exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }

            // If the heap has k elements, the root is the Kth largest
            if (minHeap.size() == k) {
                ans[i] = minHeap.peek();
            } else {
                // If heap doesn't have k elements yet, return -1
                ans[i] = -1;
            }
        }
    }

    // Q2 Minimum time require to fill given N slots
    public static int fillNSlots(int[] arr, int n) {
        boolean visit[] = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        int time = 0;
        for (int i : arr) {
            q.add(i);
            visit[i] = true;
        }

        while (q.size() > 0) {
            for (int i = 0; i < q.size(); i++) {
                int curr = q.poll();

                // left
                if (curr - 1 >= 1 && !visit[curr - 1]) {
                    q.add(curr - 1);
                    visit[curr - 1] = true;
                }
                // right
                if (curr + 1 <= n && !visit[curr + 1]) {
                    q.add(curr + 1);
                    visit[curr + 1] = true;
                }
            }
            time++;
        }
        return time - 1;
    }

    static class Cell implements Comparable<Cell> {
        int sum; // Sum of path to this cell
        int i, j; // Coordinates of the cell

        Cell(int sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Cell other) {
            return this.sum - other.sum; // Compare based on the sum
        }
    }

    // Function to find the minimum path sum
    public static int minPathSum(int[][] arr) {
        int n = arr.length; // Number of rows
        int m = arr[0].length; // Number of columns

        // Directions for up, down, left, right
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        // Priority queue to process the cell with minimum sum so far
        PriorityQueue<Cell> pq = new PriorityQueue<>();
        pq.add(new Cell(arr[0][0], 0, 0)); // Starting cell (top-left corner)

        // 2D array to store the minimum sum to reach each cell
        int[][] minSum = new int[n][m];
        for (int[] row : minSum) {
            java.util.Arrays.fill(row, Integer.MAX_VALUE); // Initialize with large value
        }
        minSum[0][0] = arr[0][0];

        // Process the grid using Dijkstra's algorithm
        while (!pq.isEmpty()) {
            Cell current = pq.poll();
            int currSum = current.sum;
            int x = current.i;
            int y = current.j;

            // If we reached the bottom-right corner, return the current sum
            if (x == n - 1 && y == m - 1) {
                return currSum;
            }

            // Explore neighbors (right, down, left, up)
            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];

                // Check if the new coordinates are within bounds
                if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
                    // Calculate the new sum
                    int newSum = currSum + arr[newX][newY];

                    // If the new sum is smaller, update and push the neighbor into the queue
                    if (newSum < minSum[newX][newY]) {
                        minSum[newX][newY] = newSum;
                        pq.add(new Cell(newSum, newX, newY));
                    }
                }
            }
        }

        return -1; // In case there is no valid path (though it's assumed to exist)
    }

    public static int halveArrSum(int[] arr) { // O(klogn) k is number of opetations
        double sum = 0;
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        // Step 1: Calculate the initial sum and populate the maxHeap
        for (int num : arr) {
            sum += num;
            maxHeap.add((double) num);
        }

        double target = sum / 2;
        int operations = 0;

        // Step 2: Perform operations until the sum is reduced to the target
        while (sum > target) {
            double currElement = maxHeap.poll();
            double halvedElement = currElement / 2;
            sum -= halvedElement;
            maxHeap.add(halvedElement);
            operations++;
        }

        return operations;
    }

    // Q 5 Merge three Linked lists
    public static LinkedList<Integer> MergeKSorted(LinkedList<Integer> l1, LinkedList<Integer> l2,
            LinkedList<Integer> l3) {

        LinkedList<Integer> merge = new LinkedList<>();
        PriorityQueue<Integer> p = new PriorityQueue<>();
        for (int i : l1) {
            p.add(i);
        }
        for (int i : l2) {
            p.add(i);
        }
        for (int i : l3) {
            p.add(i);
        }
        while (!p.isEmpty()) {
            merge.add(p.poll());
        }
        return merge;
    }

    public static void main(String[] args) {
        // int stream[][] = {
        // { 31, 100, 65, 12, 18 },
        // { 10, 13, 47, 157, 6 },
        // { 100, 113, 174, 11, 33 },
        // { 88, 124, 41, 20, 140 },
        // { 99, 32, 111, 41, 20 }
        // };
        int arr[] = { 1, 5, 8, 19 };
        System.out.println(halveArrSum(arr));
        LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();
        LinkedList<Integer> l3 = new LinkedList<>();
        l1.add(1);
        l1.add(3);
        l1.add(7);
        l2.add(2);
        l2.add(4);
        l2.add(8);
        l3.add(9);
        l3.add(10);
        l3.add(11);

        LinkedList<Integer> fin = MergeKSorted(l1, l2, l3);
        for (int i : fin) {
            System.out.print(i + "->");
        }
    }
}
