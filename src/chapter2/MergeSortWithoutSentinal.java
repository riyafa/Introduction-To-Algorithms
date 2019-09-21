package chapter2;

import java.util.Arrays;

public class MergeSortWithoutSentinal {
    public static void main(String[] args) {
        int[] A = {5, 2, 4, 7, 1, 3, 2, 6};
//        int[] A = {3, 41, 52, 26, 38, 57, 9, 49};
        mergeSort(A, 0, A.length - 1);
        System.out.println(Arrays.toString(A));
    }

    public static void mergeSort(int[] A, int p, int r) {
        int q = (p + r) / 2;
        if (p < r) {
            mergeSort(A, p, q);
            mergeSort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    public static void merge(int[] A, int p, int q, int r) {
        int[] L = Arrays.copyOfRange(A, p, q + 1);
        int[] R = Arrays.copyOfRange(A, q + 1, r + 1);
        int i = 0;
        int j = 0;
        int k;
        for (k = p; i < L.length && j < R.length; k++) {
            if (L[i] <= R[j]) {
                A[k] = L[i++];
            } else {
                A[k] = R[j++];
            }
        }

        if (i < L.length) {
            while (k <= r) {
                A[k++] = L[i++];
            }
        } else {
            while (k <= r) {
                A[k++] = R[j++];
            }
        }
    }
}