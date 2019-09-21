package chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertionBinarySort {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.addAll(Arrays.asList(1, 5, 2, 4, 6, 1, 3, 7, 9, 2, 2, 2, 10, 3, 3));
        insertionSortA(numbers);
        System.out.println(numbers);
    }

    public static void insertionSortA(List<Integer> numbers) {
        int size = numbers.size();
        for (int i = 1; i < size; i++) {
            int key = numbers.remove(i);
            int loc = binarySearch(numbers, key, 0, i - 1);
            numbers.add(loc, key);
        }
    }

    public static Integer binarySearch(List<Integer> numbers, int v, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            int midVal = numbers.get(mid);
            if (v == midVal) {
                return mid;
            } else if (v < midVal) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
