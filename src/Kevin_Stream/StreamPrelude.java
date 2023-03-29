package Kevin_Stream;

public class StreamPrelude {
    public static void main(String[] args) {
        final int abs1 = Math.abs(-1);
        final int abs2 = Math.abs(1);

        System.out.println("abs1 = " + abs1);
        System.out.println("abs2 = " + abs2);
        System.out.println("abs1 == abs2 is " + (abs1 == abs2));
        final int minInt = Math.abs(Integer.MIN_VALUE);
        final int maxInt = Math.abs(Integer.MAX_VALUE);
        System.out.println("minInt = " + minInt); // minInt = -2147483648
        System.out.println("maxInt = " + maxInt);
        /**
         * 이유?
         * Java의 Integer가 32bit.
         * MAX_VALUE 와 MIN_VALUE의 차이는 1차이. (양수 음수 제외한 절대값기준)
         * MIN_VALUE는 절대값으로 뽑아도 음수로 나올 수밖에 없음. 절대값으로 뽑게 되면
         * MAX_VALUE보다 1 크기에 불가능함.
         */
    }
}
