package JavaOfGod.version2.ch23;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Practice04 {

    final static String DIR = "C:\\Users\\mycom\\Desktop\\인텔리제이\\Java_Alone_Study\\file";

    public static void main(String[] args) {
        Practice04 test = new Practice04();
        for (int i = 0; i < 10; i++) {
            test.getSixNumber();
        }

        System.out.println("------");

        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("user.dir") + "\\file");

        System.out.println(System.getProperty(DIR));

    }
    public HashSet<Integer> getSixNumber() {
        Random rd = new Random();
        HashSet<Integer> result = new HashSet<>();
        while (result.size() < 6) {
            result.add(rd.nextInt(45));
        }
        System.out.println(result);
        return result;
    }
}
