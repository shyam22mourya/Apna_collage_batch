
package Heap;

import java.util.*;

public class Classroom {
    static ArrayList<Integer> arr = new ArrayList<>();

    static class Heap {

        public void add(int val) {

            // add
            arr.add(val); // O(1)

            // find indexes of arr // O(1)
            int x = arr.size() - 1; // x is Index of child element ;
            int par = (x - 1) / 2; // par is Index of parent element
            while (arr.get(x) < arr.get(par)) { // O(log n);
                // swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);
                x = par;
                par = (x - 1) / 2;
            }

        }

        public int peek() { // O(n) ;
            return arr.get(0);
        }

        private static void heapify(int i) { // O(log n);

            int leftIdx = 2 * i + 1;
            int rightIdx = 2 * i + 2;
            int minIdx = i;

            if (leftIdx < arr.size() && arr.get(minIdx) > arr.get(leftIdx)) {
                minIdx = leftIdx;
            }
            if (rightIdx < arr.size() && arr.get(minIdx) > arr.get(rightIdx)) {
                minIdx = rightIdx;
            }

            // swap
            if (minIdx != i) {
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }

        public int remove() {
            int data = arr.get(0);

            // step1 swap first& last;
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            // step2 delete last index ;
            arr.remove(arr.size() - 1);

            // stwep 3 heapify
            heapify(0);

            return data;
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    public static void heapify(int[] arr, int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i;

        if (left < size && arr[maxIdx] < arr[left]) {
            maxIdx = left;
        }

        if (right < size && arr[maxIdx] < arr[right]) {
            maxIdx = right;
        }
        if (maxIdx != i) {
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapify(arr, maxIdx, size);
        }
    }

    public static void heapSort(int[] arr) {
        // step1 - build maxHeap ;
        int n = arr.length;
        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, i, n);
        }
        // step2 - push largest at end ;
        for (int i = n - 1; i >= 0; i--) {
            // swap (largest-first) with last ;
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);
        }
    }

    public static void main(String[] args) {
        // Heap hp = new Heap();
        // hp.add(3);
        // hp.add(5);
        // hp.add(2);
        // hp.add(1);

        // while (!hp.isEmpty()) {
        //     System.out.println(hp.peek());
        //     hp.remove();
        // }

        int arr[] = { 1 ,2 ,4,5,3} ; 
        heapSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
