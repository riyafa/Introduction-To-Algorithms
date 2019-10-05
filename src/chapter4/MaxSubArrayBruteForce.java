package chapter4;

import java.util.Arrays;

public class MaxSubArrayBruteForce {

    public static void main(String[] args) {
        int[] A = new int[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        System.out.println(Arrays.toString(findMaxSubArray(A, 0, A.length - 1)));
    }

    public static int[] findMaxSubArray(int[] A, int low, int high) {
        int sum = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;
        for (int i = low; i <= high; i++) {
            int currentSum = 0;
            for (int j = i; j <= high; j++) {
                currentSum += A[j];
                if (sum < currentSum) {
                    sum = currentSum;
                    left = i;
                    right = j;
                }
            }
        }
        return new int[]{left, right, sum};
    }
}
