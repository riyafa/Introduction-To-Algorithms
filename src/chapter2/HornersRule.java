package chapter2;

public class HornersRule {
    public static void main(String[] args) {
        int[] a = {1, 2};
        int x = 3;
        System.out.println(polynomial(a, x));
        System.out.println(hornersRule(a, x));
    }

    public static int polynomial(int[] a, int x) {
        int y = 0;
        for (int i = 0; i < a.length; i++) {
            y += a[i] * Math.pow(x, i);
        }
        return y;
    }

    public static int hornersRule(int[] a, int x) {
        int y = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            y = a[i] + y * x;
        }
        return y;
    }
}
