package chapter2;

import java.util.Arrays;

public class InsertionSortRecursive {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 4, 6, 1, 3};
        insertionSortA(numbers, numbers.length);
        System.out.println(Arrays.toString(numbers));
    }

    public static void insertionSortA(int[] numbers, int i) {
        if (i <= 1) {
            return;
        }
        insertionSortA(numbers, i - 1);
        int key = numbers[i - 1];
        int j = i - 2;
        while (j >= 0 && numbers[j] > key) {
            numbers[j + 1] = numbers[j];
            j--;
        }
        numbers[j + 1] = key;
    }
}
