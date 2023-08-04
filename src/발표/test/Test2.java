package 발표.test;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arrLength = sc.nextInt();
        if (arrLength < 3) {
            throw new IllegalArgumentException("배열 길이는 3 이상이어야 합니다.");
        }
        int[] arr = new int[arrLength];

        for (int i = 0; i < arrLength; i++) {
            arr[i] = sc.nextInt();
        }

        int result = calculateLCMSum(arr);
        System.out.println(result);
    }

    private static int calculateLCMSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int lcm = calculateLCM(arr[i], arr[j]);
                sum += lcm;
            }
        }
        return sum;
    }

    private static int calculateLCM(int a, int b) {
        int gcd = calculateGCD(a, b);
        return (a * b) / gcd;
    }

    private static int calculateGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return calculateGCD(b, a % b);
    }
}

