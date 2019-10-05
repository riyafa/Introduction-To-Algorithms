package chapter4;

import java.util.Arrays;

public class MaxSubArrayLinear {

    public static void main(String[] args) {
        int[] A = new int[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        System.out.println(Arrays.toString(findMaxSubArray(A, 0, A.length - 1)));
    }

    public static int[] findMaxSubArray(int[] A, int low, int high) {
        int sum = A[low];
        int left = 0;
        int right = 0;
        int currentSum = 0;
        int temp_left = 0;
        for (int i = low; i <= high; i++) {
            currentSum = Math.max(A[i], A[i] + currentSum);
            if (sum < currentSum) {
                sum = currentSum;
                right = i;
                left = temp_left;
            }
            if (currentSum == A[i]) {
                temp_left = i;
            }
        }
        return new int[]{left, right, sum};
    }
}
