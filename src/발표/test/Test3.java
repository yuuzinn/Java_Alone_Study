package 발표.test;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int result = 0;
        if (number < 4) {
            throw new IllegalArgumentException("주어질 수는 4 이상이어야 합니다.");
        }
        for (int i = 1; i <= number; i++) {
            boolean decimal = isDecimal(i);
            if (decimal) {
                result = result + i;
            }
        }
        System.out.println(result);
    }
    public static boolean isDecimal(int a) {
        if (a < 2) return false;
        if (a == 2) return true;

        for (int i = 2; i < a; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }
}
