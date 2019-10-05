package chapter4;

import java.util.Arrays;

public class MatrixMultiplication {

    public static void main(String[] args) {
        int[][] A = new int[][]{{13, -3, -25, 20}, {-3, -16, -23, 18}, {20, -7, 12, -5}, {-22, 15, -4, 7}};
        int[][] B = new int[][]{{13, 10, 11, 12}, {13, 14, -23, 18}, {20, -7, 12, -11}, {-12, -13, -14, 7}};
        System.out.println(Arrays.deepToString(multiplyMatrix(A, B)));
    }

    public static int[][] multiplyMatrix(int[][] A, int[][] B) {
        int[][] C = new int[A.length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                C[i][j] = 0;
                for (int k = 0; k < A.length; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }
}
