package Heap;

import java.util.*;

class Heap {
    ArrayList<Integer> arr = new ArrayList<>();

    public void insert(int data) {
        arr.add(data);
        int child = arr.size() - 1;
        int par = (child - 1) / 2;
        while (arr.get(child) > arr.get(par)) {
            int temp = arr.get(child);
            arr.set(child, arr.get(par));
            arr.set(par, temp);

            child = par;
            par = (child - 1) / 2;
        }
    }

    public int peek() {
        return arr.get(0);
    }

    public void remove() {
        // step 1 first & last;
        int temp = arr.get(0);
        arr.set(0, arr.get(arr.size() - 1));
        arr.set(arr.size() - 1, temp);

        arr.remove(arr.size() - 1);

        // step2
        heapify1(0);

    }

    public void heapify1(int ind) {
        int min = ind;
        int left = ind * 2 + 1;
        int right = ind * 2 + 2;

        if (left < arr.size() && arr.get(min) > arr.get(left)) {
            min = left;
        }
        if (right < arr.size() && arr.get(min) > arr.get(right)) {
            min = right;
        }
        if (min != ind) {
            int temp = arr.get(ind);
            arr.set(ind, arr.get(min));
            arr.set(min, temp);

            heapify1(min);
        }
    }

    public boolean isEmpty() {
        return arr.size() == 0;
    }

}


public class priorityQueue {
    static class Student implements Comparable<Student> { // overiding
        String name;
        int rank;

        Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            return s2.rank - this.rank;
        }

    }

    public static void heapify(int[] arr, int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max = i;

        if (left < size && arr[left] < arr[max]) {
            max = left;
        }
        if (right < size && arr[right] < arr[max]) {
            max = right;
        }

        if (max != i) {
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;

            heapify(arr, max, size);
        }

    }

    public static void heapSort(int[] arr) {
        // step 1 convert to maxHeap
        int n = arr.length;
        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, i, n);
        }

        // step2 swap to maxElement to last ;
        for (int i = n - 1; i >= 0; i--) {

            // swap (largest-first) with last ;
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);
        }
    }

    public static void main(String[] args) {
        // PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());
        // pq.add(new Student("A", 23));
        // pq.add(new Student("B", 21));
        // pq.add(new Student("C", 29));
        // pq.add(new Student("D", 15));
        // while (!pq.isEmpty()) {
        // System.out.println(pq.peek().name + "->" + pq.poll().rank);
        // }

        // Heap heap = new Heap();
        // heap.insert(5);
        // heap.insert(2);
        // heap.insert(1);
        // heap.insert(10);
        // heap.insert(7);
        // heap.insert(8);

        // while (!heap.isEmpty()) {
        // System.out.print(heap.peek() + " ");
        // heap.remove();
        // }
        int[] arr = { 1, 5, 4, 2, 3 };
        heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}