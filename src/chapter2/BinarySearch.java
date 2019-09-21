package chapter2;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 4, 6, 1, 3, -5, 88};
        MergeSort.mergeSort(numbers, 0, numbers.length - 1);
        System.out.println(Arrays.toString(numbers));
        System.out.println(binarySearch(numbers, -5));
        System.out.println(binarySearchNonRecursive(numbers, -5));
    }

    public static Integer binarySearch(int[] numbers, int v) {
        return binarySearch(numbers, v, 0, numbers.length - 1);
    }

    public static Integer binarySearch(int[] numbers, int v, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        if (v == numbers[mid]) {
            return mid;
        } else if (v < numbers[mid]) {
            return binarySearch(numbers, v, start, mid - 1);
        } else {
            return binarySearch(numbers, v, mid + 1, end);
        }
    }

    public static int binarySearchNonRecursive(int[] numbers, int search) {
        int start = 0;
        int end = numbers.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (numbers[mid] == search) {
                return mid;
            } else if (search < numbers[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
