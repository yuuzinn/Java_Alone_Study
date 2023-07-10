package javaOfGod.version1.ch10;

import java.util.HashMap;

public class AnimalTest {

  public static void main(String[] args) {
    Animal test = new Dog();
    test.setName("토미");
    test.setKind("강아지");
    test.setIq(40);
    test.setHasWing(false);
    test.neigh();
    System.out.println(test.getName());
    System.out.println(test);
  }
}
