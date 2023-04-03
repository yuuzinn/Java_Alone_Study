package JavaOfGod.version2.ch20;

/**
 * 123aa is not a number
 * -1
 * Original : 1024
 * Binary   : 10000000000
 * Hex      : 400
 * Octal    : 2000
 */

public class Practice01 {
    public static void main(String[] args) {
        Practice01 test = new Practice01();
        long solution = test.parseLong("123aa");
        System.out.println(solution);

        test.printOtherBase(1024);
    }
    public long parseLong(String data) {
        try {
            long isNum = Long.parseLong(data);
            return isNum;
        } catch (NumberFormatException e) {
            System.out.println(data + " is not a number");
            return -1;
        }
    }

    public void printOtherBase(long value) {
        Long num1 = Long.valueOf(Long.toBinaryString(value));
        Long num2 = Long.valueOf(Long.toHexString(value));
        Long num3 = Long.valueOf(Long.toOctalString(value));
        System.out.printf("%-8s : %d \n","Original", value);
        System.out.printf("%-8s : %d \n", "Binary" ,num1);
        System.out.printf("%-8s : %d \n", "Hex" ,num2 );
        System.out.printf("%-8s : %d", "Octal", num3);
    }
}
