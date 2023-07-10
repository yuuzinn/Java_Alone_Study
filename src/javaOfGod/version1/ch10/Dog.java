package javaOfGod.version1.ch10;

public class Dog extends Animal{
  @Override
  public void neigh() {
//    System.out.println("왈ㄹ왈ㄹ옹랑올알ㄹ");
  }

  @Override
  public String toString() {
    return name + "입니다. 종류는 " + kind + "이고요." + " 날개는 " + hasWing + "입니다.";
  }
}
