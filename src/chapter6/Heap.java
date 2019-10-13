package chapter6;

import java.util.Arrays;

public class Heap {
    public static void main(String[] args) {
        int[] A = {16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
        System.out.println(parent(0));
        System.out.println(left(4));
        System.out.println(right(4));
        int[] B = {27, 17, 3, 16, 13, 10, 1, 5, 7, 12, 4, 8, 9, 0};
        maxHeapify(B, 2, B.length);
        System.out.println(Arrays.toString(B));
        int[] C = {27, 17, 3, 16, 13, 10, 1, 5, 7, 12, 4, 8, 9, 0};
        maxHeapifyLoop(C, 2, C.length);
        System.out.println(Arrays.toString(C));
        int[] D = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        buildMaxHeap(D);
        System.out.println(Arrays.toString(D));
        int[] E = {5, 3, 17, 10, 84, 1, 9, 6, 22, 9};
        buildMaxHeap(E);
        System.out.println(Arrays.toString(E));
        int[] F = {5, 13, 2, 25, 7, 17, 20, 8, 4};
        heapSort(F);
        System.out.println(Arrays.toString(F));
    }

    public static void heapSort(int[] A) {
        buildMaxHeap(A);
        for (int i = A.length - 1; i > 0; i--) {
            exchange(A, 0, i);
            maxHeapifyLoop(A, 0, i);
        }
    }

    public static void buildMaxHeap(int[] A) {
        for (int i = A.length / 2 - 1; i >= 0; --i) {
            maxHeapifyLoop(A, i, A.length);
        }
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

    public static void maxHeapify(int[] A, int i, int size) {
        int l = left(i);
        int r = right(i);
        int largest;
        if (l < size && A[l] > A[i]) {
            largest = l;
        } else {
            largest = i;
        }
        if (r < size && A[r] > A[largest]) {
            largest = r;
        }
        if (largest != i) {
            exchange(A, i, largest);
            maxHeapify(A, largest, size);
        }
    }


    public static void maxHeapifyLoop(int[] A, int i, int size) {
        while (true) {
            int l = left(i);
            int r = right(i);
            int largest;
            if (l < size && A[l] > A[i]) {
                largest = l;
            } else {
                largest = i;
            }
            if (r < size && A[r] > A[largest]) {
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

    private static void exchange(int[] A, int i, int largest) {
        int temp = A[i];
        A[i] = A[largest];
        A[largest] = temp;
    }

    public static void minHeapify(int[] A, int i, int size) {
        int l = left(i);
        int r = right(i);
        int smallest;
        if (l < size && A[l] < A[i]) {
            smallest = l;
        } else {
            smallest = i;
        }
        if (r < size && A[r] < A[smallest]) {
            smallest = r;
        }
        if (smallest != i) {
            exchange(A, i, smallest);
            minHeapify(A, smallest, size);
        }
    }
}
