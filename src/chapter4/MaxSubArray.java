package chapter4;

import java.util.Arrays;

public class MaxSubArray {

    public static void main(String[] args) {
        int[] A = new int[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        System.out.println(Arrays.toString(findMaxSubArray(A, 0, A.length - 1)));
    }

    public static int[] findMaxSubArray(int[] A, int low, int high) {
        if (high == low) {
            return new int[]{low, high, A[low]};
        }
        int mid = (low + high) / 2;
        int[] leftVals = findMaxSubArray(A, low, mid);
        int[] rightVals = findMaxSubArray(A, mid + 1, high);
        int[] crossVals = findMaxCrossing(A, low, mid, high);
        if (leftVals[2] > rightVals[2] && leftVals[2] > crossVals[2]) {
            return leftVals;
        } else if (rightVals[2] > leftVals[2] && rightVals[2] > crossVals[2]) {
            return rightVals;
        } else {
            return crossVals;
        }
    }

    public static int[] findMaxCrossing(int[] A, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        int maxLeft = -1;
        for (int i = mid; i >= low; i--) {
            sum += A[i];
            if (sum > leftSum) {
                maxLeft = i;
                leftSum = sum;
            }
        }

        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        int maxRight = -1;
        for (int i = mid + 1; i <= high; i++) {
            sum += A[i];
            if (sum > rightSum) {
                maxRight = i;
                rightSum = sum;
            }
        }
        return new int[]{maxLeft, maxRight, leftSum + rightSum};
    }
}
