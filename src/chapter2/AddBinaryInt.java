package chapter2;

import java.util.Arrays;

public class AddBinaryInt {
    public static void main(String[] args) {
        int[] firstNum = {1, 1, 1, 0, 0};
        int[] secondNum = {1, 1, 1, 1, 0};
        System.out.println(Arrays.toString(addNum(firstNum, secondNum)));
        System.out.println(Arrays.toString(addNumSimplified(firstNum, secondNum)));
    }

    public static int[] addNum(int[] firstNum, int[] secondNum) {
        int[] result = new int[firstNum.length + 1];
        int digitSum, carry = 0, i;
        for (i = firstNum.length - 1; i >= 0; i--) {
            digitSum = firstNum[i] + secondNum[i] + carry;
            if (digitSum == 0 || digitSum == 2) {
                result[i + 1] = 0;
            } else {
                result[i + 1] = 1;
            }
            if (digitSum == 2 || digitSum == 3) {
                carry = 1;
            } else {
                carry = 0;
            }
        }
        result[0] = carry;
        return result;
    }

    public static int[] addNumSimplified(int[] firstNum, int[] secondNum) {
        int[] result = new int[firstNum.length + 1];
        int digitSum, carry = 0, i;
        for (i = firstNum.length - 1; i >= 0; i--) {
            digitSum = firstNum[i] + secondNum[i] + carry;
            result[i + 1] = digitSum % 2;
            carry = digitSum / 2;
        }
        result[0] = carry;
        return result;
    }
}
