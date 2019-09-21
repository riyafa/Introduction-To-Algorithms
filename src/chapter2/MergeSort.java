package chapter2;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] A = {5, 2, 4, 7, 1, 3, 2, 6};
        mergeSort(A, 0, A.length - 1);
        System.out.println(Arrays.toString(A));
    }

    public static void mergeSort(int[] A, int start, int end) {
        int mid = (start + end) / 2;
        if (start < end) {
            mergeSort(A, start, mid);
            mergeSort(A, mid + 1, end);
            merge(A, start, mid, end);
        }
    }

    public static void merge(int[] A, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];
        for (int i = 0; i < n1; i++) {
            L[i] = A[start + i];
        }
        L[n1] = Integer.MAX_VALUE;
        for (int i = 0; i < n2; i++) {
            R[i] = A[mid + i + 1];
        }
        R[n2] = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        for (int k = start; k <= end; k++) {
            if (L[i] <= R[j]) {
                A[k] = L[i++];
            } else {
                A[k] = R[j++];
            }
        }
    }
}
