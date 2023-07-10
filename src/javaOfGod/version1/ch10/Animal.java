package javaOfGod.version1.ch10;

public abstract class Animal {
  String name;
  String kind;
  int legCount;
  int iq;
  boolean hasWing;
  public void move() {
    System.out.println(name + "가 이동합니다.");
  }
  public void eatFood() {
    System.out.println(name + "가 먹이를 먹습니다.");
  }
  public abstract void neigh();

  public void hi() {
    System.out.println();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getKind() {
    return kind;
  }

  public void setKind(String kind) {
    this.kind = kind;
  }

  public int getLegCount() {
    return legCount;
  }

  public void setLegCount(int legCount) {
    this.legCount = legCount;
  }

  public int getIq() {
    return iq;
  }

  public void setIq(int iq) {
    this.iq = iq;
  }

  public boolean isHasWing() {
    return hasWing;
  }

  public void setHasWing(boolean hasWing) {
    this.hasWing = hasWing;
  }

  @Override
  public String toString() {
    return "음.. Animal toString ..?";
  }
}
