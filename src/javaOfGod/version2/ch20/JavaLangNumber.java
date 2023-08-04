package javaOfGod.version2.ch20;

import java.util.HashMap;
import java.util.Map;

public class JavaLangNumber {
    public static void main(String[] args) {
        JavaLangNumber sample = new JavaLangNumber();
        sample.numberTypeCheck();
        sample.numberTypeCheck2();
        Map<String, String> map = new HashMap<>();
//        map.equals()
    }

    public void numberTypeCheck2() {
        Integer refInt1;
        refInt1 = 100;
        System.out.println(refInt1.doubleValue());
    }

    public void numberTypeCheck() {
        String value1 = "3";
        String value2 = "5";
        byte byte1 = Byte.parseByte(value1);
        byte byte2 = Byte.parseByte(value2);
        System.out.println(byte1+byte2);

        Integer refInt1 = Integer.valueOf(value1);
        Integer refInt2 = Integer.valueOf(value2);
        System.out.println(refInt1+refInt2 + "7");
    }
}
