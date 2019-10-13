package chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PriorityQueue {
    public static void main(String[] args) throws IllegalAccessException {
        List<Integer> A = new ArrayList<>();
        Integer[] arr = {15, 13, 9, 5, 12, 8, 7, 4, 0, 6, 2, 1};
        A.addAll(Arrays.asList(arr));
        insert(A, 10);
        System.out.println(extractMax(A));
        System.out.println(A);
        delete(A, 2);
        System.out.println(A);
    }

    public static void delete(List<Integer> A, int i) {
        int last = A.size() - 1;
        A.set(i, A.get(last));
        A.remove(last);
        maxHeapifyLoop(A, i);
    }

    public static Integer maximum(List<Integer> A) {
        return A.get(0);
    }

    public static Integer extractMax(List<Integer> A) throws IllegalAccessException {
        if (A.isEmpty()) {
            throw new IllegalAccessException("Heap underflow");
        }
        Integer max = A.get(0);
        int last = A.size() - 1;
        A.set(0, A.get(last));
        A.remove(last);
        maxHeapifyLoop(A, 0);
        return max;
    }

    public static void insert(List<Integer> A, int key) throws IllegalAccessException {
        A.set(A.size() - 1, Integer.MIN_VALUE);
        increaseKey(A, A.size() - 1, key);
    }

    public static void increaseKey(List<Integer> A, int i, int key) throws IllegalAccessException {
        if (key < A.get(i)) {
            throw new IllegalAccessException("New key smaller than current key");
        }
        A.set(i, key);
        while (i > 0 && A.get(parent(i)) < A.get(i)) {
            // exchange(A, parent(i), i);
            A.set(i, A.get(parent(i)));
            i = parent(i);
        }
        A.set(i, key);
    }

    public static int parent(int i) {
        return (i - 1) >> 1;
    }

    public static int left(int i) {
        return (i << 1) + 1;
    }

    public static int right(int i) {
        return (i << 1) + 2;
    }

    public static void maxHeapifyLoop(List<Integer> A, int i) {
        int size = A.size();
        while (true) {
            int l = left(i);
            int r = right(i);
            int largest;
            if (l < size && A.get(l) > A.get(i)) {
                largest = l;
            } else {
                largest = i;
            }
            if (r < size && A.get(r) > A.get(largest)) {
                largest = r;
            }
            if (largest != i) {
                exchange(A, i, largest);
                i = largest;
            } else {
                return;
            }
        }
    }

    private static void exchange(List<Integer> A, int i, int largest) {
        int temp = A.get(i);
        A.set(i, A.get(largest));
        A.set(largest, temp);
    }
}
