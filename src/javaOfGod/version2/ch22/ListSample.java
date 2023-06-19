package javaOfGod.version2.ch22;

import java.util.ArrayList;

public class ListSample {
    public static void main(String[] args) {
        ListSample sample = new ListSample();
//        sample.checkArrayList2();
//        sample.checkArrayList3();
//        sample.checkArrayList4();
//        sample.checkArrayList5();
//        sample.checkArrayList6();
//        sample.checkArrayList7();
        sample.checkArrayList8();
    }

    public void checkArrayList1() {
        ArrayList<String> list1 = new ArrayList<>(); // 초기 크기는 10. 넘어가면 자동으로 늘어나지만, 애플리케이션에 영향을 준다.
        // 따라서 어느정도 크기가 예상이 된다면, 해당 크기에 맞춰서 크기를 지정해주는 것이 더 좋겠다.
//        list1.add(new Object());
        list1.add("ArrayListSample");
//        list1.add(new Double(1));
    }
    public void checkArrayList2() {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add(1, "A1");
        for (String s : list) {
            System.out.println(s);
        }
    }
    public void checkArrayList3() {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add(1, "A1");
        ArrayList<String> list2 = new ArrayList<>(); // 복사 하려고 하는 부분.. 하지만 밑의 방식으로 가능하다.
        list2.add("0 ");
        list2.addAll(list);
        ArrayList<String> list3 = new ArrayList<>(list); // 복사함.
        for (String s : list2) {
            System.out.println("LIST2 : " + s);
        }
    }
    public void checkArrayList4() {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");

        ArrayList<String> list2 = list;
        list.add("Oops");
        for (String s : list2) {
            System.out.println("List2 : " + s);
        }
        // 예상 결과 : List2 : A
        // 하지만 A와 Oops 둘 다 출력된다...
        // 이유 ? list 라는 객체가 생성되어 참조되고 있는 주소까지도 사용하겠다는 말이기에..
    }
    public void checkArrayList5() {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        int listSize = list.size();
        for (int i = 0; i < listSize; i++) {
            System.out.println("list.get(" + i + ") = " + list.get(i));
        }
    }
    public void checkArrayList6() {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        String[] strList = list.toArray(new String[0]);
        System.out.println(strList[0]);
    }
    public void checkArrayList7() {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        String[] tempArr = new String[5];
        String[] strList = list.toArray(tempArr);
        for (String temp : strList) {
            System.out.println(temp);
        }
    }
    public void checkArrayList8() {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("A");
//        System.out.println("Remove " + list.remove(0));
//        System.out.println(list.remove("A"));
        ArrayList<String> temp = new ArrayList<>();
        temp.add("A");
        list.removeAll(temp);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("list.get(" + i + ") = " + list.get(i));
        }
    }
}
