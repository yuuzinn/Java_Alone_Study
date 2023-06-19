package javaResearch.array;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
  public static void main(String[] args) {
    ArrayList<String> list1 = new ArrayList<>();
    for (int i = 0; i < 11; i++) {
      list1.add(i + "번째 더하기");
    }
  }
}
