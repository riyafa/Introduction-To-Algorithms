package chapter7;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {

    public static void main(String[] args) {
        int[] A = {2, 8, 7, 1, 3, 5, 6, 4};
        quickSort(A, 0, A.length - 1);
        System.out.println(Arrays.toString(A));
        int[] B = {2, 8, 7, 1, 3, 5, 6, 4};
        randamizedQuickSort(B, 0, B.length-1);
        System.out.println(Arrays.toString(B));
    }

    public static void quickSort(int[] A, int p, int r) {
        if (p < r) {
            int q = partition(A, p, r);
            quickSort(A, p, q - 1);
            quickSort(A, q + 1, r);
        }
    }

    public static void randamizedQuickSort(int[] A, int p, int r) {
        if (p < r) {
            int q = randomizedPartition(A, p, r);
            quickSort(A, p, q - 1);
            quickSort(A, q + 1, r);
        }
    }

    private static int randomizedPartition(int[] A, int p, int r) {
        int randomVal = ThreadLocalRandom.current().nextInt(p, r);
        exchange(A, randomVal, r);
        return partition(A, p, r);
    }

    private static int partition(int[] A, int p, int r) {
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (A[j] <= A[r]) {
                exchange(A, ++i, j);
            }
        }
        exchange(A, ++i, r);
        return i;
    }

    private static void exchange(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
