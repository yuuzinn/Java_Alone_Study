package 발표.test;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        int minValue = Integer.MIN_VALUE;
        minValue = 3;

        System.out.println("minValue = " + minValue);
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        List<Map<Integer, Integer>> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < count; i++) {
            map.put(sc.nextInt(), sc.nextInt());
        }
        list.add(map);

        int maxValue = Integer.MIN_VALUE;
        List<Integer> maxKeys = new ArrayList<>();

        for (Map<Integer, Integer> item : list) {
            for (Map.Entry<Integer, Integer> entry : item.entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();

                if (value > maxValue) {
                    maxValue = value;
                    maxKeys.clear();
                    maxKeys.add(key);
                } else if (value == maxValue) {
                    maxKeys.add(key);
                }
            }
        }

        Collections.sort(maxKeys);
        if (maxKeys.size() < 2) {
            if (maxKeys.contains(1)) {System.out.println("a : " + maxValue);}
            if (maxKeys.contains(3)) {System.out.println("b : " + maxValue);}
            if (maxKeys.contains(5)) {System.out.println("c : " + maxValue);}
        } else {
            if (maxKeys.contains(1)) {
                System.out.print("a : " + maxValue);
                if (maxKeys.contains(3) || maxKeys.contains(5)) {
                    System.out.print(", ");
                }
            }
            if (maxKeys.contains(3)) {
                System.out.print("b : " + maxValue);
                if (maxKeys.contains(5)) {
                    System.out.print(", ");
                }
            }
            if (maxKeys.contains(5)) {
                System.out.print("c : " + maxValue);
            }
            System.out.println();
        }
    }
}




