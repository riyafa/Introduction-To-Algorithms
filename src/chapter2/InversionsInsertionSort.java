package chapter2;

public class InversionsInsertionSort {
    public static void main(String[] args) {
        int[] numbers = {2, 3, 8, 6, 1};
        System.out.println(inversions(numbers));
    }

    public static int inversions(int[] numbers) {
        int count = 0;
        for (int i = 1; i < numbers.length; i++) {
            int key = numbers[i];
            int j = i - 1;
            while (j >= 0 && numbers[j] > key) {
                numbers[j + 1] = numbers[j];
                count++;
                j--;
            }
        }
        return count;
    }
}
