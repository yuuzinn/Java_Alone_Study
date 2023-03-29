package spring.day1;

public class Start5 {
    static int share;

    public static void main(String[] args) {
        share = 55;
        int k = fun(5, 7);
        System.out.println(share);
    }

    private static int fun(int m, int n) {
        share = m + n;
        return m - n;
    }
}
