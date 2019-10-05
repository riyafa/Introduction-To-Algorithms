package chapter4;

import java.util.Arrays;

public class MatrixMultiplicationStrassen {

    public static void main(String[] args) {
        /*int[][] A = new int[][]{{1, 3}, {7, 5}};
        int[][] B = new int[][]{{6, 8}, {4, 2}};*/
        int[][] A = new int[][]{{13, -3, -25, 20}, {-3, -16, -23, 18}, {20, -7, 12, -5}, {-22, 15, -4, 7}};
        int[][] B = new int[][]{{13, 10, 11, 12}, {13, 14, -23, 18}, {20, -7, 12, -11}, {-12, -13, -14, 7}};
        System.out.println(Arrays.deepToString(
                strassenMultiply(A, B, 0, 0, 0, 0, A.length)
        ));

    }

    public static int[][] strassenMultiply(int[][] A, int[][] B, int rowA, int colA, int rowB, int colB, int size) {
        int[][] C = new int[size][size];
        if (size == 1) {
            C[0][0] = A[rowA][colA] * B[rowB][colB];
        } else {
            int newSize = size / 2;
            int[][] S1 = sub(B, B, rowB, colB + newSize, rowB + newSize, colB + newSize, newSize);
            int[][] S2 = add(A, A, rowA, colA, rowA, colA + newSize, newSize);
            int[][] S3 = add(A, A, rowA + newSize, colA, rowA + newSize, colA + newSize, newSize);
            int[][] S4 = sub(B, B, rowB + newSize, colB, rowB, colB, newSize);
            int[][] S5 = add(A, A, rowA, colA, rowA + newSize, colA + newSize, newSize);
            int[][] S6 = add(B, B, rowB, colB, rowB + newSize, colB + newSize, newSize);
            int[][] S7 = sub(A, A, rowA, colA + newSize, rowA + newSize, colA + newSize, newSize);
            int[][] S8 = add(B, B, rowB + newSize, colB, rowB + newSize, colB + newSize, newSize);
            int[][] S9 = sub(A, A, rowA, colA, rowA + newSize, colA, newSize);
            int[][] S10 = add(B, B, rowB, colB, rowB, colB + newSize, newSize);

            int[][] P1 = strassenMultiply(A, S1, rowA, colA, 0, 0, newSize);
            int[][] P2 = strassenMultiply(S2, B, 0, 0, rowB + newSize, colB + newSize, newSize);
            int[][] P3 = strassenMultiply(S3, B, 0, 0, rowB, colB, newSize);
            int[][] P4 = strassenMultiply(A, S4, rowA + newSize, colA + newSize, 0, 0, newSize);
            int[][] P5 = strassenMultiply(S5, S6, 0, 0, 0, 0, newSize);
            int[][] P6 = strassenMultiply(S7, S8, 0, 0, 0, 0, newSize);
            int[][] P7 = strassenMultiply(S9, S10, 0, 0, 0, 0, newSize);

            int[][] C1 = add(sub(add(P5, P4), P2), P6);
            int[][] C2 = add(P1, P2);
            int[][] C3 = add(P3, P4);
            int[][] C4 = sub(sub(add(P5, P1), P3), P7);

            join(C1, C, 0, 0);
            join(C2, C, 0, newSize);
            join(C3, C, newSize, 0);
            join(C4, C, newSize, newSize);
        }
        return C;
    }

    private static void join(int[][] C1, int[][] C, int row, int col) {
        int size = C1.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                C[i + row][j + col] = C1[i][j];
            }
        }
    }


    private static int[][] add(int[][] A, int[][] B) {
        int[][] C = new int[A.length][B.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }

    private static int[][] add(int[][] A, int[][] B, int rowA, int colA, int rowB, int colB, int size) {
        int[][] C = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                C[i][j] = A[rowA + i][colA + j] + B[rowB + i][colB + j];
            }
        }
        return C;
    }

    private static int[][] sub(int[][] A, int[][] B) {
        int[][] C = new int[A.length][B.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                C[i][j] = A[i][j] - B[i][j];
            }
        }
        return C;
    }

    private static int[][] sub(int[][] A, int[][] B, int rowA, int colA, int rowB, int colB, int size) {
        int[][] C = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                C[i][j] = A[rowA + i][colA + j] - B[rowB + i][colB + j];
            }
        }
        return C;
    }
}
