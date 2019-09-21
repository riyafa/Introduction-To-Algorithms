package chapter2;

public class LinearSearch {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 4, 6, 1, 3};

        System.out.println(linearSearch(numbers, 3));
    }

    public static Integer linearSearch(int[] numbers, int v) {
        for (int i = 0; i < numbers.length; i++) {
            if (v == numbers[i]) {
                return i;
            }
        }
        return null;
    }
}
