package javaOfGod.version2.ch23;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetSample {
    public static void main(String[] args) {
        SetSample sample = new SetSample();
        String[] cars = new String[] {
                "Tico", "Sonata", "BMW", "Benz",
                "Lexus", "Mustang", "Grandeure",
                "The Beetle", "Mini Cooper", "i30",
                "BMW", "Lexus", "Carnival", "SM5",
                "SM7", "SM3", "Tico"
        };
        System.out.println(sample.getCarKinds(cars));
    }
//    public int getCarKinds(String[] cars) { // 내가 짠 코드
//        int count = 0;
//        Set<String> kinds = new HashSet<>();
//        for (int i = 0; i < cars.length; i++) {
//            kinds.add(cars[i]);
//        }
//        for (int i = 0; i < kinds.size(); i++) {
//            count++;
//        }
//        return count;
//    }
    public int getCarKinds(String[] cars) { // 책에 나와 있는 코드
        if (cars == null) return 0; // 확실히 null 체크부터 하는 습관을 들이는 것이 맞다.. NullPointerException 조심.
        if (cars.length == 1) return 1;
        Set<String> carSet = new HashSet<>();
        for (String car : cars) {
            carSet.add(car);
        }
        printCarSet2(carSet);
        return carSet.size();
    }

    public void printCarSet(Set<String> carSet) {
        for (String temp : carSet) {
            System.out.println(temp + " ");
        }
    }
    public void printCarSet2(Set<String> carSet) {
        Iterator<String> iterator = carSet.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}
